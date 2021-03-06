package com.dragothmar.teleportmod.proxy;

import com.dragothmar.teleportmod.init.TeleportBlocks;
import com.dragothmar.teleportmod.init.TeleportItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class ClientProxy extends CommonProxy
{

    public void preInit(FMLPreInitializationEvent e)
    {
        super.preInit(e);
    }

    public void init(FMLInitializationEvent e)
    {
        super.init(e);
        TeleportBlocks.registerRenders();
        TeleportItems.registerRenders();
    }

    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
    }
}
