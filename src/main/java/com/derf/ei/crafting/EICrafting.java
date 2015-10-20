package com.derf.ei.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.item.EIItems;

import cpw.mods.fml.common.registry.GameRegistry;

public final class EICrafting {
	public static void create() {
		// Create Void Stone
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.voidStone), 
				"x o", 
				" t ", 
				"v b", 
				'x', EIItems.fireDust,
				'o', EIItems.waterDust,
				't', Blocks.stone,
				'v', EIItems.airDust,
				'b', EIItems.earthDust);
		// Create Void Glass
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.voidGlass), 
				"f w",
				" i ",
				"a e",
				'f', EIItems.fireDust,
				'w', EIItems.waterDust,
				'i', Blocks.glass,
				'a', EIItems.airDust,
				'e', EIItems.earthDust);
		// Create Void Stick
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.voidStick), 
				"x o",
				" t ",
				"v b",
				'x', EIItems.fireDust,
				'o', EIItems.waterDust,
				't', Items.stick,
				'v', EIItems.airDust,
				'b', EIItems.earthDust);
		// Create Machine Core
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.machineCore), 
				"fsw",
				"sis",
				"ase",
				'f', EIItems.fireDust,
				's', EIItems.voidStick,
				'w', EIItems.waterDust,
				'i', Blocks.glass,
				'a', EIItems.airDust,
				'e', EIItems.earthDust);
		// Create Void Tool
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.voidTool),
				"i",
				"s",
				'i', Items.iron_ingot,
				's', EIItems.voidStick);
		
		// 9 fire dusts
		// 9 water dusts
		// 9 air dusts
		// 9 earth dusts
		// 9 fire iron ingots
		// 9 water iron ingots
		// 9 air iron ingots
		// 9 earth iron ingots
		// 9 fire diamonds
		// 9 water diamonds
		// 9 air diamonds
		// 9 earth diamonds
	}
}
