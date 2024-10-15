package com.github.tartaricacid.netmusic.constants;

/**
 * @author : IMG
 * @create : 2024/10/15
 */
public class URLConst {
    public static final String QQ_MUSIC_URL = "https://u.y.qq.com/cgi-bin/musicu.fcg?data=" +
            "{\"comm\":{\"ct\":23,\"cv\":0}," +
            "\"data_mid\":{\"module\":\"track_info.UniformRuleCtrlServer\",\"method\":\"GetTrackInfo\",\"param\":{\"mids\":[\"%s\"],\"types\":[0]}},\"url_mid\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"1\",\"songmid\":[\"%s\"],\"songtype\":[0],\"uin\":\"0\",\"loginflag\":0,\"platform\":\"23\"}}}";
}
