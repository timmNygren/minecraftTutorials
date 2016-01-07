package com.dragothmar.teleportmod.proxy;

import com.dragothmar.teleportmod.TeleportMod;
import com.dragothmar.teleportmod.network.GuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class CommonProxy
{
    public void registerRenders()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(TeleportMod.INSTANCE, new GuiHandler());    // Only a single GUI Handler per mod!
    }
}
