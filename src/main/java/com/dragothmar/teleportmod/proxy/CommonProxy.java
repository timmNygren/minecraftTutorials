package com.dragothmar.teleportmod.proxy;

import com.dragothmar.teleportmod.TeleportMod;
import com.dragothmar.teleportmod.init.TeleportBlocks;
import com.dragothmar.teleportmod.init.TeleportItems;
import com.dragothmar.teleportmod.init.TeleportTileEntities;
import com.dragothmar.teleportmod.network.GuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class CommonProxy
{

    public void preInit(FMLPreInitializationEvent e)
    {
        TeleportBlocks.init();
        TeleportBlocks.register();
        TeleportItems.init();
        TeleportItems.register();
        TeleportTileEntities.register();

        NetworkRegistry.INSTANCE.registerGuiHandler(TeleportMod.INSTANCE, new GuiHandler());    // Only a single GUI Handler per mod!
    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
