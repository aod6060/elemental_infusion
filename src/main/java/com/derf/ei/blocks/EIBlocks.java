package com.derf.ei.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.derf.ei.EILoader;
import com.derf.ei.blocks.tileentity.EITileEntityCore;
import com.derf.ei.blocks.tileentity.EITileEntityElementalInfuser;
import com.derf.ei.client.EIRendererRegister;
import com.derf.ei.creativetabs.EICreativeTabs;
import com.derf.ei.items.EIItemBlock;
import com.derf.ei.items.EIItems;

public final class EIBlocks {
	
	// Element Ore Blocks
	public static Block fireOre;
	public static Block waterOre;
	public static Block earthOre;
	public static Block windOre;
	// Voidium Stone
	public static Block voidiumStone;
	// Elemental Voidium Stone
	// Elemental Infuser
	public static Block elementalInfuser;
	// Light
	public static Block light;
	// Elemental Stone
	public static Block elementalStone;
	// Core
	public static Block core;
	
	public static void create() {
		// Elemental Ores
		fireOre = new EIBlockOre("fire_ore", Material.rock, EIItems.fireDust, 0, 1, 5, 2, 1.0f, 2.0f);
		waterOre = new EIBlockOre("water_ore", Material.rock, EIItems.waterDust, 0, 1, 5, 2, 1.0f, 2.0f);
		earthOre = new EIBlockOre("earth_ore", Material.rock, EIItems.earthDust, 0, 1, 5, 2, 1.0f, 2.0f);
		windOre = new EIBlockOre("wind_ore", Material.rock, EIItems.windDust, 0, 1, 5, 2, 1.0f, 2.0f);
		// Voidium Stone
		voidiumStone = new EIBlockVoidiumStone("voidium_stone", Material.rock);
		// Elemental Infuser
		elementalInfuser = new EIBlockElementalInfuser("elemental_infuser", Material.rock);
		// Light
		light = new EIBlockLight(Material.glass, "light");
		// Elemental Stone
		elementalStone = new EIBlockBasic(Material.rock, "elemental_stone", "pickaxe", 0, 1.0f, 1.0f, 0.0f, false);
		// Core
		core = new EIBlockCore("core");
		
		System.out.println(core.getUnlocalizedName());
	}
	
	public static void register() {
		// Elemenal Ore
		GameRegistry.registerBlock(fireOre, "fire_ore");
		GameRegistry.registerBlock(waterOre, "water_ore");
		GameRegistry.registerBlock(earthOre, "earth_ore");
		GameRegistry.registerBlock(windOre, "wind_ore");
		// Voidium Stone
		//GameRegistry.registerBlock(voidiumStone, "voidium_stone");
		GameRegistry.registerBlock(voidiumStone, EIItemBlock.class, "voidium_stone");
		// Machine Core
		GameRegistry.registerBlock(elementalInfuser, "elemental_infuser");
		// Light
		GameRegistry.registerBlock(light, "light");
		// Elemental Stone
		GameRegistry.registerBlock(elementalStone, "elemental_stone");
		// Core
		GameRegistry.registerBlock(core, "core");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(EITileEntityElementalInfuser.class, "elemental_infuser");
		GameRegistry.registerTileEntity(EITileEntityCore.class, "core");
	}
	
	public static void creativeTabs() {
		// Elemental Ore
		fireOre.setCreativeTab(EICreativeTabs.tabEI);
		waterOre.setCreativeTab(EICreativeTabs.tabEI);
		earthOre.setCreativeTab(EICreativeTabs.tabEI);
		windOre.setCreativeTab(EICreativeTabs.tabEI);
		// Voidium Stone
		voidiumStone.setCreativeTab(EICreativeTabs.tabEI);
		// Machine Core
		elementalInfuser.setCreativeTab(EICreativeTabs.tabEI);
		// Elemental Stone
		elementalStone.setCreativeTab(EICreativeTabs.tabEI);
		// Core
		core.setCreativeTab(EICreativeTabs.tabEI);
	}
	
	public static void crafting() {
		// Elemental Stone
		GameRegistry.addRecipe(
				new ItemStack(elementalStone), 
				" r ",
				"gsy",
				" b ",
				's', new ItemStack(Blocks.stone, 1, 0),
				'r', new ItemStack(Items.dye, 1, 1),
				'b', new ItemStack(Items.dye, 1, 4),
				'g', new ItemStack(Items.dye, 1, 2),
				'y', new ItemStack(Items.dye, 1, 11));
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerVarients() {
		EIRendererRegister.addVariant(
				voidiumStone, 
				"voidium_stone", 
				"voidium_stone_input",
				"voidium_stone_output", 
				"voidium_stone_io", 
				"voidium_stone_fire",
				"voidium_stone_water",
				"voidium_stone_earth",
				"voidium_stone_wind",
				"voidium_stone_void");
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenderer() {
		// Elemental Ore
		EIRendererRegister.register(fireOre, "fire_ore");
		EIRendererRegister.register(waterOre, "water_ore");
		EIRendererRegister.register(earthOre, "earth_ore");
		EIRendererRegister.register(windOre, "wind_ore");
		// Voidium Stone
		EIRendererRegister.register(voidiumStone, 0, "voidium_stone");
		EIRendererRegister.register(voidiumStone, 1, "voidium_stone_input");
		EIRendererRegister.register(voidiumStone, 2, "voidium_stone_output");
		EIRendererRegister.register(voidiumStone, 3, "voidium_stone_io");
		EIRendererRegister.register(voidiumStone, 4, "voidium_stone_fire");
		EIRendererRegister.register(voidiumStone, 5, "voidium_stone_water");
		EIRendererRegister.register(voidiumStone, 6, "voidium_stone_earth");
		EIRendererRegister.register(voidiumStone, 7, "voidium_stone_wind");
		EIRendererRegister.register(voidiumStone, 8, "voidium_stone_void");
		// Elemental Infuser
		EIRendererRegister.register(elementalInfuser, "elemental_infuser");
		// Light
		EIRendererRegister.register(light, "light");
		// Elemental Stone
		EIRendererRegister.register(elementalStone, "elemental_stone");
		// Core
		EIRendererRegister.register(core, "core");
	}
}
