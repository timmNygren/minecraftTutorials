package com.dragothmar.teleportmod;

import com.dragothmar.teleportmod.init.TeleportItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class CreativeTab extends CreativeTabs
{
    public CreativeTab(String label)
    {
        super(label);
        this.setBackgroundImageName("teleport.png");
    }

    @Override
    public Item getTabIconItem()
    {
        return TeleportItems.coord_cache;
    }
}
