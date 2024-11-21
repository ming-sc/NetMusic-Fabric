package com.github.tartaricacid.netmusic.tileentity;

import com.github.tartaricacid.netmusic.init.InitBlocks;
import com.github.tartaricacid.netmusic.inventory.MusicPlayerInv;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import com.github.tartaricacid.netmusic.networking.NetworkHandler;
import com.github.tartaricacid.netmusic.networking.message.MusicToClientMessage;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class TileEntityMusicPlayer extends BlockEntity implements MusicPlayerInv, Tickable, BlockEntityClientSerializable {
    public static final BlockEntityType<TileEntityMusicPlayer> TYPE = BlockEntityType.Builder.create(TileEntityMusicPlayer::new, InitBlocks.MUSIC_PLAYER).build(null);
    private static final String CD_ITEM_TAG = "ItemStackCD";
    private static final String IS_PLAY_TAG = "IsPlay";
    private static final String CURRENT_TIME_TAG = "CurrentTime";
    private static final String SIGNAL_TAG = "RedStoneSignal";
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private boolean isPlay = false;
    private int currentTime;
    private boolean hasSignal = false;
    private boolean isEmpty = true;

    public TileEntityMusicPlayer() {
        super(TYPE);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public ItemStack getStack(int slot) {
        return getItems().get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack result = Inventories.splitStack(getItems(), slot, amount);
        if (items.get(0).isEmpty()) {
            setPlay(false);
            setCurrentTime(0);
        }
        markDirty();
        return result;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack result = Inventories.removeStack(getItems(), slot);
        markDirty();
        return result;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        getItems().clear();
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
        markDirty();
    }

    public int getCurrentTime(){
        return currentTime;
    }

    public boolean hasSignal(){return hasSignal;}

    public void setSignal(boolean signal){
        this.hasSignal = signal;
    }

    public void tickTime(){
        if (currentTime > 0){
            currentTime--;
        }
    }

    @Override
    public void tick() {
        this.tickTime();
        if (0 < this.getCurrentTime() && this.getCurrentTime() < 16 && this.getCurrentTime() % 5 == 0) {
            this.setPlay(false);
            this.markDirty();
        }
    }

    @Override
    public void fromTag(BlockState state, NbtCompound tag) {
        super.fromTag(state, tag);
        Inventories.readNbt(tag, items);
        isPlay = tag.getBoolean(IS_PLAY_TAG);
        currentTime = tag.getInt(CURRENT_TIME_TAG);
        hasSignal = tag.getBoolean(SIGNAL_TAG);
        isEmpty = tag.getBoolean("isEmpty");
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        nbt.putBoolean(IS_PLAY_TAG, isPlay);
        nbt.putInt(CURRENT_TIME_TAG, currentTime);
        nbt.putBoolean(SIGNAL_TAG, hasSignal);
        nbt.putBoolean("isEmpty", isEmpty);
        super.writeNbt(nbt);
        return nbt;
    }

    public boolean isPlay(){
        return isPlay;
    }

    public void setPlay(boolean play){
        isPlay = play;
    }

    public void setPlayToClient(ItemMusicCD.SongInfo info){
        this.setCurrentTime(info.songTime * 20 + 64);
        setPlay(true);
        if (world != null && !world.isClient){
             MusicToClientMessage msg = new MusicToClientMessage(pos, info.songUrl, info.songTime, info.songName);
             NetworkHandler.sendToNearBy(world, pos, msg);
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        isEmpty = getStack(0).isEmpty();
        if (world != null) {
            BlockState state = world.getBlockState(pos);
            world.updateListeners(pos, state, state, 0);
        }
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void fromClientTag(NbtCompound nbtCompound) {
        fromTag(world.getBlockState(pos), nbtCompound);
    }

    @Override
    public NbtCompound toClientTag(NbtCompound nbtCompound) {
        return writeNbt(nbtCompound);
    }
}
