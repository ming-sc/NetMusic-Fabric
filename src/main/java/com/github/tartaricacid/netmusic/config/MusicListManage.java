package com.github.tartaricacid.netmusic.config;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.api.ExtraMusicList;
import com.github.tartaricacid.netmusic.api.pojo.NetEaseMusicList;
import com.github.tartaricacid.netmusic.api.pojo.NetEaseMusicSong;
import com.github.tartaricacid.netmusic.api.pojo.QQMusicSong;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : IMG
 * @create : 2024/10/6
 */
public class MusicListManage implements SimpleSynchronousResourceReloadListener {
    private static final int MAX_NUM = 100;
    private static final Gson GSON = new Gson();
    private static final Path CONFIG_DIR = Paths.get("config").resolve("net_music");
    private static final Path CONFIG_FILE = CONFIG_DIR.resolve("music.json");
    public static List<ItemMusicCD.SongInfo> SONGS = Lists.newArrayList();
    private static final Pattern QQ_MUSIC_RESULT_REG = Pattern.compile("window\\.__ssrFirstPageData__ =\\{(.*)}}");

    public static void loadConfigSongs(ResourceManager manager) throws IOException {
        if (!Files.isDirectory(CONFIG_DIR)){
            Files.createDirectories(CONFIG_DIR);
        }

        File file = CONFIG_FILE.toFile();
        InputStream stream = null;
        if (Files.exists(CONFIG_FILE)){
            stream = Files.newInputStream(file.toPath());
        }else {
            Identifier res = new Identifier(NetMusic.MOD_ID, "music.json");
            Optional<Resource> optional = manager.getResource(res);
            if (optional.isPresent()){
                stream = optional.get().getInputStream();
            }
        }
        if (stream != null) {
            SONGS = GSON.fromJson(new InputStreamReader(stream, StandardCharsets.UTF_8),
                    new TypeToken<List<ItemMusicCD.SongInfo>>() {
                    }.getType());
        }
    }

    public static ItemMusicCD.SongInfo get163Song(long id) throws Exception {
        NetEaseMusicSong pojo = GSON.fromJson(NetMusic.NET_EASE_WEB_API.song(id), NetEaseMusicSong.class);
        return new ItemMusicCD.SongInfo(pojo);
    }

    public static void add163List(long id) throws Exception {
        if (!Files.isDirectory(CONFIG_DIR)){
            Files.createDirectories(CONFIG_DIR);
        }

        NetEaseMusicList pojo = GSON.fromJson(NetMusic.NET_EASE_WEB_API.list(id), NetEaseMusicList.class);

        int count = pojo.getPlayList().getTracks().size();
        int size = Math.min(pojo.getPlayList().getTrackIds().size(), MAX_NUM);
        // 获取额外歌曲
        if (count < size) {
            long[] ids = new long[size - count];
            for (int i = count; i < size; i++) {
                ids[i - count] = pojo.getPlayList().getTrackIds().get(i).getId();
            }
            String extraTrackInfo = NetMusic.NET_EASE_WEB_API.songs(ids);
            ExtraMusicList extra = GSON.fromJson(extraTrackInfo, ExtraMusicList.class);
            pojo.getPlayList().getTracks().addAll(extra.getTracks());
        }

        SONGS.clear();
        for (NetEaseMusicList.Track track : pojo.getPlayList().getTracks()) {
            SONGS.add(new ItemMusicCD.SongInfo(track));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        FileUtils.write(CONFIG_FILE.toFile(), gson.toJson(SONGS), StandardCharsets.UTF_8);
    }

    public static ItemMusicCD.SongInfo getQQSong(String shareId) throws IOException {
        String result = NetMusic.NET_EASE_WEB_API.getQQMusicInfo(shareId);
        Matcher matcher = QQ_MUSIC_RESULT_REG.matcher(result);
        if (matcher.find()) {
            // 去除掉 window.__ssrFirstPageData__ = 字符串
            String json = "{" + matcher.group(1) + "}}";
            System.out.println(json);
            return new ItemMusicCD.SongInfo(GSON.fromJson(json, QQMusicSong.class));
        }
        return null;
    }

    @Override
    public Identifier getFabricId() {
        return new Identifier(NetMusic.MOD_ID, "music_list");
    }

    @Override
    public void reload(ResourceManager manager) {
        try {
            loadConfigSongs(manager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
