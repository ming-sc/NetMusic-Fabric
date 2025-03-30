package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.block.BlockCDBurner;
import com.github.tartaricacid.netmusic.block.BlockComputer;
import com.github.tartaricacid.netmusic.block.BlockMusicPlayer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitBlocks {
    public static final Block MUSIC_PLAYER = register("music_player", new BlockMusicPlayer());
    public static final Block CD_BURNER = register("cd_burner", new BlockCDBurner(FabricBlockSettings.of(Material.WOOD)));
    public static final Block COMPUTER = register("computer", new BlockComputer());

    private static <T extends Block> T register(String name, T block) {
        Registry.register(Registry.BLOCK, new Identifier(NetMusic.MOD_ID, name), block);
        return block;
    }

    public static void init() {
    }
}
