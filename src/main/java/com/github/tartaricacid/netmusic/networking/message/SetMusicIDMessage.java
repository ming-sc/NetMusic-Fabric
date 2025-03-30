package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import io.netty.buffer.Unpooled;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public class SetMusicIDMessage implements Message<SetMusicIDMessage>{
    private final static Identifier PACKET_ID = new Identifier(NetMusic.MOD_ID, "set_music_id");
    public final ItemMusicCD.SongInfo song;

    public SetMusicIDMessage(ItemMusicCD.SongInfo song) {
        this.song = song;
    }

    @Override
    public PacketByteBuf toBuffer() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        CompoundTag nbt = new CompoundTag();
        ItemMusicCD.SongInfo.serializeNBT(song, nbt);
        return buf.writeCompoundTag(nbt);
    }

    public static SetMusicIDMessage fromBuffer(PacketByteBuf buf) {
        CompoundTag nbt = buf.readCompoundTag();
        ItemMusicCD.SongInfo songData = ItemMusicCD.SongInfo.deserializeNBT(nbt);
        return new SetMusicIDMessage(songData);
    }

    @Override
    public Identifier getPacketId() {
        return PACKET_ID;
    }

    public static Identifier getPacketIdStatic() {
        return PACKET_ID;
    }
}