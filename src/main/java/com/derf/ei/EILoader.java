package com.derf.ei;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import com.derf.ei.command.CommandEI;

@Mod(modid=EILoader.modid, name=EILoader.name, version=EILoader.version)
public class EILoader {
	public static final String modid 	= "ei";
	public static final String name		= "Elemental Infusion";
	public static final String version 	= "0.0.3";
	
	@Instance
	public static EILoader instance = new EILoader();
	
	@SidedProxy(clientSide="com.derf.ei.EIClientProxy", serverSide="com.derf.ei.EIServerProxy")
	public static EICommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent e) {
		e.registerServerCommand(new CommandEI());
	}
}
