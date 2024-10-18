package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.NetMusicClient;
import com.sedmellug.discord.lavaplayer.format.AudioPlayerInputStream;
import com.sedmelluq.discord.lavaplayer.filter.AudioFilter;
import com.sedmelluq.discord.lavaplayer.filter.FloatPcmAudioFilter;
import com.sedmelluq.discord.lavaplayer.filter.PcmFilterFactory;
import com.sedmelluq.discord.lavaplayer.filter.UniversalPcmAudioFilter;
import com.sedmelluq.discord.lavaplayer.format.AudioDataFormat;
import com.sedmelluq.discord.lavaplayer.format.AudioDataFormatTools;
import com.sedmelluq.discord.lavaplayer.format.Pcm16AudioDataFormat;
import com.sedmelluq.discord.lavaplayer.format.transcoder.AudioChunkDecoder;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.TrackStateListener;
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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats.COMMON_PCM_S16_BE;
import static com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats.COMMON_PCM_S16_LE;

/**
 * @author : IMG
 * @code @Description : 来自 su226/jukebox 的 LavaPlayerAudioStream, 有一些改动
 * @create : 2024/10/13
 */
public class LavaAudioStream extends AudioEventAdapter implements AudioStream, TrackStateListener {
    private AudioPlayer player;
    private AudioFormat format = new AudioFormat(44100, 16, 2, true, false);
    private AudioChunkDecoder decoder;
    private ShortBuffer buffer;
    private int channels;

    private final AudioPlayerInputStream stream;
    private int maxBufferSize = 176400;
    private ByteBuffer byteBuffer = ByteBuffer.allocateDirect(maxBufferSize).order(ByteOrder.LITTLE_ENDIAN);
    private byte[] tempBuffer = new byte[maxBufferSize];
//    private byte[] array = null;
//    private int offset;
//    private AudioPlayerInputStream stream;

    public LavaAudioStream(AudioPlayer player) throws Exception{
        this.player = player;

        player.addListener(this);
        player.setFilterFactory(new StereoToMonoFilterFactory());
        stream = new AudioPlayerInputStream(COMMON_PCM_S16_LE, player, 0, true);

//        stream = AudioPlayerInputStream.createStream(player, COMMON_PCM_S16_LE, 0, true);
//        AudioFormat format = stream.getFormat();
        AudioFormat format = AudioDataFormatTools.toAudioFormat(new Pcm16AudioDataFormat(2, COMMON_PCM_S16_LE.sampleRate, COMMON_PCM_S16_LE.chunkSampleCount, false));
        this.format = format;
//        this.format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), 16, 2, format.getChannels() * 2, format.getSampleRate(), false);

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
        System.out.println("create LavaAudioStream");
    }

    @Override
    public void onTrackException(AudioPlayer player, AudioTrack track, FriendlyException exception) {
        super.onTrackException(player, track, exception);
        if (player == this.player) {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
//        ByteBuffer out = ByteBuffer.allocateDirect(size).order(ByteOrder.LITTLE_ENDIAN);
//        while (out.position() < size) {
//            if ((this.buffer != null && this.buffer.hasRemaining()) || this.fillBuffer()) {
//                int sample = 0;
//                for (int i = 0; i < this.channels; i++) {
//                    sample += this.buffer.get();
//                }
//                out.putShort((short) (sample / (this.channels)));
////                out.putShort((short) sample);
//            } else {
//                out.putShort((short) 0);
//            }
//        }
//        out.rewind();
//        return out;


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

//        System.out.println("getBuffer: " + size);
        if (size > maxBufferSize) {
            maxBufferSize = size;
            this.tempBuffer = new byte[size];
            this.byteBuffer = ByteBuffer.allocateDirect(size).order(ByteOrder.LITTLE_ENDIAN);
        }
        byteBuffer.clear();
        stream.read(tempBuffer, 0, size);

        byteBuffer.put(tempBuffer, 0, size);
        byteBuffer.flip();
        return byteBuffer;
    }

    @Override
    public void close() throws IOException {
        if (this.decoder != null) {
            this.decoder.close();
        }
        stream.close();
        player.stopTrack();
        player.destroy();
    }

    @Override
    public void onTrackException(AudioTrack track, FriendlyException exception) {
        System.out.println(1);
    }

    @Override
    public void onTrackStuck(AudioTrack track, long thresholdMs) {
        System.out.println(2);
    }

    private static class StereoToMonoFilterFactory implements PcmFilterFactory {
        @Override
        public List<AudioFilter> buildChain(AudioTrack track, AudioDataFormat format, UniversalPcmAudioFilter output) {
            return Collections.singletonList(new StereoToMonoFilter(output));
        }
    }

    private static class StereoToMonoFilter implements FloatPcmAudioFilter {
        private final UniversalPcmAudioFilter downstream;

        public StereoToMonoFilter(UniversalPcmAudioFilter downstream) {
            this.downstream = downstream;
        }

        @Override
        public void process(float[][] input, int offset, int length) throws InterruptedException {
            for (int i = offset; i < offset+length; i++) {
                input[0][i] = (input[0][i] + input[1][i]) / 2;
            }
            downstream.process(new float[][]{input[0]}, offset, length);
        }

        @Override
        public void seekPerformed(long requestedTime, long providedTime) {

        }

        @Override
        public void flush() throws InterruptedException {

        }

        @Override
        public void close() {

        }
    }
}
