package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.model.ModelMusicPlayer;
import com.github.tartaricacid.netmusic.renderer.MusicPlayerRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.impl.client.rendering.BlockEntityRendererRegistryImpl;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitRenderer {

    public static void init() {
        BlockEntityRendererRegistryImpl.register(InitBlockEntity.MUSIC_PLAYER_TE, MusicPlayerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelMusicPlayer.LAYER, ModelMusicPlayer::createBodyLayer);
    }
}
