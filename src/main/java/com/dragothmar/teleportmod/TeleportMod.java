package com.dragothmar.teleportmod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.dragothmar.teleportmod.proxy.CommonProxy;

@Mod(modid=Reference.MODID, version=Reference.VERSION, name=Reference.MOD_NAME)
public class TeleportMod
{
    @Mod.Instance
    public static TeleportMod INSTANCE = new TeleportMod();

    @SidedProxy(serverSide=Reference.SERVER_PROXY_CLASS, clientSide=Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTab tabTeleport = new CreativeTab("tabTeleport");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
