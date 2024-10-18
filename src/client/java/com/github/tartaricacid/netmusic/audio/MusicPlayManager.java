package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.api.NetWorker;
import com.github.tartaricacid.netmusic.api.pojo.QQMusicSongResult;
import com.google.gson.Gson;
import com.sedmelluq.discord.lavaplayer.format.AudioPlayerInputStream;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import static com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats.COMMON_PCM_S16_BE;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
@Environment(EnvType.CLIENT)
public class MusicPlayManager {
    private static final String ERROR_404 = "http://music.163.com/404";
    private static final String MUSIC_163_URL = "https://music.163.com/";
    private static final String QQ_MUSIC_URL = "https://u.y.qq.com/cgi-bin/musicu.fcg?data=";
    private static final String LOCAL_FILE_PROTOCOL = "file";

    public static void play(String url, String songName, Function<URL, SoundInstance> sound) {
        if (url.startsWith(MUSIC_163_URL)) {
            try {
                url = NetWorker.getRedirectUrl(url, NetMusic.NET_EASE_WEB_API.getRequestPropertyData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (url.startsWith(QQ_MUSIC_URL)) {
            System.out.println("QQ Music");
            try {
                String result = NetWorker.get(url, new HashMap<>());
                System.out.println(url);
                System.out.println(result);
                Gson gson = new Gson();
                QQMusicSongResult qqMusicSongResult = gson.fromJson(result, QQMusicSongResult.class);
                System.out.println(qqMusicSongResult);
                url = qqMusicSongResult.getUrlMid().getData().getMidUrlInfo().getPurl();
                System.out.println(url);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (url != null && !url.equals(ERROR_404)) {
            playMusic(url, songName, sound);
        }
    }

    private static void playMusic(String url, String songName, Function<URL, SoundInstance> sound) {
        final URL urlFinal;
        try {
            urlFinal = new URL(url);
            // 如果是本地文件
            if (urlFinal.getProtocol().equals(LOCAL_FILE_PROTOCOL)) {
                File file = new File(urlFinal.toURI());
                if (!file.exists()) {
                    NetMusic.LOGGER.info("File not found: {}", url);
                    return;
                }
            }
//            NetMusicSound netMusicSound = (NetMusicSound) sound.apply(urlFinal);
            MinecraftClient.getInstance().submit(() -> {
                NetMusicSound musicSound = (NetMusicSound) sound.apply(urlFinal);
                CompletableFuture.completedFuture(null).thenCompose(unused -> {
                    return musicSound.loadTrack(urlFinal);
                }).whenComplete(((audioTrack, throwable) -> {
                    musicSound.getPlayer().playTrack(audioTrack);
                    MinecraftClient.getInstance().getSoundManager().play(musicSound);
                    setNowPlaying(Text.literal(songName));
                }));
//                CompletableFuture<AudioTrack> future = CompletableFuture.completedFuture(null).thenCompose(unused -> {
//                    return netMusicSound.loadTrack(urlFinal);
//                }).whenComplete((track, e) -> {
//                    netMusicSound.getPlayer().playTrack(track);
//                    System.out.println("Play music: " + track);
//
////                    AudioInputStream stream = AudioPlayerInputStream.createStream(netMusicSound.getPlayer(), COMMON_PCM_S16_BE, 10000L, false);
////
////                    SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, stream.getFormat());
////                    SourceDataLine line = null;
////                    setNowPlaying(Text.literal(songName));
////                    try {
////                        line = (SourceDataLine) AudioSystem.getLine(info);
////                        line.open(stream.getFormat());
////                        line.start();
////
////                        byte[] buffer = new byte[COMMON_PCM_S16_BE.maximumChunkSize()];
////                        int chunkSize;
////
////                        while ((chunkSize = stream.read(buffer)) >= 0) {
////                            line.write(buffer, 0, chunkSize);
////                        }
////
////                        line.drain();
////                        line.close();
////                    } catch (LineUnavailableException | IOException e1) {
////                        e1.printStackTrace();
////                    }
//                    MinecraftClient.getInstance().getSoundManager().play(netMusicSound);
//                    setNowPlaying(Text.literal(songName));
//                });
            });
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void setNowPlaying(Text songName){
        MutableText mutableText = Text.translatable("record.nowPlaying", new Object[]{songName});
        MinecraftClient.getInstance().inGameHud.setOverlayMessage(mutableText, true);
        MinecraftClient.getInstance().getNarratorManager().narrate(mutableText);
    }
}
