package com.github.tartaricacid.netmusic.item;

import com.github.tartaricacid.netmusic.api.pojo.NetEaseMusicList;
import com.github.tartaricacid.netmusic.api.pojo.NetEaseMusicSong;
import com.github.tartaricacid.netmusic.constants.NetworkingConst;
import com.github.tartaricacid.netmusic.networking.message.MusicToClientMessage;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class ItemMusicCD extends Item {

    public ItemMusicCD(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return super.use(world, user, hand);

        PacketByteBuf buf = MusicToClientMessage.toBuffer(
                new MusicToClientMessage(
                        user.getBlockPos(),
                        "https://music.163.com/song/media/outer/url?id=1311347847.mp3",
                        155,
                        "Sea,You Next"
                )
        );

        ServerPlayNetworking.send((ServerPlayerEntity) user, NetworkingConst.PLAY_MUSIC_PACKET_ID, buf);

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    public static class SongInfo{

        @SerializedName("url")
        public String songUrl;

        @SerializedName("name")
        public String songName;

        @SerializedName("time_second")
        public int songTime;

        @SerializedName("trans_name")
        public String transName = StringUtils.EMPTY;

        @SerializedName("vip")
        public boolean vip = false;

        @SerializedName("read_only")
        public boolean readOnly = false;

        @SerializedName("artists")
        public List<String> artists = Lists.newArrayList();

        public SongInfo(String songUrl, String songName, int songTime, boolean readOnly) {
            this.songUrl = songUrl;
            this.songName = songName;
            this.songTime = songTime;
            this.readOnly = readOnly;
        }

        public SongInfo(NetEaseMusicSong pojo) {
            NetEaseMusicSong.Song song = pojo.getSong();
            if (song != null) {
                this.songUrl = String.format("https://music.163.com/song/media/outer/url?id=%d.mp3", song.getId());
                this.songName = song.getName();
                this.songTime = song.getDuration() / 1000;
                this.transName = song.getTransName();
                this.vip = song.needVip();
                this.artists = song.getArtists();
            }
        }

        public SongInfo(NetEaseMusicList.Track track) {
            this.songUrl = String.format("https://music.163.com/song/media/outer/url?id=%d.mp3", track.getId());
            this.songName = track.getName();
            this.songTime = track.getDuration() / 1000;
            this.transName = track.getTransName();
            this.vip = track.needVip();
            this.artists = track.getArtists();
        }

        public SongInfo(NbtCompound nbt) {
            this.songUrl = nbt.getString("url");
            this.songName = nbt.getString("name");
            this.songTime = nbt.getInt("time");
            if (nbt.contains("trans_name", NbtElement.SHORT_TYPE)) {
                this.transName = nbt.getString("trans_name");
            }
            if (nbt.contains("vip", NbtElement.BYTE_TYPE)) {
                this.vip = nbt.getBoolean("vip");
            }
            if (nbt.contains("read_only", NbtElement.BYTE_TYPE)) {
                this.readOnly = nbt.getBoolean("read_only");
            }
            if (nbt.contains("artists", NbtElement.LIST_TYPE)) {
                this.artists = nbt.getList("artists", 8).stream().map(NbtElement::asString).toList();
            }
        }

        public static SongInfo deserializeNBT(NbtCompound nbt){
            return new SongInfo(nbt);
        }

        public static void serializeNBT(SongInfo info, NbtCompound nbt) {
            nbt.putString("url", info.songUrl);
            nbt.putString("name", info.songName);
            nbt.putInt("time", info.songTime);
            if (StringUtils.isNoneBlank(info.transName)) {
                nbt.putString("trans_name", info.transName);
            }
            nbt.putBoolean("vip", info.vip);
            nbt.putBoolean("read_only", info.readOnly);
            if (info.artists != null && !info.artists.isEmpty()) {
                NbtList nbtList = new NbtList();
                info.artists.forEach(artist -> nbtList.add(NbtString.of(artist)));
                nbt.put("artists", nbtList);
            }
        }
    }
}
