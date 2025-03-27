package com.github.tartaricacid.netmusic.mixin;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.audio.IUrlSound;
import com.github.tartaricacid.netmusic.audio.Mp3AudioStream;
import net.minecraft.client.sound.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.URL;
import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2025/3/27
 */
@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {

    @Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At("HEAD"), cancellable = true)
    public void play(SoundInstance sound, CallbackInfo ci) {
        if (sound instanceof IUrlSound) {
            URL songUrl = ((IUrlSound) sound).getSongUrl();
            play(sound, (SoundSystem) (Object) this, songUrl);
            ci.cancel();
        }
    }

    private static CompletableFuture<AudioStream> getStream(URL url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return new Mp3AudioStream(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }, Util.getMainWorkerExecutor());
    }

    private static void play(SoundInstance sound, SoundSystem soundSystem, URL url) {
        if (sound != null && sound.canPlay()) {
            SoundSystemAccessor soundSystemAccessor = (SoundSystemAccessor) soundSystem;
            WeightedSoundSet accessor = sound.getSoundSet((soundSystemAccessor).getLoader());
            Identifier resourceLocation = sound.getId();

            float volume = sound.getVolume();
            float attenuationDis = Math.max(volume, 1.0F) * (float) sound.getSound().getAttenuation();
            SoundCategory category = sound.getCategory();
            float calculateVolume = calculateVolume(sound, soundSystem);
            float calculatePitch = calculatePitch(sound);
            SoundInstance.AttenuationType type = sound.getAttenuationType();
            boolean relative = sound.isRelative();

            Vec3d vec3d = new Vec3d(sound.getX(), sound.getY(), sound.getZ());
            if ((soundSystemAccessor).getListeners().isEmpty()) {
                boolean tmp = relative || type == SoundInstance.AttenuationType.NONE;
                if (tmp && accessor != null) {
                    for (SoundInstanceListener listener : (soundSystemAccessor).getListeners()) {
                        listener.onSoundPlayed(sound, accessor);
                    }
                }
            }

            if ((soundSystemAccessor).getListener().getVolume() <= 0) {
                NetMusic.LOGGER.debug("Skipped playing soundEvent: {}, master volume was zero", resourceLocation);
            }else {
                CompletableFuture<Channel.SourceManager> handle = (soundSystemAccessor).getChannel().createSource(SoundEngine.RunMode.STREAMING);
                Channel.SourceManager sourceManager = handle.join();
                soundSystemAccessor.getSoundEndTicks().put(sound, (soundSystemAccessor).getTicks() + 20);
                soundSystemAccessor.getSources().put(sound, sourceManager);
                soundSystemAccessor.getSounds().put(category, sound);
                sourceManager.run((source) -> {
                    source.setPitch(calculatePitch);
                    source.setVolume(calculateVolume);
                    source.setAttenuation(attenuationDis);
                    source.setLooping(false);
                    source.setPosition(vec3d);
                    source.setRelative(relative);
                });
                getStream(url).thenAccept((stream) -> sourceManager.run((source) -> {
                    if(stream != null) {
                        source.setStream(stream);
                        source.play();
                    }
                }));

                if (sound instanceof TickableSoundInstance) {
                    soundSystemAccessor.getTickingSounds().add((TickableSoundInstance) sound);
                }
            }
        }
    }

    private static float calculatePitch(SoundInstance sound) {
        return MathHelper.clamp(sound.getPitch(), 0.5F, 2.0F);
    }

    private static float calculateVolume(SoundInstance sound, SoundSystem soundSystem) {
        return MathHelper.clamp(sound.getVolume() * getVolume(sound.getCategory(), soundSystem), 0.0F, 1.0F);
    }

    private static float getVolume(@Nullable SoundCategory category, SoundSystem soundSystem) {
        return category == null && category != SoundCategory.MASTER ? ((SoundSystemAccessor)soundSystem).getSettings().getSoundVolume(category) : 1.0F;
    }
}
