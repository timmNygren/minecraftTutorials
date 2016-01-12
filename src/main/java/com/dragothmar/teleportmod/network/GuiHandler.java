package com.dragothmar.teleportmod.network;

import com.dragothmar.teleportmod.client.gui.GuiCoordTransporter;

import com.dragothmar.teleportmod.tileentity.TileEntityCoordTransporter;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.apache.logging.log4j.core.appender.ConsoleAppender;

/**
 * Created by Dragothmar on 1/6/2016.
 */
public class GuiHandler implements IGuiHandler
{
    public static final int COORD_TRANSPORTER_GUI = 0;
    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (COORD_TRANSPORTER_GUI == ID)
        {
            TileEntityCoordTransporter tile = (TileEntityCoordTransporter)world.getTileEntity(new BlockPos(x, y, z));
            System.out.println("TILE_ENTITY_AT: " + tile.getPos().toString());
            return new GuiCoordTransporter(tile);
        }
        return null;
    }
}
