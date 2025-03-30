package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitBlockEntity {

    public static final BlockEntityType<TileEntityMusicPlayer> MUSIC_PLAYER_TE = register(
            "music_player",
            TileEntityMusicPlayer.TYPE
    );

    public static final <T extends BlockEntityType<?>> T register(String name, T blockEntityType) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(NetMusic.MOD_ID, name), blockEntityType);
    }

    public static void init(){
    }
}
