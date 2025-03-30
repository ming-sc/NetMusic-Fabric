package com.github.tartaricacid.netmusic.client.receiver;

import com.github.tartaricacid.netmusic.config.MusicListManage;
import com.github.tartaricacid.netmusic.networking.message.GetMusicListMessage;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2024/10/11
 */
public class GetMusicListMessageReceiver {

    public static void receive(PacketContext packetContext, PacketByteBuf buf) {
        GetMusicListMessage message = GetMusicListMessage.getMessageFromBuffer(buf);
        packetContext.getTaskQueue().execute(() -> {
            CompletableFuture.runAsync(() -> {
                ClientPlayerEntity player = MinecraftClient.getInstance().player;
                try {
                    if (message.getMusicListId() == GetMusicListMessage.RELOAD_MESSAGE) {
                        MusicListManage.loadConfigSongs(MinecraftClient.getInstance().getResourceManager());
                        if (player != null) {
                            player.sendSystemMessage(new TranslatableText("command.netmusic.music_cd.reload.success"), Util.NIL_UUID);
                        }
                    }else {
                        MusicListManage.add163List(message.getMusicListId());
                        if (player != null) {
                            player.sendSystemMessage(new TranslatableText("command.netmusic.music_cd.add163.success"), Util.NIL_UUID);
                        }
                    }
                }catch (Exception e){
                    if (player != null) {
                        player.sendSystemMessage(new TranslatableText("command.netmusic.music_cd.add163.fail").formatted(Formatting.RED), Util.NIL_UUID);
                    }
                    e.printStackTrace();
                }
            });
        });
    }
}
