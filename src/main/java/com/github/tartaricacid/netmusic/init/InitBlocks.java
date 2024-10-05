package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.block.BlockMusicPlayer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitBlocks {
    public static final Block MUSIC_PLAYER = register("music_player", new BlockMusicPlayer(FabricBlockSettings.create().strength(4.0f)));

    private static <T extends Block> T register(String name, T block) {
        Registry.register(Registries.BLOCK, new Identifier(NetMusic.MOD_ID, name), block);
        Registry.register(Registries.ITEM, new Identifier(NetMusic.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static void init() {
    }
}
