package com.derf.ei.crafting;

import java.util.ArrayList;
import java.util.HashMap;

import com.derf.ei.items.EIItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class EIInfuserRecipeManager {
	// Blank Rune
	private static EIInfuserRecipe blankRune;
	// Elemental Runes
	private static EIInfuserRecipe fireRune;
	private static EIInfuserRecipe waterRune;
	private static EIInfuserRecipe earthRune;
	private static EIInfuserRecipe windRune;
	private static EIInfuserRecipe voidiumRune;
	// Voidium Ingot
	private static EIInfuserRecipe voidiumIngot; // Tier 1 Tools and Armor
	// Voidium Crystal
	private static EIInfuserRecipe voidiumCrystal; // Tier 2 Tools and Armor
	
	public static HashMap<String, EIInfuserRecipe> recipes;
	public static ArrayList<String> names;
	
	public static void create() {
		// Creating Recipe
		blankRune = new EIInfuserRecipe();
		fireRune = new EIInfuserRecipe();
		waterRune = new EIInfuserRecipe();
		earthRune = new EIInfuserRecipe();
		windRune = new EIInfuserRecipe();
		voidiumRune = new EIInfuserRecipe();
		voidiumIngot = new EIInfuserRecipe();
		voidiumCrystal = new EIInfuserRecipe();
		// Blank Rune
		// Components for crafting
		blankRune.add(new ItemStack(Blocks.cobblestone));
		blankRune.add(new ItemStack(EIItems.fireDust));
		blankRune.add(new ItemStack(EIItems.waterDust));
		blankRune.add(new ItemStack(EIItems.earthDust));
		blankRune.add(new ItemStack(EIItems.windDust));
		blankRune.setCraftedItem(new ItemStack(EIItems.blankRune));
		blankRune.setDescription("Crafting: Blank Rune");
		// Fire Rune
		fireRune.add(new ItemStack(EIItems.blankRune));
		fireRune.add(new ItemStack(EIItems.fireDust, 4));
		fireRune.setCraftedItem(new ItemStack(EIItems.fireRune));
		fireRune.setDescription("Crafting: Fire Rune");
		// Water Rune
		waterRune.add(new ItemStack(EIItems.blankRune));
		waterRune.add(new ItemStack(EIItems.waterDust, 4));
		waterRune.setCraftedItem(new ItemStack(EIItems.waterRune));
		waterRune.setDescription("Crafting: Water Rune");
		// Earth Rune
		earthRune.add(new ItemStack(EIItems.blankRune));
		earthRune.add(new ItemStack(EIItems.earthDust, 4));
		earthRune.setCraftedItem(new ItemStack(EIItems.earthRune));
		earthRune.setDescription("Crafting: Earth Rune");
		// Wind Rune
		windRune.add(new ItemStack(EIItems.blankRune));
		windRune.add(new ItemStack(EIItems.windDust, 4));
		windRune.setCraftedItem(new ItemStack(EIItems.windRune));
		windRune.setDescription("Crafting: Wind Rune");
		// Voidium Rune
		voidiumRune.add(new ItemStack(EIItems.blankRune));
		voidiumRune.add(new ItemStack(EIItems.fireDust));
		voidiumRune.add(new ItemStack(EIItems.waterDust));
		voidiumRune.add(new ItemStack(EIItems.earthDust));
		voidiumRune.add(new ItemStack(EIItems.windDust));
		voidiumRune.setCraftedItem(new ItemStack(EIItems.voidiumRune));
		voidiumRune.setDescription("Crafting: Voidium Rune");
		// Voidium Ingot
		voidiumIngot.add(new ItemStack(Items.iron_ingot));
		voidiumIngot.add(new ItemStack(EIItems.fireDust));
		voidiumIngot.add(new ItemStack(EIItems.waterDust));
		voidiumIngot.add(new ItemStack(EIItems.earthDust));
		voidiumIngot.add(new ItemStack(EIItems.windDust));
		voidiumIngot.setCraftedItem(new ItemStack(EIItems.voidiumIngot));
		voidiumIngot.setDescription("Crafting: Voidium Ingot");
		// Voidium Crystal
		voidiumCrystal.add(new ItemStack(Items.diamond));
		voidiumCrystal.add(new ItemStack(EIItems.fireDust));
		voidiumCrystal.add(new ItemStack(EIItems.waterDust));
		voidiumCrystal.add(new ItemStack(EIItems.earthDust));
		voidiumCrystal.add(new ItemStack(EIItems.windDust));
		voidiumCrystal.setCraftedItem(new ItemStack(EIItems.voidiumCrystal));
		voidiumCrystal.setDescription("Crafting: Voidium Crystal");
		// Register Recipe
		recipes = new HashMap<String, EIInfuserRecipe>();
		names = new ArrayList<String>();
		
		add("blank_rune", blankRune);
		add("fire_rune", fireRune);
		add("water_rune", waterRune);
		add("earth_rune", earthRune);
		add("wind_rune", windRune);
		add("voidium_rune", voidiumRune);
		add("voidium_ingot", voidiumIngot);
		add("voidium_crystal", voidiumCrystal);
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
