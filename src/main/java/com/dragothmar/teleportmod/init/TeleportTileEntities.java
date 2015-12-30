package com.dragothmar.teleportmod.init;

import com.dragothmar.teleportmod.Reference;
import com.dragothmar.teleportmod.tileentity.TileEntityCoordTransporter;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Dragothmar on 12/30/2015.
 */
public class TeleportTileEntities
{
    public static void register()
    {
        GameRegistry.registerTileEntity(TileEntityCoordTransporter.class, Reference.MODID + "CoordTransporter");
    }
}
