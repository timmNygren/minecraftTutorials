package com.dragothmar.teleportmod.init;

import com.dragothmar.teleportmod.TeleportMod;
import com.dragothmar.teleportmod.Reference;
import com.dragothmar.teleportmod.items.ItemCoordinateCache;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class TeleportItems
{

    public static Item coord_cache;

    public static void init()
    {
        coord_cache = new ItemCoordinateCache().setUnlocalizedName("coord_cache").setCreativeTab(TeleportMod.tabTeleport);
    }

    public static void register()
    {
        GameRegistry.registerItem(coord_cache, coord_cache.getUnlocalizedName().substring(5)) ; // unlocal name is tile.coord_cache
    }

    public static void registerRenders()
    {
        registerRender(coord_cache);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                item,
                0,
                new ModelResourceLocation(
                        Reference.MODID + ":" + item.getUnlocalizedName().substring(5),
                        "inventory"
                        )
        );
    }
}
