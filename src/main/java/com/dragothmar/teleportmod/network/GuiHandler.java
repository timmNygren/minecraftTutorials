package com.dragothmar.teleportmod.network;

import com.dragothmar.teleportmod.client.gui.GuiCoordTransporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Dragothmar on 1/6/2016.
 */
public class GuiHandler implements IGuiHandler
{
    public static final int COORD_TRANSPORTER_GUI = 0;

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
            return new GuiCoordTransporter();
        }
        return null;
    }
}
