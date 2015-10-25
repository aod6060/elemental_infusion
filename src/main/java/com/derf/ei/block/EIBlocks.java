package com.derf.ei.block;

import com.derf.ei.CommonProxy;
import com.derf.ei.EIType;
import com.derf.ei.item.EIItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public final class EIBlocks {
	
	/*
	 * I need a number of blocks for this project
	 * 
	 * 1 I need an ore block for each of the dusts
	 * 1) fireOre
	 * 2) waterOre
	 * 3) airOre
	 * 4) earthOre
	 * 
	 * I'll also need Blocks of each of the dust to conserve
	 * space
	 * 1) fireBlock
	 * 2) waterBlock
	 * 3) airBlock
	 * 4) earthBlock
	 * 
	 * Then I need a block that will be used for creating
	 * the magic machines that will be built
	 * 
	 * 1) VoidStone
	 * 
	 * Totums are used to create individual element metals
	 * and crystals
	 */
	// Ore Section
	public static Block fireOre;
	public static Block waterOre;
	public static Block airOre;
	public static Block earthOre;
	// Block Section
	public static Block fireBlock;
	public static Block waterBlock;
	public static Block airBlock;
	public static Block earthBlock;
	public static Block voidBlock;
	// VoidStone
	public static Block voidStone;
	public static Block voidStoneItemInput;
	public static Block voidStoneItemOutput;
	// Machine Core
	public static Block machineCore;
	// VoidGlass
	public static Block voidGlass;
	// Elemental Iron Blocks
	public static Block fireIronBlock;
	public static Block waterIronBlock;
	public static Block airIronBlock;
	public static Block earthIronBlock;
	// Elemental Diamonds Blocks
	public static Block fireDiamondBlock;
	public static Block waterDiamondBlock;
	public static Block airDiamondBlock;
	public static Block earthDiamondBlock;
	
	public static void create() {
		// Create Ore
		fireOre = new EIBlockOre("fire_ore", Material.rock, 1.0f, 2.0f, "pickaxe", 1, EIItems.fireDust, 1, 4);
		waterOre = new EIBlockOre("water_ore", Material.rock, 1.0f, 2.0f, "pickaxe", 1, EIItems.waterDust, 1, 4);
		airOre = new EIBlockOre("air_ore", Material.rock, 1.0f, 2.0f, "pickaxe", 1, EIItems.airDust, 1, 4);
		earthOre = new EIBlockOre("earth_ore", Material.rock, 1.0f, 2.0f, "pickaxe", 1, EIItems.earthDust, 1, 4);
		// Create Blocks
		fireBlock = new EIBlock("fire_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		waterBlock = new EIBlock("water_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		airBlock = new EIBlock("air_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		earthBlock = new EIBlock("earth_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		voidBlock = new EIBlock("void_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal); 
		// Create VoidStone
		voidStone = new EIBlockVoidStone("void_stone");
		voidStoneItemInput = new EIBlockVoidStone("void_stone_item_input");
		voidStoneItemOutput = new EIBlockVoidStone("void_stone_item_output");
		// Machine Core
		machineCore = new EIBlockMachineCore();
		// VoidGlass
		voidGlass = new EIBlockGlass("void_glass", Material.glass, 1.0f, 1.0f, "pickaxe", 0);
		
		// Elemental Iron Blocks
		fireIronBlock = new EIBlock("fire_iron_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		waterIronBlock = new EIBlock("water_iron_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		airIronBlock = new EIBlock("air_iron_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal);
		earthIronBlock = new EIBlock("earth_iron_block", Material.iron, 1.0f, 2.0f, "pickaxe", 1, Block.soundTypeMetal); 
		// Elemental Diamond Blocks
		fireDiamondBlock = new EIBlock("fire_diamond_block", Material.iron, 1.0f, 2.0f, "pickaxe", 2, Block.soundTypeMetal);
		waterDiamondBlock = new EIBlock("water_diamond_block", Material.iron, 1.0f, 2.0f, "pickaxe", 2, Block.soundTypeMetal);
		airDiamondBlock = new EIBlock("air_diamond_block", Material.iron, 1.0f, 2.0f, "pickaxe", 2, Block.soundTypeMetal);
		earthDiamondBlock = new EIBlock("earth_diamond_block", Material.iron, 1.0f, 2.0f, "pickaxe", 2, Block.soundTypeMetal); 
		
		// GameRegistry
		GameRegistry.registerBlock(fireOre, "fire_ore");
		GameRegistry.registerBlock(waterOre, "water_ore");
		GameRegistry.registerBlock(airOre, "air_ore");
		GameRegistry.registerBlock(earthOre, "earth_ore");
		
		GameRegistry.registerBlock(fireBlock, "fire_block");
		GameRegistry.registerBlock(waterBlock, "water_block");
		GameRegistry.registerBlock(airBlock, "air_block");
		GameRegistry.registerBlock(earthBlock, "earth_block");
		GameRegistry.registerBlock(voidBlock, "void_block");
		
		GameRegistry.registerBlock(voidStone, "void_stone");
		GameRegistry.registerBlock(voidStoneItemInput, "void_stone_item_input");
		GameRegistry.registerBlock(voidStoneItemOutput, "void_stone_item_output");
		
		GameRegistry.registerBlock(machineCore, "machine_core");
		GameRegistry.registerBlock(voidGlass, "void_glass");
		
		GameRegistry.registerBlock(fireIronBlock, "fire_iron_block");
		GameRegistry.registerBlock(waterIronBlock, "water_iron_block");
		GameRegistry.registerBlock(airIronBlock, "air_iron_block");
		GameRegistry.registerBlock(earthIronBlock, "earth_iron_block");
		
		GameRegistry.registerBlock(fireDiamondBlock, "fire_diamond_block");
		GameRegistry.registerBlock(waterDiamondBlock, "water_diamond_block");
		GameRegistry.registerBlock(airDiamondBlock, "air_diamond_block");
		GameRegistry.registerBlock(earthDiamondBlock, "earth_diamond_block");
	}
	
	public static void creativeTabs() {
		fireOre.setCreativeTab(CommonProxy.tabEI);
		waterOre.setCreativeTab(CommonProxy.tabEI);
		airOre.setCreativeTab(CommonProxy.tabEI);
		earthOre.setCreativeTab(CommonProxy.tabEI);
		
		fireBlock.setCreativeTab(CommonProxy.tabEI);
		waterBlock.setCreativeTab(CommonProxy.tabEI);
		airBlock.setCreativeTab(CommonProxy.tabEI);
		earthBlock.setCreativeTab(CommonProxy.tabEI);
		voidBlock.setCreativeTab(CommonProxy.tabEI);
		
		voidStone.setCreativeTab(CommonProxy.tabEI);
		machineCore.setCreativeTab(CommonProxy.tabEI);
		voidGlass.setCreativeTab(CommonProxy.tabEI);
		
		fireIronBlock.setCreativeTab(CommonProxy.tabEI);
		waterIronBlock.setCreativeTab(CommonProxy.tabEI);
		airIronBlock.setCreativeTab(CommonProxy.tabEI);
		earthIronBlock.setCreativeTab(CommonProxy.tabEI);
		
		fireDiamondBlock.setCreativeTab(CommonProxy.tabEI);
		waterDiamondBlock.setCreativeTab(CommonProxy.tabEI);
		airDiamondBlock.setCreativeTab(CommonProxy.tabEI);
		earthDiamondBlock.setCreativeTab(CommonProxy.tabEI);
	}
	
	/*
	 * Ore Section
	 */
	public static boolean isFireOre(Block block) {
		return fireOre.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isWaterOre(Block block) {
		return waterOre.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isAirOre(Block block) {
		return airOre.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isEarthOre(Block block) {
		return earthOre.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	/*
	 * Dust Block Section
	 */
	public static boolean isFireBlock(Block block) {
		return fireBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isWaterBlock(Block block) {
		return waterBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isAirBlock(Block block) {
		return airBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isEarthBlock(Block block) {
		return earthBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isVoidBlock(Block block) {
		return voidBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	/*
	 * Void Stone Section
	 */
	public static boolean isVoidStone(Block block) {
		return voidStone.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isVoidStoneItemInput(Block block) {
		return voidStoneItemInput.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isVoidStoneItemOutput(Block block) {
		return voidStoneItemOutput.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	/*
	 * Machine Core Section
	 */
	public static boolean isMachineCore(Block block) {
		return machineCore.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	/*
	 * Void Glass Section
	 */
	public static boolean isVoidGlass(Block block) {
		return voidGlass.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	/*
	 * Elemental Iron Section
	 */
	public static boolean isFireIronBlock(Block block) {
		return fireIronBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isWaterIronBlock(Block block) {
		return waterIronBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isAirIronBlock(Block block) {
		return airIronBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isEarthIronBlock(Block block) {
		return earthIronBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	/*
	 * Elemental Diamond Section
	 */
	public static boolean isFireDiamondBlock(Block block) {
		return fireDiamondBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isWaterDiamondBlock(Block block) {
		return waterDiamondBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isAirDiamondBlock(Block block) {
		return airDiamondBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isEarthDiamondBlock(Block block) {
		return earthDiamondBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
	
	public static boolean isBlock(Block b, Block b2) {
		return b.getUnlocalizedName().equals(b2.getUnlocalizedName());
	}
}
