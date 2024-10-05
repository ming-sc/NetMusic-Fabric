package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.constants.NetworkingConst;
import com.github.tartaricacid.netmusic.receiver.MusicToClientMessageReceiver;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class CommonRegistry {

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(NetworkingConst.PLAY_MUSIC_PACKET_ID, MusicToClientMessageReceiver::receive);
    }
}
