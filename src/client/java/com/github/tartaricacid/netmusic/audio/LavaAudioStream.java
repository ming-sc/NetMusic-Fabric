package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.NetMusicClient;
import com.sedmelluq.discord.lavaplayer.format.AudioDataFormat;
import com.sedmelluq.discord.lavaplayer.format.AudioPlayerInputStream;
import com.sedmelluq.discord.lavaplayer.format.transcoder.AudioChunkDecoder;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.minecraft.client.sound.AudioStream;
import org.apache.commons.io.IOUtils;
import org.lwjgl.BufferUtils;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats.COMMON_PCM_S16_BE;

/**
 * @author : IMG
 * @code @Description : 来自 su226/jukebox 的 LavaPlayerAudioStream, 有一些改动
 * @create : 2024/10/13
 */
public class LavaAudioStream implements AudioStream {
    private AudioPlayer player;
    private AudioFormat format = new AudioFormat(48000, 16, 1, true, false);;
    private AudioChunkDecoder decoder;
    private ShortBuffer buffer;
    private int channels;

//    private final AudioInputStream stream;
//    private byte[] array = null;
//    private int offset;

    public LavaAudioStream(AudioPlayer player) throws Exception{
        this.player = player;

//        this.format = new AudioFormat(44100, 16, 2, true, false);
//        System.out.println(1);

//        AudioDataFormat format = NetMusicClient.manager.getConfiguration().getOutputFormat();
//        AudioInputStream stream = AudioPlayerInputStream.createStream(player, format, 10000L, false);
//        this.stream = stream;
//        System.out.println(2);
//        this.array = IOUtils.toByteArray(stream);

//        AudioFrame frame = null;
//        try {
//            frame = this.player.provide(20, TimeUnit.MILLISECONDS);
//        } catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        if (frame == null) {
//            throw new RuntimeException("frame is null");
//        }
//        this.array = frame.getData();
//        AudioDataFormat format = frame.getFormat();
//        this.decoder = format.createDecoder();
//        this.format = new AudioFormat(format.sampleRate, 16, 1, true, false);
//        System.out.println(3);
//        System.out.println(Arrays.toString(array));

//        this.offset = 0;
        fillBuffer();
    }

    private boolean fillBuffer() {
        AudioFrame frame = null;
        try {
            frame = this.player.provide(500, TimeUnit.MICROSECONDS);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (frame == null) {
            return false;
        }
        if (decoder == null) {
            System.out.println("format" + this.format);
            AudioDataFormat format = frame.getFormat();
            this.decoder = format.createDecoder();
//            this.format = new AudioFormat(format.sampleRate, 16, 1, true, false);
            this.format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.sampleRate, 16, 2, format.channelCount * 2, format.sampleRate, false);
            // TODO: 重点关注
            this.buffer = ByteBuffer.allocateDirect(Short.BYTES * format.totalSampleCount()).order(ByteOrder.nativeOrder()).asShortBuffer();
//            this.channels = format.channelCount;
            this.channels = 1;
            System.out.println("format: " + this.format);
            System.out.println("channels: " + this.channels);

        }
        this.buffer.clear();
        this.decoder.decode(frame.getData(), this.buffer);
        return true;
    }

    @Override
    public AudioFormat getFormat() {
        return this.format;

//        System.out.println("format: " + this.stream.getFormat());
//        return this.stream.getFormat();
    }

    @Override
    public ByteBuffer getBuffer(int size) throws IOException {
        ByteBuffer out = ByteBuffer.allocateDirect(size).order(ByteOrder.LITTLE_ENDIAN);
        while (out.position() < size) {
            if ((this.buffer != null && this.buffer.hasRemaining()) || this.fillBuffer()) {
                int sample = 0;
                for (int i = 0; i < this.channels; i++) {
                    sample += this.buffer.get();
                }
                out.putShort((short) (sample / (this.channels)));
//                out.putShort((short) sample);
            } else {
                out.putShort((short) 0);
            }
        }
        out.rewind();
        return out;


//        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(size);
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size).order(ByteOrder.LITTLE_ENDIAN);
//        if (array.length >= offset + size) {
//            byteBuffer.put(array, offset, size);
//        } else {
//            byteBuffer.put(new byte[size]);
//        }
//        offset += size;


//        byte[] buffer = new byte[size];
//        int chunkSize;
//        if ((chunkSize = stream.read(buffer)) >= 0) {
//            byteBuffer.put(buffer, 0, chunkSize);
//        }
////        System.out.println(Arrays.toString(buffer));
//        byteBuffer.flip();
//        return byteBuffer;
    }

    @Override
    public void close() throws IOException {
        if (this.decoder != null) {
            this.decoder.close();
        }
        player.stopTrack();
        player.destroy();
//        stream.close();
    }
}
