package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import com.github.tartaricacid.netmusic.item.ItemMusicPlayer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class InitItems {

    public static Item MUSIC_CD = register(new ItemMusicCD(new Item.Settings()), "music_cd");

//    public static Item MUSIC_PLAYER = register(new ItemMusicPlayer(new Item.Settings()), "music_player");

    public static Item register(Item item, String id) {
        Identifier itemId = Identifier.of(NetMusic.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static void init() {
    }
}
