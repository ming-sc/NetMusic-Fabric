package com.github.tartaricacid.netmusic.networking.message;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public class SetMusicIDMessage implements Message<SetMusicIDMessage>{

    @Override
    public PacketByteBuf toBuffer() {
        return null;
    }

    @Override
    public Identifier getPacketId() {
        return null;
    }
}