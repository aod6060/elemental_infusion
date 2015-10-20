package com.derf.ei;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid=Main.MODID, name=Main.MODNAME, version=Main.VERSION)
public class Main {
	public final static String MODID   = "ei";
	public final static String MODNAME = "Elemental Infusion";
	public final static String VERSION = "1.0.0";
	
	@Instance
	public static Main main = new Main();
	
	@SidedProxy(clientSide="com.derf.ei.ClientProxy", serverSide="com.derf.ei.ServerProxy")
	public static CommonProxy proxy;
	
	/*
	 * Configuration Stuff
	 */
	public static int fireOreMin;
	public static int fireOreMax;
	public static int fireOreChances;
	public static int fireOreVeinSize;
	public static int waterOreMin;
	public static int waterOreMax;
	public static int waterOreChances;
	public static int waterOreVeinSize;
	public static int airOreMin;
	public static int airOreMax;
	public static int airOreChances;
	public static int airOreVeinSize;
	public static int earthOreMin;
	public static int earthOreMax;
	public static int earthOreChances;
	public static int earthOreVeinSize;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();
		
		fireOreMin = config.getInt("fireOreMin", "Ore", 16, 0, 255, "This is the minimum level were fireOre will spawn.");
		fireOreMax = config.getInt("fireOreMax", "Ore", 32, 0, 255, "This is the maximum level were fireOre will spawn.");
		fireOreChances = config.getInt("fireOreChances", "Ore", 8, 1, 20, "This is the amount of chances that fileOre will spawn.");
		fireOreVeinSize = config.getInt("fireOreVienSize", "Ore", 8, 1, 20, "This sets the vein size of fireOre");
				
		waterOreMin = config.getInt("waterOreMin", "Ore", 16, 0, 255, "This is the minimum level were waterOre will spawn.");
		waterOreMax = config.getInt("waterOreMax", "Ore", 32, 0, 255, "This is the maximum level were waterOre will spawn.");
		waterOreChances = config.getInt("waterOreChances", "Ore", 8, 1, 20, "This is the amount of chances that waterOre will spawn.");
		waterOreVeinSize = config.getInt("waterOreVienSize", "Ore", 8, 1, 20, "This sets the vein size of waterOre");
		
		airOreMin = config.getInt("airOreMin", "Ore", 16, 0, 255, "This is the minimum level were airOre will spawn.");
		airOreMax = config.getInt("airOreMax", "Ore", 32, 0, 255, "This is the maximum level were airOre will spawn.");
		airOreChances = config.getInt("airOreChances", "Ore", 8, 1, 20, "This is the amount of chances that airOre will spawn.");
		airOreVeinSize = config.getInt("airOreVienSize", "Ore", 8, 1, 20, "This sets the vein size of airOre");
		
		earthOreMin = config.getInt("earthOreMin", "Ore", 16, 0, 255, "This is the minimum level were earthOre will spawn.");
		earthOreMax = config.getInt("earthOreMax", "Ore", 32, 0, 255, "This is the maximum level were earthOre will spawn.");
		earthOreChances = config.getInt("earthOreChances", "Ore", 8, 1, 20, "This is the amount of chances that earthOre will spawn.");
		earthOreVeinSize = config.getInt("earthOreVienSize", "Ore", 8, 1, 20, "This sets the vein size of earthOre");
		
		
		config.save();
		
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
}
