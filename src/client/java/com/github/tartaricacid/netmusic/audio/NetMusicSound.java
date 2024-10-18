package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.NetMusicClient;
import com.github.tartaricacid.netmusic.init.InitSounds;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import javazoom.jl.decoder.JavaLayerException;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.AudioStream;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundLoader;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class NetMusicSound extends AbstractTickableSoundInstance {
    private final URL songUrl;
    private final int tickTimes;
    private final BlockPos pos;
    private int tick;
    private AudioPlayer player;

    public NetMusicSound(BlockPos pos, URL songUrl, int timeSecond) {
        super(InitSounds.NET_MUSIC, SoundCategory.RECORDS, SoundInstance.createRandom());
        this.songUrl = songUrl;
        this.x = pos.getX() + 0.5f;
        this.y = pos.getY() + 0.5f;
        this.z = pos.getZ() + 0.5f;
        this.tickTimes = timeSecond * 20;
        this.volume = 4.0f;
        this.tick = 0;
        this.pos = pos;
        this.player = NetMusicClient.manager.createPlayer();
    }

    @Override
    public void tick() {
        ClientWorld world = MinecraftClient.getInstance().world;
        if (world == null) {
            return;
        }
        tick++;
        if (tick > tickTimes + 50) {
            this.stop();
        } else {
            if (world.getTime() % 8 == 0) {
                for (int i = 0; i < 2; i++) {
                    world.addParticle(ParticleTypes.NOTE,
                            x - 0.5f + world.random.nextDouble(),
                            y + world.random.nextDouble() + 1,
                            z - 0.5f + world.random.nextDouble(),
                            world.random.nextGaussian(), world.random.nextGaussian(), world.random.nextInt(3));
                }
            }
        }

        BlockEntity te = world.getBlockEntity(pos);
        if (te instanceof TileEntityMusicPlayer) {
            TileEntityMusicPlayer musicPlay = (TileEntityMusicPlayer) te;
            if (!musicPlay.isPlay()) {
                this.stop();
            }
        } else {
            this.stop();
        }
    }

    @Override
    public CompletableFuture<AudioStream> getAudioStream(SoundLoader soundBuffers, Identifier id, boolean looping) {
//        return CompletableFuture.completedFuture(null).thenCompose(unused -> {
//            return loadTrack(this.songUrl);
//        }).whenComplete((track, e) -> {
//            player.playTrack(track);
//            System.out.println("Play music: " + track);
//        }).thenCompose(unused -> {
//            try {
//                return CompletableFuture.completedFuture(new LavaAudioStream(player));
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });

        return CompletableFuture.supplyAsync(() -> {
            try {
                return new LavaAudioStream(player);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Util.getMainWorkerExecutor());

//        return CompletableFuture.supplyAsync(() -> {
//            try {
////                return new Mp3AudioStream(this.songUrl);
//                return new LavaAudioStream(player);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }, Util.getMainWorkerExecutor());
    }

    public AudioPlayer getPlayer() {
        return player;
    }

    public CompletableFuture<AudioTrack> loadTrack(URL url) {
        CompletableFuture<AudioTrack> future = new CompletableFuture<>();
        String urlFinal = url.toString();
        if (urlFinal.startsWith("file:/")) {
            // 去除 file:/ 前缀
            urlFinal = urlFinal.substring(6);
            System.out.println(urlFinal);
            try {
                urlFinal = urlFinal.replaceAll("/", "\\\\");
                System.out.println(urlFinal);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(urlFinal);

        NetMusicClient.manager.loadItem(urlFinal, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                future.complete(track);
                System.out.println("Track loaded: " + track);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                future.complete(playlist.getTracks().get(0));
            }

            @Override
            public void noMatches() {
                future.completeExceptionally(new FriendlyException("This URL doesn't seem to be a track.", FriendlyException.Severity.COMMON, null));
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                future.completeExceptionally(exception);
            }
        });
        return future;
    }
}
