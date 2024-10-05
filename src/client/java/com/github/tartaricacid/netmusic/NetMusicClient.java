package com.github.tartaricacid.netmusic;

import com.github.tartaricacid.netmusic.audio.MusicPlayManager;
import com.github.tartaricacid.netmusic.audio.NetMusicSound;
import com.github.tartaricacid.netmusic.init.CommandRegistry;
import com.github.tartaricacid.netmusic.init.CommonRegistry;
import com.github.tartaricacid.netmusic.init.InitRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

import java.net.MalformedURLException;
import java.net.URL;

public class NetMusicClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
//		UseItemCallback.EVENT.register((player, world, hand) -> {
//			Text text = player.getStackInHand(hand).getName();
//			MinecraftClient.getInstance().getServer().getPlayerManager().broadcast(text, false);
//			MinecraftClient.getInstance().submit(() -> {
//                System.out.println("进入播放音乐");
//                    MinecraftClient.getInstance().getSoundManager().play(
//							new NetMusicSound(
//									player.getBlockPos(),
//									new URL("E:\\download\\Sea_You_Next.mp3"),
//									153
//							)
//					);
//                MusicPlayManager.play("file:///E:\\download\\Sea_You_Next.mp3", "Sea You Next", url -> new NetMusicSound(player.getBlockPos(), url, 153));
//            });
//            return TypedActionResult.success(player.getStackInHand(hand));
//        });
		CommonRegistry.register();
		InitRenderer.init();
	}
}