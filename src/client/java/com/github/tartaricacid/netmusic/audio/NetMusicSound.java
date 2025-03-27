package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.init.InitSounds;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;

import java.net.URL;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class NetMusicSound extends AbstractTickableSoundInstance implements IUrlSound {
    private final URL songUrl;
    private final int tickTimes;
    private final BlockPos pos;
    private int tick;

    public NetMusicSound(BlockPos pos, URL songUrl, int timeSecond) {
        super(InitSounds.NET_MUSIC, SoundCategory.RECORDS);
        this.songUrl = songUrl;
        this.x = pos.getX() + 0.5f;
        this.y = pos.getY() + 0.5f;
        this.z = pos.getZ() + 0.5f;
        this.tickTimes = timeSecond * 20;
        this.volume = 4.0f;
        this.tick = 0;
        this.pos = pos;
    }

    @Override
    public void tick() {
        ClientWorld world = MinecraftClient.getInstance().world;
        if (world == null) {
            return;
        }
        tick++;
        if (tick > tickTimes + 50) {
            this.stop();
        } else {
            if (world.getTime() % 8 == 0) {
                for (int i = 0; i < 2; i++) {
                    world.addParticle(ParticleTypes.NOTE,
                            x - 0.5f + world.random.nextDouble(),
                            y + world.random.nextDouble() + 1,
                            z - 0.5f + world.random.nextDouble(),
                            world.random.nextGaussian(), world.random.nextGaussian(), world.random.nextInt(3));
                }
            }
        }

        BlockEntity te = world.getBlockEntity(pos);
        if (te instanceof TileEntityMusicPlayer) {
            TileEntityMusicPlayer musicPlay = (TileEntityMusicPlayer) te;
            if (!musicPlay.isPlay()) {
                this.stop();
            }
        } else {
            this.stop();
        }
    }

    @Override
    public URL getSongUrl() {
        return songUrl;
    }
}
