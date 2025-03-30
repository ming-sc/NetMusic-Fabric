package com.github.tartaricacid.netmusic.client.init;

import com.github.tartaricacid.netmusic.client.renderer.MusicPlayerItemRenderer;
import com.github.tartaricacid.netmusic.client.renderer.MusicPlayerRenderer;
import com.github.tartaricacid.netmusic.init.InitBlockEntity;
import com.github.tartaricacid.netmusic.init.InitItems;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitRenderer {

    public static void init() {
        BlockEntityRendererRegistry.INSTANCE.register(InitBlockEntity.MUSIC_PLAYER_TE, MusicPlayerRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(InitItems.MUSIC_PLAYER, new MusicPlayerItemRenderer());
//        BuiltinItemRendererRegistry.INSTANCE.register(InitBlocks.MUSIC_PLAYER, new MusicPlayerItemRenderer());
    }
}
