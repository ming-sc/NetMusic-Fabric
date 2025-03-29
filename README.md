# 1.19.4 分支注意事项
此分支开发环境下运行可能会出现找不到`com.electronwill.night-config:core`和`com.electronwill.night-config:toml`的问题, 需要在`run/config`下创建`fabric_loader_dependencies.json`文件, 文件内容如下.
```json
{
  "version": 1,
  "overrides": {
    "forgeconfigapiport": {
      "-depends": {
        "com_electronwill_night-config_core": "",
        "com_electronwill_night-config_toml": ""
      }
    }
  }
}
```

详见[https://github.com/Fuzss/forgeconfigapiport/wiki/Troubleshooting-Guide](https://github.com/Fuzss/forgeconfigapiport/wiki/Troubleshooting-Guide)