package com.dragothmar.teleportmod.init;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.dragothmar.teleportmod.TeleportMod;
import com.dragothmar.teleportmod.Reference;
import com.dragothmar.teleportmod.blocks.BlockCoordTransporter;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class TeleportBlocks
{
    public static Block coord_transporter;

    public static void init()
    {
        coord_transporter = new BlockCoordTransporter(Material.cloth).setUnlocalizedName("coord_transporter").setCreativeTab(TeleportMod.tabTeleport);
    }

    public static void register()
    {
        GameRegistry.registerBlock(coord_transporter, coord_transporter.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(coord_transporter);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
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
