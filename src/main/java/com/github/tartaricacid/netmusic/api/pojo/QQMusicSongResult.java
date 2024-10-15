package com.github.tartaricacid.netmusic.api.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author : IMG
 * @create : 2024/10/15
 */
public class QQMusicSongResult {
    @SerializedName("code")
    private int code;

    @SerializedName("url_mid")
    private UrlMid urlMid;

    public static class UrlMid {
        @SerializedName("data")
        private Data data;

        public static class Data {
            @SerializedName("midurlinfo")
            private List<MidUrlInfo> midUrlInfo;

            public static class MidUrlInfo {
                @SerializedName("purl")
                private String purl;

                public String getPurl() {
                    return purl;
                }

                @Override
                public String toString() {
                    return "MidUrlInfo{" +
                            "purl='" + purl + '\'' +
                            '}';
                }
            }

            public MidUrlInfo getMidUrlInfo() {
                return midUrlInfo.get(0);
            }

            @Override
            public String toString() {
                return "Data{" +
                        "midUrlInfo=" + midUrlInfo +
                        '}';
            }
        }

        public Data getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data=" + data +
                    '}';
        }
    }

    public int getCode() {
        return code;
    }

    public UrlMid getUrlMid() {
        return urlMid;
    }

    @Override
    public String toString() {
        return "QQMusicSongResult{" +
                "code=" + code +
                ", urlMid=" + urlMid +
                '}';
    }
}
