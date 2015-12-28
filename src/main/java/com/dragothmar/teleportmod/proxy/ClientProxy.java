package com.dragothmar.teleportmod.proxy;

import com.dragothmar.teleportmod.init.TeleportBlocks;
import com.dragothmar.teleportmod.init.TeleportItems;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenders()
    {
        TeleportBlocks.registerRenders();
        TeleportItems.registerRenders();
    }
}
