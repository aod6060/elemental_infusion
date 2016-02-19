package com.derf.ei;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.crafting.EIInfuserRecipeManager;
import com.derf.ei.creativetabs.EICreativeTabs;
import com.derf.ei.items.EIItems;
import com.derf.ei.world.EIWorldGenerator;

public class EICommonProxy {
	
	
	public void preInit(FMLPreInitializationEvent e) {
		EIItems.create();
		EIBlocks.create();
		EIItems.register();
		EIBlocks.register();
		EIBlocks.registerTileEntities();
		
		EICreativeTabs.create();
		
		EIItems.creativeTabs();
		EIBlocks.creativeTabs();
	}
	
	public void init(FMLInitializationEvent e) {
		EIItems.crafting();
		EIBlocks.crafting();
		EIInfuserRecipeManager.create();
		GameRegistry.registerWorldGenerator(new EIWorldGenerator(), 0);
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
