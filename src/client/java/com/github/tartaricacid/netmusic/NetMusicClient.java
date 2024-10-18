package com.github.tartaricacid.netmusic;

import com.github.tartaricacid.netmusic.init.CommonRegistry;
import com.github.tartaricacid.netmusic.init.InitRenderer;
import com.sedmelluq.discord.lavaplayer.player.AudioConfiguration;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerOptions;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.source.http.HttpAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.local.LocalAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.track.InternalAudioTrack;
import com.sedmelluq.discord.lavaplayer.track.TrackStateListener;
import net.fabricmc.api.ClientModInitializer;

import static com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats.COMMON_PCM_S16_BE;
import static com.sedmelluq.discord.lavaplayer.format.StandardAudioDataFormats.COMMON_PCM_S16_LE;

public class NetMusicClient implements ClientModInitializer {
	public static AudioPlayerManager manager;

	@Override
	public void onInitializeClient() {
        CommonRegistry.register();
		InitRenderer.init();

		manager = new DefaultAudioPlayerManager();
		manager.setUseSeekGhosting(false);
		manager.getConfiguration().setOutputFormat(COMMON_PCM_S16_LE);
		manager.registerSourceManager(new HttpAudioSourceManager());
		manager.registerSourceManager(new LocalAudioSourceManager());
		AudioSourceManagers.registerRemoteSources(manager);
	}
}