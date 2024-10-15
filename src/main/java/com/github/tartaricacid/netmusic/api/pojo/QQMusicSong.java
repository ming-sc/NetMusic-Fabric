package com.github.tartaricacid.netmusic.api.pojo;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : IMG
 * @create : 2024/10/15
 */
public class QQMusicSong {

    @SerializedName("songList")
    private List<song> songList;

    public static class song{
        @SerializedName("mid")
        private String mid;

        @SerializedName("name")
        private String name;

        @SerializedName("interval")
        private int interval;

        @SerializedName("singer")
        private List<Singer> singer;

        public static class Singer{
            @SerializedName("name")
            private String name;

            public String getName() {
                return name;
            }
        }

        public String getMid() {
            return mid;
        }

        public String getName() {
            return name;
        }

        public int getInterval() {
            return interval;
        }

        public List<String> getSinger() {
            if (singer == null || singer.isEmpty()){
                return Collections.emptyList();
            }
            List<String> singerList = Lists.newArrayList();
            singer.forEach(singer -> singerList.add(singer.getName()));
            return singerList;
        }
    }

    public List<song> getSongList() {
        return songList;
    }
}
