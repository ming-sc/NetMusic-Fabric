package com.github.tartaricacid.netmusic.inventory;

import com.github.tartaricacid.netmusic.init.InitItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public interface MusicPlayerInv extends Inventory {

    DefaultedList<ItemStack> getItems();

    @Override
    default int size(){
        return getItems().size();
    }

    @Override
    default boolean isEmpty(){
        for (int i = 0; i < size(); i++) {
            if (!getStack(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    default boolean isValid(int slot, ItemStack stack) {
        return stack.getItem() == InitItems.MUSIC_CD;
    }
}
