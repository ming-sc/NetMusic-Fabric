package com.github.tartaricacid.netmusic.block;

import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class BlockMusicPlayer extends HorizontalFacingBlock implements BlockEntityProvider {

    public BlockMusicPlayer() {
        super(Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.5f));
        this.setDefaultState(this.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.SOUTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new TileEntityMusicPlayer();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2, 0, 2, 14, 6, 14);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerFacing().getOpposite();
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, direction);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (hand == Hand.OFF_HAND){
            return ActionResult.PASS;
        }

        BlockEntity te = world.getBlockEntity(pos);
        if (!(te instanceof TileEntityMusicPlayer)){
            return ActionResult.PASS;
        }

        TileEntityMusicPlayer musicPlayer = (TileEntityMusicPlayer) te;
        ItemStack stack = musicPlayer.getStack(0);
        if (!stack.isEmpty()){
            if (musicPlayer.isPlay()){
                musicPlayer.setPlay(false);
                musicPlayer.setCurrentTime(0);
            }
            ItemStack itemStack = musicPlayer.removeStack(0);
            Block.dropStack(world, pos, itemStack);
            return ActionResult.SUCCESS;
        }

        ItemStack heldStack = player.getStackInHand(hand);
        ItemMusicCD.SongInfo info = ItemMusicCD.getSongInfo(heldStack);
        if (info == null){
            return ActionResult.PASS;
        }
        if (info.vip) {
            if (world.isClient){
                player.sendMessage(new TranslatableText("message.netmusic.music_player.need_vip").formatted(Formatting.RED), true);
            }
            return ActionResult.FAIL;
        }

        ItemStack copyStack = heldStack.copy();
        copyStack.setCount(1);
        musicPlayer.setStack(0, copyStack);
        if (!player.isCreative()){
            heldStack.decrement(1);
        }
        musicPlayer.setPlayToClient(info);
        musicPlayer.markDirty();

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        BlockEntity te = world.getBlockEntity(pos);
        if (te instanceof TileEntityMusicPlayer){
            TileEntityMusicPlayer musicPlayer = (TileEntityMusicPlayer) te;
            ItemStack stack = musicPlayer.getStack(0);
            if (!stack.isEmpty()){
                musicPlayer.setPlay(false);
                musicPlayer.setCurrentTime(0);
                Block.dropStack(world, pos, stack);
                world.updateComparators(pos, this);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof TileEntityMusicPlayer){
            TileEntityMusicPlayer te = (TileEntityMusicPlayer) blockEntity;
            ItemStack stackInSlot = te.getStack(0);
            if (!stackInSlot.isEmpty()){
                if (te.isPlay()){
                    return 15;
                }
                return 7;
            }
        }
        return 0;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        playerMusic(world, pos, world.isReceivingRedstonePower(pos));
    }

    private static void playerMusic(World world, BlockPos blockPos, boolean signal) {
        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        if (blockEntity instanceof TileEntityMusicPlayer) {
            TileEntityMusicPlayer player = (TileEntityMusicPlayer) blockEntity;
            if (signal != player.hasSignal()) {
                if (signal) {
                    if (player.isPlay()){
                        player.setPlay(false);
                        player.setSignal(signal);
                        player.markDirty();
                        return;
                    }
                    ItemStack stackInSlot = player.getStack(0);
                    if (stackInSlot.isEmpty()){
                        player.setSignal(signal);
                        player.markDirty();
                        return;
                    }
                    ItemMusicCD.SongInfo songInfo = ItemMusicCD.getSongInfo(stackInSlot);
                    if (songInfo != null) {
                        player.setPlayToClient(songInfo);
                    }
                }
                player.setSignal(signal);
                player.markDirty();
            }
        }
    }
}
