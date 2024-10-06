package com.github.tartaricacid.netmusic.networking.message;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public interface Message<T>{

    PacketByteBuf toBuffer();

    Identifier getPacketId();
}