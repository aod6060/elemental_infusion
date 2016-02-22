package com.derf.ei.crafting;

import java.util.ArrayList;
import java.util.HashMap;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.items.EIItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public final class EIInfuserRecipeManager {
	// Blank Rune
	private static EIInfuserRecipe blankRune;
	// Prima Runes
	private static EIInfuserRecipe fireRune;
	private static EIInfuserRecipe waterRune;
	private static EIInfuserRecipe earthRune;
	private static EIInfuserRecipe windRune;
	private static EIInfuserRecipe voidiumRune;
	// Secondary Runes
	private static EIInfuserRecipe magnetismRune;
	private static EIInfuserRecipe illuminationRune;
	private static EIInfuserRecipe growthRune;
	private static EIInfuserRecipe miningRune;
	// Voidium Ingot
	private static EIInfuserRecipe voidiumIngot; // Tier 1 Tools and Armor
	// Voidium Crystal
	private static EIInfuserRecipe voidiumCrystal; // Tier 2 Tools and Armor
	// Elemental Rods Tier 1
	private static EIInfuserRecipe fireRod;
	private static EIInfuserRecipe waterRod;
	private static EIInfuserRecipe earthRod;
	private static EIInfuserRecipe windRod;
	private static EIInfuserRecipe voidiumRod;
	
	public static HashMap<String, EIInfuserRecipe> recipes;
	public static ArrayList<String> names;
	
	public static void create() {
		// Creating Recipe
		// Blank Rune
		blankRune = new EIInfuserRecipe();
		// Prima Runes
		fireRune = new EIInfuserRecipe();
		waterRune = new EIInfuserRecipe();
		earthRune = new EIInfuserRecipe();
		windRune = new EIInfuserRecipe();
		voidiumRune = new EIInfuserRecipe();
		// Secundario
		magnetismRune = new EIInfuserRecipe();
		illuminationRune = new EIInfuserRecipe();
		growthRune = new EIInfuserRecipe();
		miningRune = new EIInfuserRecipe();
		
		// Voidium Ingot
		voidiumIngot = new EIInfuserRecipe();
		// Voidium Crystal
		voidiumCrystal = new EIInfuserRecipe();
		// Prima Rods
		fireRod = new EIInfuserRecipe();
		waterRod = new EIInfuserRecipe();
		earthRod = new EIInfuserRecipe();
		windRod = new EIInfuserRecipe();
		voidiumRod = new EIInfuserRecipe();
		// Blank Rune
		// Components for crafting
		blankRune.add(new ItemStack(Blocks.cobblestone));
		blankRune.add(new ItemStack(EIItems.fireDust));
		blankRune.add(new ItemStack(EIItems.waterDust));
		blankRune.add(new ItemStack(EIItems.earthDust));
		blankRune.add(new ItemStack(EIItems.windDust));
		blankRune.setCraftedItem(new ItemStack(EIItems.blankRune));
		//blankRune.setDescription("Crafting: Blank Rune");
		// Fire Rune
		fireRune.add(new ItemStack(EIItems.blankRune));
		fireRune.add(new ItemStack(EIItems.fireDust, 4));
		fireRune.setCraftedItem(new ItemStack(EIItems.fireRune));
		//fireRune.setDescription("Crafting: "+StatCollector.translateToLocal(p_translateToLocal_0_));
		// Water Rune
		waterRune.add(new ItemStack(EIItems.blankRune));
		waterRune.add(new ItemStack(EIItems.waterDust, 4));
		waterRune.setCraftedItem(new ItemStack(EIItems.waterRune));
		//waterRune.setDescription("Crafting: Water Rune");
		// Earth Rune
		earthRune.add(new ItemStack(EIItems.blankRune));
		earthRune.add(new ItemStack(EIItems.earthDust, 4));
		earthRune.setCraftedItem(new ItemStack(EIItems.earthRune));
		//earthRune.setDescription("Crafting: Earth Rune");
		// Wind Rune
		windRune.add(new ItemStack(EIItems.blankRune));
		windRune.add(new ItemStack(EIItems.windDust, 4));
		windRune.setCraftedItem(new ItemStack(EIItems.windRune));
		//windRune.setDescription("Crafting: Wind Rune");
		// Voidium Rune
		voidiumRune.add(new ItemStack(EIItems.blankRune));
		voidiumRune.add(new ItemStack(EIItems.fireDust));
		voidiumRune.add(new ItemStack(EIItems.waterDust));
		voidiumRune.add(new ItemStack(EIItems.earthDust));
		voidiumRune.add(new ItemStack(EIItems.windDust));
		voidiumRune.setCraftedItem(new ItemStack(EIItems.voidiumRune));
		// Secondary Rune
		// Magnetism Rune Recipe (Fire Rune, Earth Rune)
		magnetismRune.add(new ItemStack(EIItems.fireRune));
		magnetismRune.add(new ItemStack(EIItems.earthRune));
		magnetismRune.setCraftedItem(new ItemStack(EIItems.magnetismRune));
		// Illumination Rune Recipe (Fire Rune, Wind Rune)
		illuminationRune.add(new ItemStack(EIItems.fireRune));
		illuminationRune.add(new ItemStack(EIItems.windRune));
		illuminationRune.setCraftedItem(new ItemStack(EIItems.illuminationRune));
		// Growth Rune Recipe (Earth Rune, Water Rune)
		growthRune.add(new ItemStack(EIItems.earthRune));
		growthRune.add(new ItemStack(EIItems.waterRune));
		growthRune.setCraftedItem(new ItemStack(EIItems.growthRune));
		// Mining Rune Recipe (Voidium Rune, Fire Rune, Earth Rune)
		miningRune.add(new ItemStack(EIItems.voidiumRune));
		miningRune.add(new ItemStack(EIItems.fireRune));
		miningRune.add(new ItemStack(EIItems.earthRune));
		miningRune.setCraftedItem(new ItemStack(EIItems.miningRune));
		//voidiumRune.setDescription("Crafting: Voidium Rune");
		// Voidium Ingot
		voidiumIngot.add(new ItemStack(Items.iron_ingot));
		voidiumIngot.add(new ItemStack(EIItems.fireDust));
		voidiumIngot.add(new ItemStack(EIItems.waterDust));
		voidiumIngot.add(new ItemStack(EIItems.earthDust));
		voidiumIngot.add(new ItemStack(EIItems.windDust));
		voidiumIngot.setCraftedItem(new ItemStack(EIItems.voidiumIngot));
		//voidiumIngot.setDescription("Crafting: Voidium Ingot");
		// Voidium Crystal
		voidiumCrystal.add(new ItemStack(Items.diamond));
		voidiumCrystal.add(new ItemStack(EIItems.fireDust));
		voidiumCrystal.add(new ItemStack(EIItems.waterDust));
		voidiumCrystal.add(new ItemStack(EIItems.earthDust));
		voidiumCrystal.add(new ItemStack(EIItems.windDust));
		voidiumCrystal.setCraftedItem(new ItemStack(EIItems.voidiumCrystal));
		//voidiumCrystal.setDescription("Crafting: Voidium Crystal");
		// Fire Rod
		fireRod.add(new ItemStack(EIItems.fireRune));
		fireRod.add(new ItemStack(Items.stick));
		fireRod.add(new ItemStack(EIBlocks.voidiumStone));
		fireRod.setCraftedItem(new ItemStack(EIItems.fireRod));
		//fireRod.setDescription("Crafting: Fire Rod");
		// Water Rod
		waterRod.add(new ItemStack(EIItems.waterRune));
		waterRod.add(new ItemStack(Items.stick));
		waterRod.add(new ItemStack(EIBlocks.voidiumStone));
		waterRod.setCraftedItem(new ItemStack(EIItems.waterRod));
		//waterRod.setDescription("Crafting: Water Rod");
		// Earth Rod
		earthRod.add(new ItemStack(EIItems.earthRune));
		earthRod.add(new ItemStack(Items.stick));
		earthRod.add(new ItemStack(EIBlocks.voidiumStone));
		earthRod.setCraftedItem(new ItemStack(EIItems.earthRod));
		//earthRod.setDescription("Crafting: Earth Rod");
		// Wind Rod
		windRod.add(new ItemStack(EIItems.windRune));
		windRod.add(new ItemStack(Items.stick));
		windRod.add(new ItemStack(EIBlocks.voidiumStone));
		windRod.setCraftedItem(new ItemStack(EIItems.windRod));
		//windRod.setDescription("Crafting: Wind Rod");
		// Voidium Rod
		voidiumRod.add(new ItemStack(EIItems.voidiumRune));
		voidiumRod.add(new ItemStack(Items.stick));
		voidiumRod.add(new ItemStack(EIBlocks.voidiumStone));
		voidiumRod.setCraftedItem(new ItemStack(EIItems.voidiumRod));
		//voidiumRod.setDescription("Crafting: Voidium Rod");
		// Register Recipe
		recipes = new HashMap<String, EIInfuserRecipe>();
		names = new ArrayList<String>();
		
		// Blank Rune
		add("blank_rune", blankRune);
		// Prima Runes
		add("fire_rune", fireRune);
		add("water_rune", waterRune);
		add("earth_rune", earthRune);
		add("wind_rune", windRune);
		add("voidium_rune", voidiumRune);
		// Secondary Runes
		add("magnetism_rune", magnetismRune);
		add("illumination_rune", illuminationRune);
		add("growth_rune", growthRune);
		add("mining_rune", miningRune);
		// Voidium Ingot
		add("voidium_ingot", voidiumIngot);
		// Voidium Crystla
		add("voidium_crystal", voidiumCrystal);
		// Prima Rods
		add("fire_rod", fireRod);
		add("water_rod", waterRod);
		add("earth_rod", earthRod);
		add("wind_rod", windRod);
		add("voidium_rod", voidiumRod);
	}
	
	public static EIInfuserRecipe get(String name) {
		return recipes.get(name);
	}
	
	// For 3rd party to add in recipes.
	public static void add(String name, EIInfuserRecipe recipe) {
		recipes.put(name, recipe);
		names.add(name);
	}
	
	public static void getNames(ArrayList<String> ns) {
		
		for(int i = 0; i < names.size(); i++) {
			ns.add(names.get(i));
		}
	}
}
