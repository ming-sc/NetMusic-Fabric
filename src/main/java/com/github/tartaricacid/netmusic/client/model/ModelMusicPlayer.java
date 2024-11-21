package com.github.tartaricacid.netmusic.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class ModelMusicPlayer extends EntityModel<Entity> {
    private final ModelPart laba;
    private final ModelPart piece;
    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone16;
    private final ModelPart bone20;
    private final ModelPart bone17;
    private final ModelPart bone19;
    private final ModelPart bone18;
    private final ModelPart bone5;
    private final ModelPart bone6;
    private final ModelPart bone7;
    private final ModelPart piece2;
    private final ModelPart bone4;
    private final ModelPart bone8;
    private final ModelPart bone10;
    private final ModelPart bone11;
    private final ModelPart bone12;
    private final ModelPart bone13;
    private final ModelPart bone14;
    private final ModelPart bone15;
    private final ModelPart bone21;
    private final ModelPart bone22;
    private final ModelPart bone23;
    private final ModelPart piece3;
    private final ModelPart bone24;
    private final ModelPart bone25;
    private final ModelPart bone26;
    private final ModelPart bone27;
    private final ModelPart bone28;
    private final ModelPart bone29;
    private final ModelPart bone30;
    private final ModelPart bone31;
    private final ModelPart bone32;
    private final ModelPart bone33;
    private final ModelPart bone34;
    private final ModelPart piece4;
    private final ModelPart bone35;
    private final ModelPart bone36;
    private final ModelPart bone37;
    private final ModelPart bone38;
    private final ModelPart bone39;
    private final ModelPart bone40;
    private final ModelPart bone41;
    private final ModelPart bone42;
    private final ModelPart bone43;
    private final ModelPart bone44;
    private final ModelPart bone45;
    private final ModelPart piece5;
    private final ModelPart bone46;
    private final ModelPart bone47;
    private final ModelPart bone48;
    private final ModelPart bone49;
    private final ModelPart bone50;
    private final ModelPart bone51;
    private final ModelPart bone52;
    private final ModelPart bone53;
    private final ModelPart bone54;
    private final ModelPart bone55;
    private final ModelPart bone56;
    private final ModelPart piece6;
    private final ModelPart bone57;
    private final ModelPart bone58;
    private final ModelPart bone59;
    private final ModelPart bone60;
    private final ModelPart bone61;
    private final ModelPart bone62;
    private final ModelPart bone63;
    private final ModelPart bone64;
    private final ModelPart bone65;
    private final ModelPart bone66;
    private final ModelPart bone67;
    private final ModelPart piece7;
    private final ModelPart bone68;
    private final ModelPart bone69;
    private final ModelPart bone70;
    private final ModelPart bone71;
    private final ModelPart bone72;
    private final ModelPart bone73;
    private final ModelPart bone74;
    private final ModelPart bone75;
    private final ModelPart bone76;
    private final ModelPart bone77;
    private final ModelPart bone78;
    private final ModelPart piece8;
    private final ModelPart bone79;
    private final ModelPart bone80;
    private final ModelPart bone81;
    private final ModelPart bone82;
    private final ModelPart bone83;
    private final ModelPart bone84;
    private final ModelPart bone85;
    private final ModelPart bone86;
    private final ModelPart bone87;
    private final ModelPart bone88;
    private final ModelPart bone89;
    private final ModelPart tube;
    private final ModelPart bone90;
    private final ModelPart bone97;
    private final ModelPart bone98;
    private final ModelPart bone99;
    private final ModelPart bone94;
    private final ModelPart bone95;
    private final ModelPart bone96;
    private final ModelPart bone91;
    private final ModelPart bone92;
    private final ModelPart bone93;
    private final ModelPart wheel;
    private final ModelPart bone9;
    private final ModelPart bone100;
    private final ModelPart bone101;
    private final ModelPart ruler;
    private final ModelPart box;
    private final ModelPart bone102;
    private final ModelPart disc;
    private final ModelPart bone103;
    private final ModelPart bone104;
    private final ModelPart bone105;
    private final ModelPart bone106;
    private final ModelPart bone107;
    private final ModelPart bone108;
    private final ModelPart bone109;
    private final ModelPart huahen;
    private final ModelPart bone110;
    private final ModelPart bone111;
    private final ModelPart bone112;
    private final ModelPart bone113;
    private final ModelPart bone114;
    private final ModelPart bone115;
    private final ModelPart bone116;
    private final ModelPart bone117;
    private final ModelPart getDiscBone;

    public ModelMusicPlayer() {
        textureWidth = 64;
        textureHeight = 64;

        laba = new ModelPart(this);
        laba.setPivot(0.0F, 11.0F, 7.0F);
        setRotationAngle(laba, -2.3562F, 0.0F, 0.0F);
        laba.setTextureOffset(6, 19).addCuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        piece = new ModelPart(this);
        piece.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece);


        bone = new ModelPart(this);
        bone.setPivot(0.0F, 0.0F, 7.1706F);
        piece.addChild(bone);
        setRotationAngle(bone, 0.6479F, 0.0F, 0.0F);
        bone.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone2 = new ModelPart(this);
        bone2.setPivot(2.0F, 0.2425F, 0.0F);
        bone.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.0F, -0.245F);
        bone2.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone3 = new ModelPart(this);
        bone3.setPivot(-2.0F, 0.2425F, 0.0F);
        bone.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 0.0F, 0.245F);
        bone3.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone16 = new ModelPart(this);
        bone16.setPivot(2.9701F, 0.0F, 0.001F);
        bone.addChild(bone16);
        setRotationAngle(bone16, 0.0F, 0.0F, -0.7854F);
        bone16.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone20 = new ModelPart(this);
        bone20.setPivot(-2.9701F, 0.0F, 0.001F);
        bone.addChild(bone20);
        setRotationAngle(bone20, 0.0F, 0.0F, 0.7854F);
        bone20.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone17 = new ModelPart(this);
        bone17.setPivot(2.9701F, 0.0F, 0.001F);
        bone.addChild(bone17);
        setRotationAngle(bone17, 0.0F, 0.0F, -0.3927F);
        bone17.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone19 = new ModelPart(this);
        bone19.setPivot(-2.9701F, 0.0F, 0.001F);
        bone.addChild(bone19);
        setRotationAngle(bone19, 0.0F, 0.0F, 0.3927F);
        bone19.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone18 = new ModelPart(this);
        bone18.setPivot(2.9701F, 0.0F, 0.001F);
        bone.addChild(bone18);
        setRotationAngle(bone18, 0.0F, 0.0F, -0.3927F);


        bone5 = new ModelPart(this);
        bone5.setPivot(0.0F, -6.3F, 2.3956F);
        piece.addChild(bone5);
        setRotationAngle(bone5, 0.3066F, 0.0F, 0.0F);


        bone6 = new ModelPart(this);
        bone6.setPivot(1.0F, 0.124F, 2.4152F);
        bone5.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.1244F);
        bone6.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone6.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone6.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone7 = new ModelPart(this);
        bone7.setPivot(-1.0F, 0.124F, 2.4152F);
        bone5.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.0F, 0.1244F);
        bone7.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone7.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone7.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone7.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece2 = new ModelPart(this);
        piece2.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece2);
        setRotationAngle(piece2, 0.0F, -0.7854F, 0.0F);


        bone4 = new ModelPart(this);
        bone4.setPivot(0.0F, 0.0F, 7.1706F);
        piece2.addChild(bone4);
        setRotationAngle(bone4, 0.6479F, 0.0F, 0.0F);
        bone4.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone8 = new ModelPart(this);
        bone8.setPivot(2.0F, 0.2425F, 0.0F);
        bone4.addChild(bone8);
        setRotationAngle(bone8, 0.0F, 0.0F, -0.245F);
        bone8.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone10 = new ModelPart(this);
        bone10.setPivot(-2.0F, 0.2425F, 0.0F);
        bone4.addChild(bone10);
        setRotationAngle(bone10, 0.0F, 0.0F, 0.245F);
        bone10.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone11 = new ModelPart(this);
        bone11.setPivot(2.9701F, 0.0F, 0.001F);
        bone4.addChild(bone11);
        setRotationAngle(bone11, 0.0F, 0.0F, -0.7854F);
        bone11.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone12 = new ModelPart(this);
        bone12.setPivot(-2.9701F, 0.0F, 0.001F);
        bone4.addChild(bone12);
        setRotationAngle(bone12, 0.0F, 0.0F, 0.7854F);
        bone12.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone13 = new ModelPart(this);
        bone13.setPivot(2.9701F, 0.0F, 0.001F);
        bone4.addChild(bone13);
        setRotationAngle(bone13, 0.0F, 0.0F, -0.3927F);
        bone13.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone14 = new ModelPart(this);
        bone14.setPivot(-2.9701F, 0.0F, 0.001F);
        bone4.addChild(bone14);
        setRotationAngle(bone14, 0.0F, 0.0F, 0.3927F);
        bone14.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone15 = new ModelPart(this);
        bone15.setPivot(2.9701F, 0.0F, 0.001F);
        bone4.addChild(bone15);
        setRotationAngle(bone15, 0.0F, 0.0F, -0.3927F);


        bone21 = new ModelPart(this);
        bone21.setPivot(0.0F, -6.3F, 2.3956F);
        piece2.addChild(bone21);
        setRotationAngle(bone21, 0.3066F, 0.0F, 0.0F);


        bone22 = new ModelPart(this);
        bone22.setPivot(1.0F, 0.124F, 2.4152F);
        bone21.addChild(bone22);
        setRotationAngle(bone22, 0.0F, 0.0F, -0.1244F);
        bone22.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone22.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone22.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone22.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone23 = new ModelPart(this);
        bone23.setPivot(-1.0F, 0.124F, 2.4152F);
        bone21.addChild(bone23);
        setRotationAngle(bone23, 0.0F, 0.0F, 0.1244F);
        bone23.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone23.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone23.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone23.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece3 = new ModelPart(this);
        piece3.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece3);
        setRotationAngle(piece3, 0.0F, -1.5708F, 0.0F);


        bone24 = new ModelPart(this);
        bone24.setPivot(0.0F, 0.0F, 7.1706F);
        piece3.addChild(bone24);
        setRotationAngle(bone24, 0.6479F, 0.0F, 0.0F);
        bone24.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone24.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone24.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone25 = new ModelPart(this);
        bone25.setPivot(2.0F, 0.2425F, 0.0F);
        bone24.addChild(bone25);
        setRotationAngle(bone25, 0.0F, 0.0F, -0.245F);
        bone25.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone26 = new ModelPart(this);
        bone26.setPivot(-2.0F, 0.2425F, 0.0F);
        bone24.addChild(bone26);
        setRotationAngle(bone26, 0.0F, 0.0F, 0.245F);
        bone26.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone27 = new ModelPart(this);
        bone27.setPivot(2.9701F, 0.0F, 0.001F);
        bone24.addChild(bone27);
        setRotationAngle(bone27, 0.0F, 0.0F, -0.7854F);
        bone27.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone28 = new ModelPart(this);
        bone28.setPivot(-2.9701F, 0.0F, 0.001F);
        bone24.addChild(bone28);
        setRotationAngle(bone28, 0.0F, 0.0F, 0.7854F);
        bone28.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone29 = new ModelPart(this);
        bone29.setPivot(2.9701F, 0.0F, 0.001F);
        bone24.addChild(bone29);
        setRotationAngle(bone29, 0.0F, 0.0F, -0.3927F);
        bone29.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone30 = new ModelPart(this);
        bone30.setPivot(-2.9701F, 0.0F, 0.001F);
        bone24.addChild(bone30);
        setRotationAngle(bone30, 0.0F, 0.0F, 0.3927F);
        bone30.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone31 = new ModelPart(this);
        bone31.setPivot(2.9701F, 0.0F, 0.001F);
        bone24.addChild(bone31);
        setRotationAngle(bone31, 0.0F, 0.0F, -0.3927F);


        bone32 = new ModelPart(this);
        bone32.setPivot(0.0F, -6.3F, 2.3956F);
        piece3.addChild(bone32);
        setRotationAngle(bone32, 0.3066F, 0.0F, 0.0F);


        bone33 = new ModelPart(this);
        bone33.setPivot(1.0F, 0.124F, 2.4152F);
        bone32.addChild(bone33);
        setRotationAngle(bone33, 0.0F, 0.0F, -0.1244F);
        bone33.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone33.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone33.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone33.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone34 = new ModelPart(this);
        bone34.setPivot(-1.0F, 0.124F, 2.4152F);
        bone32.addChild(bone34);
        setRotationAngle(bone34, 0.0F, 0.0F, 0.1244F);
        bone34.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone34.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone34.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone34.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece4 = new ModelPart(this);
        piece4.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece4);
        setRotationAngle(piece4, 0.0F, -2.3562F, 0.0F);


        bone35 = new ModelPart(this);
        bone35.setPivot(0.0F, 0.0F, 7.1706F);
        piece4.addChild(bone35);
        setRotationAngle(bone35, 0.6479F, 0.0F, 0.0F);
        bone35.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone35.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone35.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone36 = new ModelPart(this);
        bone36.setPivot(2.0F, 0.2425F, 0.0F);
        bone35.addChild(bone36);
        setRotationAngle(bone36, 0.0F, 0.0F, -0.245F);
        bone36.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone37 = new ModelPart(this);
        bone37.setPivot(-2.0F, 0.2425F, 0.0F);
        bone35.addChild(bone37);
        setRotationAngle(bone37, 0.0F, 0.0F, 0.245F);
        bone37.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone38 = new ModelPart(this);
        bone38.setPivot(2.9701F, 0.0F, 0.001F);
        bone35.addChild(bone38);
        setRotationAngle(bone38, 0.0F, 0.0F, -0.7854F);
        bone38.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone39 = new ModelPart(this);
        bone39.setPivot(-2.9701F, 0.0F, 0.001F);
        bone35.addChild(bone39);
        setRotationAngle(bone39, 0.0F, 0.0F, 0.7854F);
        bone39.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone40 = new ModelPart(this);
        bone40.setPivot(2.9701F, 0.0F, 0.001F);
        bone35.addChild(bone40);
        setRotationAngle(bone40, 0.0F, 0.0F, -0.3927F);
        bone40.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone41 = new ModelPart(this);
        bone41.setPivot(-2.9701F, 0.0F, 0.001F);
        bone35.addChild(bone41);
        setRotationAngle(bone41, 0.0F, 0.0F, 0.3927F);
        bone41.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone42 = new ModelPart(this);
        bone42.setPivot(2.9701F, 0.0F, 0.001F);
        bone35.addChild(bone42);
        setRotationAngle(bone42, 0.0F, 0.0F, -0.3927F);


        bone43 = new ModelPart(this);
        bone43.setPivot(0.0F, -6.3F, 2.3956F);
        piece4.addChild(bone43);
        setRotationAngle(bone43, 0.3066F, 0.0F, 0.0F);


        bone44 = new ModelPart(this);
        bone44.setPivot(1.0F, 0.124F, 2.4152F);
        bone43.addChild(bone44);
        setRotationAngle(bone44, 0.0F, 0.0F, -0.1244F);
        bone44.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone44.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone44.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone44.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone45 = new ModelPart(this);
        bone45.setPivot(-1.0F, 0.124F, 2.4152F);
        bone43.addChild(bone45);
        setRotationAngle(bone45, 0.0F, 0.0F, 0.1244F);
        bone45.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone45.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone45.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone45.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece5 = new ModelPart(this);
        piece5.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece5);
        setRotationAngle(piece5, 0.0F, 3.1416F, 0.0F);


        bone46 = new ModelPart(this);
        bone46.setPivot(0.0F, 0.0F, 7.1706F);
        piece5.addChild(bone46);
        setRotationAngle(bone46, 0.6479F, 0.0F, 0.0F);
        bone46.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone46.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone46.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone47 = new ModelPart(this);
        bone47.setPivot(2.0F, 0.2425F, 0.0F);
        bone46.addChild(bone47);
        setRotationAngle(bone47, 0.0F, 0.0F, -0.245F);
        bone47.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone48 = new ModelPart(this);
        bone48.setPivot(-2.0F, 0.2425F, 0.0F);
        bone46.addChild(bone48);
        setRotationAngle(bone48, 0.0F, 0.0F, 0.245F);
        bone48.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone49 = new ModelPart(this);
        bone49.setPivot(2.9701F, 0.0F, 0.001F);
        bone46.addChild(bone49);
        setRotationAngle(bone49, 0.0F, 0.0F, -0.7854F);
        bone49.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone50 = new ModelPart(this);
        bone50.setPivot(-2.9701F, 0.0F, 0.001F);
        bone46.addChild(bone50);
        setRotationAngle(bone50, 0.0F, 0.0F, 0.7854F);
        bone50.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone51 = new ModelPart(this);
        bone51.setPivot(2.9701F, 0.0F, 0.001F);
        bone46.addChild(bone51);
        setRotationAngle(bone51, 0.0F, 0.0F, -0.3927F);
        bone51.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone52 = new ModelPart(this);
        bone52.setPivot(-2.9701F, 0.0F, 0.001F);
        bone46.addChild(bone52);
        setRotationAngle(bone52, 0.0F, 0.0F, 0.3927F);
        bone52.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone53 = new ModelPart(this);
        bone53.setPivot(2.9701F, 0.0F, 0.001F);
        bone46.addChild(bone53);
        setRotationAngle(bone53, 0.0F, 0.0F, -0.3927F);


        bone54 = new ModelPart(this);
        bone54.setPivot(0.0F, -6.3F, 2.3956F);
        piece5.addChild(bone54);
        setRotationAngle(bone54, 0.3066F, 0.0F, 0.0F);


        bone55 = new ModelPart(this);
        bone55.setPivot(1.0F, 0.124F, 2.4152F);
        bone54.addChild(bone55);
        setRotationAngle(bone55, 0.0F, 0.0F, -0.1244F);
        bone55.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone55.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone55.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone55.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone56 = new ModelPart(this);
        bone56.setPivot(-1.0F, 0.124F, 2.4152F);
        bone54.addChild(bone56);
        setRotationAngle(bone56, 0.0F, 0.0F, 0.1244F);
        bone56.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone56.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone56.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone56.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece6 = new ModelPart(this);
        piece6.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece6);
        setRotationAngle(piece6, 0.0F, 2.3562F, 0.0F);


        bone57 = new ModelPart(this);
        bone57.setPivot(0.0F, 0.0F, 7.1706F);
        piece6.addChild(bone57);
        setRotationAngle(bone57, 0.6479F, 0.0F, 0.0F);
        bone57.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone57.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone57.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone58 = new ModelPart(this);
        bone58.setPivot(2.0F, 0.2425F, 0.0F);
        bone57.addChild(bone58);
        setRotationAngle(bone58, 0.0F, 0.0F, -0.245F);
        bone58.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone59 = new ModelPart(this);
        bone59.setPivot(-2.0F, 0.2425F, 0.0F);
        bone57.addChild(bone59);
        setRotationAngle(bone59, 0.0F, 0.0F, 0.245F);
        bone59.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone60 = new ModelPart(this);
        bone60.setPivot(2.9701F, 0.0F, 0.001F);
        bone57.addChild(bone60);
        setRotationAngle(bone60, 0.0F, 0.0F, -0.7854F);
        bone60.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone61 = new ModelPart(this);
        bone61.setPivot(-2.9701F, 0.0F, 0.001F);
        bone57.addChild(bone61);
        setRotationAngle(bone61, 0.0F, 0.0F, 0.7854F);
        bone61.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone62 = new ModelPart(this);
        bone62.setPivot(2.9701F, 0.0F, 0.001F);
        bone57.addChild(bone62);
        setRotationAngle(bone62, 0.0F, 0.0F, -0.3927F);
        bone62.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone63 = new ModelPart(this);
        bone63.setPivot(-2.9701F, 0.0F, 0.001F);
        bone57.addChild(bone63);
        setRotationAngle(bone63, 0.0F, 0.0F, 0.3927F);
        bone63.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone64 = new ModelPart(this);
        bone64.setPivot(2.9701F, 0.0F, 0.001F);
        bone57.addChild(bone64);
        setRotationAngle(bone64, 0.0F, 0.0F, -0.3927F);


        bone65 = new ModelPart(this);
        bone65.setPivot(0.0F, -6.3F, 2.3956F);
        piece6.addChild(bone65);
        setRotationAngle(bone65, 0.3066F, 0.0F, 0.0F);


        bone66 = new ModelPart(this);
        bone66.setPivot(1.0F, 0.124F, 2.4152F);
        bone65.addChild(bone66);
        setRotationAngle(bone66, 0.0F, 0.0F, -0.1244F);
        bone66.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone66.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone66.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone66.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone67 = new ModelPart(this);
        bone67.setPivot(-1.0F, 0.124F, 2.4152F);
        bone65.addChild(bone67);
        setRotationAngle(bone67, 0.0F, 0.0F, 0.1244F);
        bone67.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone67.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone67.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone67.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece7 = new ModelPart(this);
        piece7.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece7);
        setRotationAngle(piece7, 0.0F, 1.5708F, 0.0F);


        bone68 = new ModelPart(this);
        bone68.setPivot(0.0F, 0.0F, 7.1706F);
        piece7.addChild(bone68);
        setRotationAngle(bone68, 0.6479F, 0.0F, 0.0F);
        bone68.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone68.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone68.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone69 = new ModelPart(this);
        bone69.setPivot(2.0F, 0.2425F, 0.0F);
        bone68.addChild(bone69);
        setRotationAngle(bone69, 0.0F, 0.0F, -0.245F);
        bone69.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone70 = new ModelPart(this);
        bone70.setPivot(-2.0F, 0.2425F, 0.0F);
        bone68.addChild(bone70);
        setRotationAngle(bone70, 0.0F, 0.0F, 0.245F);
        bone70.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone71 = new ModelPart(this);
        bone71.setPivot(2.9701F, 0.0F, 0.001F);
        bone68.addChild(bone71);
        setRotationAngle(bone71, 0.0F, 0.0F, -0.7854F);
        bone71.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone72 = new ModelPart(this);
        bone72.setPivot(-2.9701F, 0.0F, 0.001F);
        bone68.addChild(bone72);
        setRotationAngle(bone72, 0.0F, 0.0F, 0.7854F);
        bone72.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone73 = new ModelPart(this);
        bone73.setPivot(2.9701F, 0.0F, 0.001F);
        bone68.addChild(bone73);
        setRotationAngle(bone73, 0.0F, 0.0F, -0.3927F);
        bone73.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone74 = new ModelPart(this);
        bone74.setPivot(-2.9701F, 0.0F, 0.001F);
        bone68.addChild(bone74);
        setRotationAngle(bone74, 0.0F, 0.0F, 0.3927F);
        bone74.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone75 = new ModelPart(this);
        bone75.setPivot(2.9701F, 0.0F, 0.001F);
        bone68.addChild(bone75);
        setRotationAngle(bone75, 0.0F, 0.0F, -0.3927F);


        bone76 = new ModelPart(this);
        bone76.setPivot(0.0F, -6.3F, 2.3956F);
        piece7.addChild(bone76);
        setRotationAngle(bone76, 0.3066F, 0.0F, 0.0F);


        bone77 = new ModelPart(this);
        bone77.setPivot(1.0F, 0.124F, 2.4152F);
        bone76.addChild(bone77);
        setRotationAngle(bone77, 0.0F, 0.0F, -0.1244F);
        bone77.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone77.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone77.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone77.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone78 = new ModelPart(this);
        bone78.setPivot(-1.0F, 0.124F, 2.4152F);
        bone76.addChild(bone78);
        setRotationAngle(bone78, 0.0F, 0.0F, 0.1244F);
        bone78.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone78.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone78.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone78.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        piece8 = new ModelPart(this);
        piece8.setPivot(0.0F, 13.0F, 0.0F);
        laba.addChild(piece8);
        setRotationAngle(piece8, 0.0F, 0.7854F, 0.0F);


        bone79 = new ModelPart(this);
        bone79.setPivot(0.0F, 0.0F, 7.1706F);
        piece8.addChild(bone79);
        setRotationAngle(bone79, 0.6479F, 0.0F, 0.0F);
        bone79.setTextureOffset(6, 11).addCuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
        bone79.setTextureOffset(10, 17).addCuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, false);
        bone79.setTextureOffset(5, 24).addCuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone80 = new ModelPart(this);
        bone80.setPivot(2.0F, 0.2425F, 0.0F);
        bone79.addChild(bone80);
        setRotationAngle(bone80, 0.0F, 0.0F, -0.245F);
        bone80.setTextureOffset(12, 0).addCuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone81 = new ModelPart(this);
        bone81.setPivot(-2.0F, 0.2425F, 0.0F);
        bone79.addChild(bone81);
        setRotationAngle(bone81, 0.0F, 0.0F, 0.245F);
        bone81.setTextureOffset(12, 0).addCuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

        bone82 = new ModelPart(this);
        bone82.setPivot(2.9701F, 0.0F, 0.001F);
        bone79.addChild(bone82);
        setRotationAngle(bone82, 0.0F, 0.0F, -0.7854F);
        bone82.setTextureOffset(5, 24).addCuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone83 = new ModelPart(this);
        bone83.setPivot(-2.9701F, 0.0F, 0.001F);
        bone79.addChild(bone83);
        setRotationAngle(bone83, 0.0F, 0.0F, 0.7854F);
        bone83.setTextureOffset(5, 24).addCuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone84 = new ModelPart(this);
        bone84.setPivot(2.9701F, 0.0F, 0.001F);
        bone79.addChild(bone84);
        setRotationAngle(bone84, 0.0F, 0.0F, -0.3927F);
        bone84.setTextureOffset(5, 24).addCuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone85 = new ModelPart(this);
        bone85.setPivot(-2.9701F, 0.0F, 0.001F);
        bone79.addChild(bone85);
        setRotationAngle(bone85, 0.0F, 0.0F, 0.3927F);
        bone85.setTextureOffset(5, 24).addCuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, 0.1969F, false);

        bone86 = new ModelPart(this);
        bone86.setPivot(2.9701F, 0.0F, 0.001F);
        bone79.addChild(bone86);
        setRotationAngle(bone86, 0.0F, 0.0F, -0.3927F);


        bone87 = new ModelPart(this);
        bone87.setPivot(0.0F, -6.3F, 2.3956F);
        piece8.addChild(bone87);
        setRotationAngle(bone87, 0.3066F, 0.0F, 0.0F);


        bone88 = new ModelPart(this);
        bone88.setPivot(1.0F, 0.124F, 2.4152F);
        bone87.addChild(bone88);
        setRotationAngle(bone88, 0.0F, 0.0F, -0.1244F);
        bone88.setTextureOffset(14, 0).addCuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone88.setTextureOffset(0, 11).addCuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone88.setTextureOffset(10, 22).addCuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone88.setTextureOffset(6, 22).addCuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        bone89 = new ModelPart(this);
        bone89.setPivot(-1.0F, 0.124F, 2.4152F);
        bone87.addChild(bone89);
        setRotationAngle(bone89, 0.0F, 0.0F, 0.1244F);
        bone89.setTextureOffset(14, 0).addCuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, 0.0F, false);
        bone89.setTextureOffset(0, 11).addCuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, -0.2F, false);
        bone89.setTextureOffset(10, 22).addCuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, -0.26F, false);
        bone89.setTextureOffset(6, 22).addCuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, -0.31F, false);

        tube = new ModelPart(this);
        tube.setPivot(0.75F, 24.0F, 1.5F);
        tube.setTextureOffset(6, 19).addCuboid(-1.25F, -12.4297F, 5.2362F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        tube.setTextureOffset(0, 17).addCuboid(0.7637F, -9.416F, 5.2362F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        tube.setTextureOffset(0, 11).addCuboid(5.7773F, -9.416F, 0.2226F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        tube.setTextureOffset(9, 24).addCuboid(3.7637F, -9.416F, -1.7911F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone90 = new ModelPart(this);
        bone90.setPivot(-0.75F, -12.8536F, 5.3536F);
        tube.addChild(bone90);
        setRotationAngle(bone90, -1.1781F, 0.0F, 0.0F);
        bone90.setTextureOffset(10, 27).addCuboid(-0.5F, -0.6533F, -0.2706F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone97 = new ModelPart(this);
        bone97.setPivot(6.2773F, -8.916F, -0.2774F);
        tube.addChild(bone97);
        setRotationAngle(bone97, 0.0F, 0.3927F, 0.0F);
        bone97.setTextureOffset(0, 25).addCuboid(-0.7294F, -0.5F, -0.3467F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone98 = new ModelPart(this);
        bone98.setPivot(6.2773F, -8.916F, -0.2774F);
        tube.addChild(bone98);
        setRotationAngle(bone98, 0.0F, 0.7854F, 0.0F);
        bone98.setTextureOffset(0, 25).addCuboid(-0.6173F, -0.5F, -1.2168F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone99 = new ModelPart(this);
        bone99.setPivot(6.2773F, -8.916F, -0.2774F);
        tube.addChild(bone99);
        setRotationAngle(bone99, 0.0F, 1.1781F, 0.0F);
        bone99.setTextureOffset(0, 25).addCuboid(-0.1808F, -0.5F, -1.9777F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone94 = new ModelPart(this);
        bone94.setPivot(3.2637F, -8.916F, 5.7362F);
        tube.addChild(bone94);
        setRotationAngle(bone94, 0.0F, 0.3927F, 0.0F);
        bone94.setTextureOffset(7, 26).addCuboid(1.1945F, -0.5F, 0.036F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone95 = new ModelPart(this);
        bone95.setPivot(3.2637F, -8.916F, 5.7362F);
        tube.addChild(bone95);
        setRotationAngle(bone95, 0.0F, 0.7854F, 0.0F);
        bone95.setTextureOffset(7, 26).addCuboid(1.631F, -0.5F, 0.7969F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone96 = new ModelPart(this);
        bone96.setPivot(3.2637F, -8.916F, 5.7362F);
        tube.addChild(bone96);
        setRotationAngle(bone96, 0.0F, 1.1781F, 0.0F);
        bone96.setTextureOffset(3, 26).addCuboid(1.7431F, -0.5F, 1.667F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone91 = new ModelPart(this);
        bone91.setPivot(-0.75F, -9.9297F, 5.7362F);
        tube.addChild(bone91);
        setRotationAngle(bone91, 0.0F, 0.0F, -0.3927F);
        bone91.setTextureOffset(0, 27).addCuboid(-0.2706F, -0.6533F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone92 = new ModelPart(this);
        bone92.setPivot(-0.75F, -9.9297F, 5.7362F);
        tube.addChild(bone92);
        setRotationAngle(bone92, 0.0F, 0.0F, -0.7854F);
        bone92.setTextureOffset(0, 27).addCuboid(-0.3827F, 0.2168F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone93 = new ModelPart(this);
        bone93.setPivot(-0.75F, -9.9297F, 5.7362F);
        tube.addChild(bone93);
        setRotationAngle(bone93, 0.0F, 0.0F, -1.1781F);
        bone93.setTextureOffset(0, 27).addCuboid(-0.8192F, 0.9777F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        wheel = new ModelPart(this);
        wheel.setPivot(5.0137F, 15.084F, 0.2089F);
        wheel.setTextureOffset(12, 8).addCuboid(-1.3536F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1464F, false);

        bone9 = new ModelPart(this);
        bone9.setPivot(-0.8536F, 0.0F, 0.0F);
        wheel.addChild(bone9);
        setRotationAngle(bone9, -0.7854F, 0.0F, 0.0F);
        bone9.setTextureOffset(12, 8).addCuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1464F, false);

        bone100 = new ModelPart(this);
        bone100.setPivot(-0.8536F, 0.0F, 0.0F);
        wheel.addChild(bone100);
        setRotationAngle(bone100, -1.5708F, 0.0F, 0.0F);
        bone100.setTextureOffset(12, 8).addCuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1464F, false);

        bone101 = new ModelPart(this);
        bone101.setPivot(-0.8536F, 0.0F, 0.0F);
        wheel.addChild(bone101);
        setRotationAngle(bone101, -2.3562F, 0.0F, 0.0F);
        bone101.setTextureOffset(12, 8).addCuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1464F, false);

        ruler = new ModelPart(this);
        ruler.setPivot(0.0F, 24.0F, 0.0F);
        ruler.setTextureOffset(0, 19).addCuboid(-1.0F, -12.0F, 7.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

        box = new ModelPart(this);
        box.setPivot(0.0F, 24.0F, 0.0F);
        box.setTextureOffset(0, 0).addCuboid(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
        box.setTextureOffset(0, 0).addCuboid(-8.0F, -1.75F, -8.0F, 16.0F, 1.0F, 16.0F, -0.25F, false);
        box.setTextureOffset(0, 0).addCuboid(-8.0F, -6.25F, -8.0F, 16.0F, 1.0F, 16.0F, -0.25F, false);
        box.setTextureOffset(0, 0).addCuboid(-8.0F, -7.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);

        bone102 = new ModelPart(this);
        bone102.setPivot(0.5F, 0.0F, -0.5F);
        box.addChild(bone102);
        bone102.setTextureOffset(0, 0).addCuboid(4.0F, -5.5F, 5.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        bone102.setTextureOffset(0, 0).addCuboid(-8.0F, -5.5F, 5.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        bone102.setTextureOffset(0, 0).addCuboid(-8.0F, -5.5F, -7.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        bone102.setTextureOffset(0, 0).addCuboid(4.0F, -5.5F, -7.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        bone102.setTextureOffset(0, 17).addCuboid(-7.5F, -5.5F, -6.5F, 14.0F, 4.0F, 14.0F, 0.0F, false);
        bone102.setTextureOffset(0, 7).addCuboid(-3.0F, -5.0F, -7.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

        disc = new ModelPart(this);
        disc.setPivot(0.0F, 17.0F, 0.0F);
        disc.setTextureOffset(0, 35).addCuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);
        disc.setTextureOffset(12, 40).addCuboid(-6.5F, -6.501F, -6.5F, 13.0F, 11.0F, 13.0F, -5.5F, false);

        bone103 = new ModelPart(this);
        bone103.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone103);
        setRotationAngle(bone103, 0.0F, -0.3927F, 0.0F);
        bone103.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        bone104 = new ModelPart(this);
        bone104.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone104);
        setRotationAngle(bone104, 0.0F, -0.7854F, 0.0F);
        bone104.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        bone105 = new ModelPart(this);
        bone105.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone105);
        setRotationAngle(bone105, 0.0F, -1.1781F, 0.0F);
        bone105.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        bone106 = new ModelPart(this);
        bone106.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone106);
        setRotationAngle(bone106, 0.0F, -1.5708F, 0.0F);
        bone106.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        bone107 = new ModelPart(this);
        bone107.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone107);
        setRotationAngle(bone107, 0.0F, -1.9635F, 0.0F);
        bone107.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        bone108 = new ModelPart(this);
        bone108.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone108);
        setRotationAngle(bone108, 0.0F, -2.3562F, 0.0F);
        bone108.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        bone109 = new ModelPart(this);
        bone109.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(bone109);
        setRotationAngle(bone109, 0.0F, -2.7489F, 0.0F);
        bone109.setTextureOffset(0, 35).addCuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, -0.0068F, false);

        huahen = new ModelPart(this);
        huahen.setPivot(0.0F, 7.0F, 0.0F);
        disc.addChild(huahen);
        huahen.setTextureOffset(0, 47).addCuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);
        huahen.setTextureOffset(0, 47).addCuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);
        huahen.setTextureOffset(0, 52).addCuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);
        huahen.setTextureOffset(0, 52).addCuboid(3.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);

        bone110 = new ModelPart(this);
        bone110.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone110);
        setRotationAngle(bone110, 0.0F, -0.3927F, 0.0F);
        bone110.setTextureOffset(0, 47).addCuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);
        bone110.setTextureOffset(0, 47).addCuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);

        bone111 = new ModelPart(this);
        bone111.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone111);
        setRotationAngle(bone111, 0.0F, -0.7854F, 0.0F);
        bone111.setTextureOffset(0, 47).addCuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);
        bone111.setTextureOffset(0, 47).addCuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);

        bone112 = new ModelPart(this);
        bone112.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone112);
        setRotationAngle(bone112, 0.0F, -1.1781F, 0.0F);
        bone112.setTextureOffset(0, 47).addCuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);
        bone112.setTextureOffset(0, 47).addCuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);

        bone113 = new ModelPart(this);
        bone113.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone113);
        setRotationAngle(bone113, 0.0F, -1.5708F, 0.0F);
        bone113.setTextureOffset(0, 47).addCuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);
        bone113.setTextureOffset(0, 47).addCuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1022F, false);

        bone114 = new ModelPart(this);
        bone114.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone114);
        setRotationAngle(bone114, 0.0F, -0.3927F, 0.0F);
        bone114.setTextureOffset(0, 52).addCuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);
        bone114.setTextureOffset(0, 52).addCuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);

        bone115 = new ModelPart(this);
        bone115.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone115);
        setRotationAngle(bone115, 0.0F, -0.7854F, 0.0F);
        bone115.setTextureOffset(0, 52).addCuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);
        bone115.setTextureOffset(0, 52).addCuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);

        bone116 = new ModelPart(this);
        bone116.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone116);
        setRotationAngle(bone116, 0.0F, -1.1781F, 0.0F);
        bone116.setTextureOffset(0, 52).addCuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);
        bone116.setTextureOffset(0, 52).addCuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);

        bone117 = new ModelPart(this);
        bone117.setPivot(0.0F, 0.0F, 0.0F);
        huahen.addChild(bone117);
        setRotationAngle(bone117, 0.0F, -1.5708F, 0.0F);
        bone117.setTextureOffset(0, 52).addCuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);
        bone117.setTextureOffset(0, 52).addCuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, -0.2044F, false);

        getDiscBone = new ModelPart(this);
        getDiscBone.setPivot(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        laba.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        tube.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        wheel.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        ruler.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        box.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        disc.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        getDiscBone.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    public ModelPart getDiscBone(){return disc;}

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    public void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
        modelPart.pitch = x;
        modelPart.yaw = y;
        modelPart.roll = z;
    }
}
