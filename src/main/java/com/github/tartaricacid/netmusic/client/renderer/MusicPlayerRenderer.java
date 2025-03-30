package com.github.tartaricacid.netmusic.client.renderer;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.client.model.ModelMusicPlayer;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class MusicPlayerRenderer extends BlockEntityRenderer<TileEntityMusicPlayer> {
    public static final ModelMusicPlayer MODEL = new ModelMusicPlayer();
    public static final Identifier TEXTURE = new Identifier(NetMusic.MOD_ID, "textures/block/music_player.png");
    public static MusicPlayerRenderer instance;

    public MusicPlayerRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
        instance = this;
    }

    @Override
    public void render(TileEntityMusicPlayer entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction facing = entity.getCachedState().get(HorizontalFacingBlock.FACING);
        ItemStack cd = entity.getStack(0);
        ModelPart disc = MODEL.getDiscBone();
        disc.visible = !entity.isEmpty();
        if (!entity.isEmpty() && entity.isPlay()) {
            disc.yaw = (float) ((2 * Math.PI / 40) * ((System.currentTimeMillis() / 50) % 40));
        }
        renderMusicPlayer(matrices, vertexConsumers, light, facing);
    }

    public void renderMusicPlayer(MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int combinedLight, Direction facing) {
        matrixStack.push();
        matrixStack.scale(0.75f, 0.75f, 0.75f);
        matrixStack.translate(0.5 / 0.75, 1.5, 0.5 / 0.75);
        switch (facing){
            case NORTH:
            default:
                break;
            case SOUTH:
                matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180));
                break;
            case EAST:
                matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(270));
                break;
            case WEST:
                matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90));
                break;
        }
        matrixStack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(180));
        VertexConsumer buffer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        MODEL.render(matrixStack, buffer, combinedLight, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrixStack.pop();
    }
}
