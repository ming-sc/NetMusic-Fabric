package com.github.tartaricacid.netmusic;

import com.github.tartaricacid.netmusic.api.NetEaseMusic;
import com.github.tartaricacid.netmusic.api.WebApi;
import com.github.tartaricacid.netmusic.config.GeneralConfig;
import com.github.tartaricacid.netmusic.init.*;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetMusic implements ModInitializer {
	public static final String MOD_ID = "netmusic";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static WebApi NET_EASE_WEB_API;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		NET_EASE_WEB_API = new NetEaseMusic().getApi();
		InitItems.init();
		InitBlocks.init();
		InitBlockEntity.init();
		InitSounds.init();
		CommandRegistry.registryCommand();
		GeneralConfig.INSTANCE.load();
		LOGGER.info("Hello Fabric world!");
	}
}