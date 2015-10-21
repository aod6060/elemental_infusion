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
				'i', EIBlocks.voidStone,
				'a', EIItems.airDust,
				'e', EIItems.earthDust);
		// Create Void Tool
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.voidTool),
				"i",
				"s",
				'i', Items.iron_ingot,
				's', EIItems.voidStick);
		// NOTE: I'm considering to remove to totem heads
		// And replace it with the Dust Blocks
		// fire totem head
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.fireTotumHead), 
				" f ",
				"fif",
				" f ",
				'f', EIItems.fireDust,
				'i', EIBlocks.voidStone);
		// water totem head
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.waterTotumHead), 
				" w ",
				"wiw",
				" w ",
				'w', EIItems.waterDust,
				'i', EIBlocks.voidStone);
		// air totem head
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.airTotumHead), 
				" a ",
				"aia",
				" a ",
				'a', EIItems.airDust,
				'i', EIBlocks.voidStone);
		// earth totem head
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.earthTotumHead), 
				" e ",
				"eie",
				" e ",
				'e', EIItems.earthDust,
				'i', EIBlocks.voidStone);
		// 9 fire dusts
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.fireDust, 9),
				"f",
				'f', EIBlocks.fireBlock);
		// 9 water dusts
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.waterDust, 9),
				"f",
				'f', EIBlocks.waterBlock);
		// 9 air dusts
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.airDust, 9),
				"f",
				'f', EIBlocks.airBlock);
		// 9 earth dusts
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.earthDust, 9),
				"f",
				'f', EIBlocks.earthBlock);
		// 9 fire iron ingots
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.fireIronIngot, 9),
				"f",
				'f', EIBlocks.fireIronBlock);
		// 9 water iron ingots
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.waterIronIngot, 9),
				"f",
				'f', EIBlocks.waterIronBlock);
		// 9 air iron ingots
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.airIronIngot, 9),
				"f",
				'f', EIBlocks.airIronBlock);
		// 9 earth iron ingots
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.earthIronIngot, 9),
				"f",
				'f', EIBlocks.earthIronBlock);
		// 9 fire diamonds
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.fireDiamond, 9),
				"f",
				'f', EIBlocks.fireDiamondBlock);
		// 9 water diamonds
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.waterDiamond, 9),
				"f",
				'f', EIBlocks.waterDiamondBlock);
		// 9 air diamonds
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.airDiamond, 9),
				"f",
				'f', EIBlocks.airDiamondBlock);
		// 9 earth diamonds
		GameRegistry.addShapedRecipe(
				new ItemStack(EIItems.earthDiamond, 9),
				"f",
				'f', EIBlocks.earthDiamondBlock);
		// 1 fire dust block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.fireBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.fireDust);
		// 1 water dust block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.waterBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.waterDust);
		// 1 air dust block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.airBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.airDust);
		// 1 earth dust block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.earthBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.earthDust);
		// 1 fire iron block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.fireIronBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.fireIronIngot);
		// 1 water iron block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.waterIronBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.waterIronIngot);
		// 1 air iron block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.airIronBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.airIronIngot);
		// 1 earth iron block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.earthIronBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.earthIronIngot);
		// 1 fire diamond block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.fireDiamondBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.fireDiamond);
		// 1 water diamond block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.waterDiamondBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.waterDiamond);
		// 1 air diamond block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.airDiamondBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.airDiamond);
		// 1 earth diamond block
		GameRegistry.addShapedRecipe(
				new ItemStack(EIBlocks.earthDiamondBlock), 
				"fff",
				"fff",
				"fff",
				'f', EIItems.earthDiamond);
	}
}
