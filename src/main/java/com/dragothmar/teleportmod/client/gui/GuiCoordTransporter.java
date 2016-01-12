package com.dragothmar.teleportmod.client.gui;


import com.dragothmar.teleportmod.tileentity.TileEntityCoordTransporter;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;


/**
 * Created by Dragothmar on 1/6/2016.
 */
public class GuiCoordTransporter extends GuiScreen
{

    public GuiButton a, b, c, d, e, f;
    TileEntityCoordTransporter tect;

    public GuiCoordTransporter(TileEntityCoordTransporter tect)
    {
        this.tect = tect;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawDefaultBackground();

    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {

        this.buttonList.add(this.a = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "Just a test button"));
        this.buttonList.add(this.b = new GuiButton(1, this.width / 2 - 100, this.height / 2 + 4, "Remove Location"));
        for (int i = 2; i < 10; i++)
        {
            this.buttonList.add(this.c = new GuiButton(2, this.width / 2 - 100, this.height / 2 - 24 + 28 * i, "This is button " + (char)(97 + i)));

        }

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button == this.a)
        {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
            {
                this.mc.thePlayer.addChatMessage(new ChatComponentText("Test message"));
                this.mc.setIngameFocus();
            }
        }
        if (button == this.b)
        {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
            {
                this.mc.setIngameFocus();
            }
        }
    }
}
