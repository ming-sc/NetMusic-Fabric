package com.github.tartaricacid.netmusic.client.mixin;

import com.google.common.collect.Multimap;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.sound.*;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.Map;

/**
 * @author : IMG
 * @create : 2024/11/21
 */
@Mixin(SoundSystem.class)
public interface SoundSystemAccessor {

    @Accessor
    SoundManager getLoader();

    @Accessor
    GameOptions getSettings();

    @Accessor
    Channel getChannel();

    @Accessor
    Map<SoundInstance, Integer> getSoundEndTicks();

    @Accessor
    int getTicks();

    @Accessor
    Map<SoundInstance, Channel.SourceManager> getSources();

    @Accessor
    Multimap<SoundCategory, SoundInstance> getSounds();

    @Accessor
    Listener getListener();

    @Accessor
    List<SoundInstanceListener> getListeners();

    @Accessor
    List<TickableSoundInstance> getTickingSounds();
}
