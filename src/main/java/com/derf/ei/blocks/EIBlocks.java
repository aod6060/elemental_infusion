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
import com.derf.ei.blocks.tileentity.EITileEntityMachineCore;
import com.derf.ei.client.EIRendererRegister;
import com.derf.ei.creativetabs.EICreativeTabs;
import com.derf.ei.items.EIItems;

public final class EIBlocks {
	
	// Element Ore Blocks
	public static Block fireOre;
	public static Block waterOre;
	public static Block earthOre;
	public static Block windOre;
	// Voidium Stone
	public static Block voidiumStone;
	public static Block voidiumStoneInput;
	public static Block voidiumStoneOutput;
	public static Block voidiumStoneIO;
	// Machine Core
	public static Block machineCore;
	
	public static void create() {
		// Elemental Ores
		fireOre = new EIBlockOre("fire_ore", Material.rock, EIItems.fireDust, 0, 1, 5, 2, 1.0f, 2.0f);
		waterOre = new EIBlockOre("water_ore", Material.rock, EIItems.waterDust, 0, 1, 5, 2, 1.0f, 2.0f);
		earthOre = new EIBlockOre("earth_ore", Material.rock, EIItems.earthDust, 0, 1, 5, 2, 1.0f, 2.0f);
		windOre = new EIBlockOre("wind_ore", Material.rock, EIItems.windDust, 0, 1, 5, 2, 1.0f, 2.0f);
		// Voidium Stone
		voidiumStone = new EIBlockVoidiumStone("voidium_stone", Material.rock);
		voidiumStoneInput = new EIBlockVoidiumStone("voidium_stone_input", Material.rock);
		voidiumStoneOutput = new EIBlockVoidiumStone("voidium_stone_output", Material.rock);
		voidiumStoneIO = new EIBlockVoidiumStone("voidium_stone_io", Material.rock);
		// Machine Core
		machineCore = new EIBlockMachineCore("machine_core", Material.rock);
	}
	
	public static void register() {
		// Elemenal Ore
		GameRegistry.registerBlock(fireOre, "fire_ore");
		GameRegistry.registerBlock(waterOre, "water_ore");
		GameRegistry.registerBlock(earthOre, "earth_ore");
		GameRegistry.registerBlock(windOre, "wind_ore");
		// Voidium Stone
		GameRegistry.registerBlock(voidiumStone, "voidium_stone");
		GameRegistry.registerBlock(voidiumStoneInput, "voidium_stone_input");
		GameRegistry.registerBlock(voidiumStoneOutput, "voidium_stone_output");
		GameRegistry.registerBlock(voidiumStoneIO, "voidium_stone_io");
		// Machine Core
		GameRegistry.registerBlock(machineCore, "machine_core");
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(EITileEntityMachineCore.class, "tileentity_machine_core");
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
		machineCore.setCreativeTab(EICreativeTabs.tabEI);
	}
	
	public static void crafting() {
		// Voidium Stone
		GameRegistry.addRecipe(
				new ItemStack(voidiumStone), 
				" f ",
				"esd",
				" w ",
				'f', EIItems.fireDust,
				'w', EIItems.waterDust,
				'e', EIItems.earthDust,
				'd', EIItems.windDust,
				's', Blocks.stone);
		// Machine Core
		GameRegistry.addRecipe(
				new ItemStack(machineCore), 
				"sfs",
				"evd",
				"sws",
				's', Items.stick,
				'f', EIItems.fireDust,
				'w', EIItems.waterDust,
				'e', EIItems.earthDust,
				'd', EIItems.windDust,
				'v', voidiumStone);
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenderer() {
		// Elemental Ore
		EIRendererRegister.register(fireOre, 0, EILoader.modid + ":fire_ore");
		EIRendererRegister.register(waterOre, 0, EILoader.modid + ":water_ore");
		EIRendererRegister.register(earthOre, 0, EILoader.modid + ":earth_ore");
		EIRendererRegister.register(windOre, 0, EILoader.modid + ":wind_ore");
		// Voidium Stone
		EIRendererRegister.register(voidiumStone, 0, EILoader.modid + ":voidium_stone");
		EIRendererRegister.register(voidiumStoneInput, 0, EILoader.modid + ":voidium_stone_input");
		EIRendererRegister.register(voidiumStoneOutput, 0, EILoader.modid + ":voidium_stone_output");
		EIRendererRegister.register(voidiumStoneIO, 0, EILoader.modid + ":voidium_stone_io");
		// Machine Core
		EIRendererRegister.register(machineCore, 0, EILoader.modid + ":machine_core");
	}
}
