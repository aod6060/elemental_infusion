package com.derf.ei;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICrafting;
import com.derf.ei.item.EIItems;
import com.derf.ei.tileentity.EITileEntities;
import com.derf.ei.world.EIWorldGen;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public static CreativeTabs tabEI = null;
	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e) {
		EIItems.create();
		EIBlocks.create();
		EITileEntities.create();
		
		tabEI = new CreativeTabs("tab_ei") {

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return EIItems.fireDust;
			}
			
		};
		
		
		EIItems.creativeTabs();
		EIBlocks.creativeTabs();
	}
	
	public void init(FMLInitializationEvent e) {
		EICrafting.create();
		GameRegistry.registerWorldGenerator(new EIWorldGen(), 0);
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
