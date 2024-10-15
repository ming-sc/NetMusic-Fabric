# NetMusic 1.20.1 Fabric dev

---

这里是 NetMusic 的 Fabric 开发分支，用于开发新功能和修复问题。

## 新增的功能

1. 使用 [lavaplayer](https://github.com/sedmelluq/lavaplayer) 支持更多的音频格式.
2. 新增对QQ音乐的支持. (在刻录机粘贴分享链接以刻录歌曲, 与网易云音乐不冲突)

## 待修复的问题

1. 加载音乐时可能会出现卡顿. (可能是因为 `AudioPlayer.provide()` 方法的的阻塞)
2. 不兼容物理声效重制模组. (物理声效不稳定, 时有时无)
3. QQ音乐的分享链接子域名可能不一样.
4. QQ音乐获取播放链接错误的情况没做处理.
