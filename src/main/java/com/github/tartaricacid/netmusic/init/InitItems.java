package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.config.MusicListManage;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class InitItems {

    public static Item MUSIC_CD = register(new ItemMusicCD(new Item.Settings()), "music_cd");

    public static Item MUSIC_PLAYER = register(new BlockItem(InitBlocks.MUSIC_PLAYER, new FabricItemSettings()), "music_player");

    public static Item CD_BURNER = register(new BlockItem(InitBlocks.CD_BURNER, new FabricItemSettings()), "cd_burner");

    public static Item COMPUTER = register(new BlockItem(InitBlocks.COMPUTER, new FabricItemSettings()), "computer");

    public static Item register(Item item, String id) {
        Identifier itemId = new Identifier(NetMusic.MOD_ID, id);
        return Registry.register(Registry.ITEM, itemId, item);
    }

    public static ItemGroup TAB = FabricItemGroupBuilder.create(new Identifier(NetMusic.MOD_ID, "netmusic"))
            .icon(() -> new ItemStack(MUSIC_PLAYER))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(MUSIC_PLAYER));
                stacks.add(new ItemStack(CD_BURNER));
                stacks.add(new ItemStack(COMPUTER));
                stacks.add(new ItemStack(MUSIC_CD));
                for (ItemMusicCD.SongInfo info : MusicListManage.SONGS) {
                    ItemStack stack = new ItemStack(MUSIC_CD);
                    ItemMusicCD.setSongInfo(info, stack);
                    stacks.add(stack);
                }
            })
            .build();

    public static void init() {
    }
}
