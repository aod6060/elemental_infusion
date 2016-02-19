package com.derf.ei.crafting;

import com.derf.ei.items.EIItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public final class EIInfuserRecipeManager {
	
	public static EIInfuserRecipe blankSlate;
	
	public static void create() {
		// Creating blankSlate Recipe
		blankSlate = new EIInfuserRecipe();
		// Components for crafting
		blankSlate.add(new ItemStack(Blocks.cobblestone));
		blankSlate.add(new ItemStack(EIItems.fireDust));
		blankSlate.add(new ItemStack(EIItems.waterDust));
		blankSlate.add(new ItemStack(EIItems.earthDust));
		blankSlate.add(new ItemStack(EIItems.windDust));
		// Finalized Item
		blankSlate.setCraftedItem(new ItemStack(EIItems.blankRune));
	}
}
