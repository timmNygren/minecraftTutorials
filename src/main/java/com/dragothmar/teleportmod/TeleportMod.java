package com.dragothmar.teleportmod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.dragothmar.teleportmod.proxy.CommonProxy;
import com.dragothmar.teleportmod.init.TeleportBlocks;
import com.dragothmar.teleportmod.init.TeleportItems;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class TeleportMod
{
    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTab tabTeleport = new CreativeTab("tabTeleport");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        TeleportBlocks.init();
        TeleportBlocks.register();
        TeleportItems.init();
        TeleportItems.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenders();
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
