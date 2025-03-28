package com.github.tartaricacid.netmusic;

import com.github.tartaricacid.netmusic.api.NetEaseMusic;
import com.github.tartaricacid.netmusic.api.WebApi;
import com.github.tartaricacid.netmusic.config.GeneralConfig;
import com.github.tartaricacid.netmusic.config.MusicListManage;
import com.github.tartaricacid.netmusic.init.*;
import com.github.tartaricacid.netmusic.inventory.CDBurnerMenu;
import com.github.tartaricacid.netmusic.inventory.ComputerMenu;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetMusic implements ModInitializer {
    public static final String MOD_ID = "netmusic";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static WebApi NET_EASE_WEB_API;

    public static final ScreenHandlerType<CDBurnerMenu> CD_BURNER_MENU_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "cd_burner"), CDBurnerMenu::new);
    public static final ScreenHandlerType<ComputerMenu> COMPUTER_MENU_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "computer"), ComputerMenu::new);

    @Override
    public void onInitialize() {
        NET_EASE_WEB_API = new NetEaseMusic().getApi();

        // 加载 resource 中的歌曲列表
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new MusicListManage());

        InitBlocks.init();
        InitItems.init();
        InitBlockEntity.init();
        InitSounds.init();
        CommandRegistry.registryCommand();
        ReceiverRegistry.register();
        ModLoadingContext.registerConfig(MOD_ID, ModConfig.Type.COMMON, GeneralConfig.init());
    }
}