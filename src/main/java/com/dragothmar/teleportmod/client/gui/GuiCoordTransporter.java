package com.dragothmar.teleportmod.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

/**
 * Created by Dragothmar on 1/6/2016.
 */
public class GuiCoordTransporter extends GuiScreen
{
    private GuiButton a, b;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void initGui()
    {
        this.buttonList.add(this.a = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "This is button a"));
        this.buttonList.add(this.b = new GuiButton(1, this.width / 2 - 100, this.height / 2 + 4, "This is button b"));

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button == this.a)
        {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null)
            {
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
