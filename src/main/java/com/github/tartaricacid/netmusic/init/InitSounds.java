package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class InitSounds {

    public static final SoundEvent NET_MUSIC = new SoundEvent(new Identifier(NetMusic.MOD_ID, "net_music"));

    public static void init() {
        Registry.register(
                Registry.SOUND_EVENT,
                new Identifier(NetMusic.MOD_ID, "net_music"),
                NET_MUSIC
        );
    }
}
