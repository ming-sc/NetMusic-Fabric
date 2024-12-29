package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.config.GeneralConfig;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import net.minecraft.client.sound.AudioStream;
import org.lwjgl.BufferUtils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.concurrent.*;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class Mp3AudioStream implements AudioStream {
    private final AudioInputStream stream;
    private final int frameSize;
    private final byte[] frame;
    private boolean isPlaying;

    public Mp3AudioStream(URL url) throws UnsupportedAudioFileException, IOException {
        URLConnection connection = url.openConnection();
        // 设置连接超时时间和读取超时时间
        connection.setConnectTimeout(500);
        connection.setReadTimeout(500);
        InputStream inputStream = connection.getInputStream();

        AudioInputStream originalInputStream = new MpegAudioFileReader().getAudioInputStream(inputStream);
        AudioFormat originalFormat = originalInputStream.getFormat();
        AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, originalFormat.getSampleRate(), 16,
                originalFormat.getChannels(), originalFormat.getChannels() * 2, originalFormat.getSampleRate(), false);
        AudioInputStream targetInputStream = AudioSystem.getAudioInputStream(targetFormat, originalInputStream);
        if (GeneralConfig.ENABLE_STEREO) {
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, originalFormat.getSampleRate(), 16,
                    1, 2, originalFormat.getSampleRate(), false);
            this.stream = AudioSystem.getAudioInputStream(targetFormat, targetInputStream);
        } else {
            this.stream = targetInputStream;
        }
        this.frameSize = stream.getFormat().getFrameSize();
        this.isPlaying = true;
        frame = new byte[frameSize];
    }

    @Override
    public AudioFormat getFormat() {
        return stream.getFormat();
    }

    /**
     * 从流中读取音频数据，并返回一个最多包含指定字节数的字节缓冲区。
     * 该方法从流中读取音频帧并将其添加到输出缓冲区，直到缓冲区至少
     * 包含指定数量的字节或到达流的末尾。
     *
     * @param size 要读取的最大字节数
     * @return 字节缓冲区，最多包含要读取的指定字节数
     * @throws IOException 如果在读取音频数据时发生I/O错误
     */
    @Override
    public ByteBuffer getBuffer(int size) throws IOException {
        // 创建指定大小的ByteBuffer
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(size);
        if (isPlaying) {
            CompletableFuture<Object> future = new CompletableFuture<>().completeAsync(() -> {
                try {
                    // 循环读取数据直到达到指定大小或输入流结束
                    int bytesRead = 0, count = 0;
                    do {
                        // 读取下一部分数据
                        count = this.stream.read(frame);
                        // 将读取的数据写入ByteBuffer
                        if (count != -1) {
                            byteBuffer.put(frame);
                        }
                    } while (count != -1 && (bytesRead += frameSize) < size);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return null;
            });

            try {
                future.get(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                future.cancel(true);
                this.isPlaying = false;
                e.printStackTrace();
            }
        }

        // 翻转ByteBuffer，准备进行读取操作
        byteBuffer.flip();
        // 返回包含读取数据的ByteBuffer
        return byteBuffer;
    }

    @Override
    public void close() throws IOException {
        stream.close();
        this.isPlaying = false;
    }
}
