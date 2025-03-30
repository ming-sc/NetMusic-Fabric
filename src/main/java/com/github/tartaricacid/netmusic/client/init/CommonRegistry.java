package com.github.tartaricacid.netmusic.client.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.client.gui.CDBurnerMenuScreen;
import com.github.tartaricacid.netmusic.client.gui.ComputerMenuScreen;
import com.github.tartaricacid.netmusic.client.receiver.GetMusicListMessageReceiver;
import com.github.tartaricacid.netmusic.client.receiver.MusicToClientMessageReceiver;
import com.github.tartaricacid.netmusic.constants.NetworkingConst;
import com.github.tartaricacid.netmusic.init.InitBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl;
import net.minecraft.client.render.RenderLayer;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class CommonRegistry {

    public static void register() {
        ClientSidePacketRegistryImpl.INSTANCE.register(NetworkingConst.PLAY_MUSIC_PACKET_ID, MusicToClientMessageReceiver::receive);
        ClientSidePacketRegistryImpl.INSTANCE.register(NetworkingConst.GET_MUSIC_LIST_PACKET_ID, GetMusicListMessageReceiver::receive);
        BlockRenderLayerMap.INSTANCE.putBlock(InitBlocks.CD_BURNER, RenderLayer.getCutout());
        ScreenRegistry.register(NetMusic.CD_BURNER_MENU_SCREEN_HANDLER_TYPE, CDBurnerMenuScreen::new);
        ScreenRegistry.register(NetMusic.COMPUTER_MENU_SCREEN_HANDLER_TYPE, ComputerMenuScreen::new);
    }
}
