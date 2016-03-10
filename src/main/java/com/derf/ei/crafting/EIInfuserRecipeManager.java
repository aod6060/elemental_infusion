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
	// Voidium Ingot
	private static EIInfuserRecipe voidiumIngot; // Tier 1 Tools and Armor
	// Voidium Crystal
	private static EIInfuserRecipe voidiumCrystal; // Tier 2 Tools and Armor
	// Elemental Rods Tier 1
	// Fire
	private static EIInfuserRecipe fireRod;
	private static EIInfuserRecipe lavaRod;
	private static EIInfuserRecipe smeltingRod;
	// Water
	private static EIInfuserRecipe waterRod;
	private static EIInfuserRecipe snowRod;
	private static EIInfuserRecipe snowGolumRod;
	// Earth
	private static EIInfuserRecipe earthRod;
	private static EIInfuserRecipe dirtRod;
	private static EIInfuserRecipe cobbleStoneRod;
	// Wind
	private static EIInfuserRecipe windRod;
	private static EIInfuserRecipe travelRod;
	private static EIInfuserRecipe blastRod;
	// Voidium
	private static EIInfuserRecipe voidiumRod;
	// Complex Rods
	
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
		// Voidium Ingot
		voidiumIngot = new EIInfuserRecipe();
		// Voidium Crystal
		voidiumCrystal = new EIInfuserRecipe();
		// Prima Rods
		// Fire
		fireRod = new EIInfuserRecipe();
		lavaRod = new EIInfuserRecipe();
		smeltingRod = new EIInfuserRecipe();
		// Water
		waterRod = new EIInfuserRecipe();
		snowRod = new EIInfuserRecipe();
		snowGolumRod = new EIInfuserRecipe();
		// Earth
		earthRod = new EIInfuserRecipe();
		dirtRod = new EIInfuserRecipe();
		cobbleStoneRod = new EIInfuserRecipe();
		// Wind
		windRod = new EIInfuserRecipe();
		travelRod = new EIInfuserRecipe();
		blastRod = new EIInfuserRecipe();
		// Voidium
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
		// Lava Rod
		lavaRod.add(new ItemStack(EIItems.fireRune));
		lavaRod.add(new ItemStack(EIItems.fireRod));
		lavaRod.add(new ItemStack(Items.lava_bucket));
		lavaRod.setCraftedItem(new ItemStack(EIItems.lavaRod));
		// Smelting Rod
		smeltingRod.add(new ItemStack(EIItems.fireRune));
		smeltingRod.add(new ItemStack(EIItems.fireRod));
		smeltingRod.add(new ItemStack(Blocks.coal_block));
		smeltingRod.add(new ItemStack(Blocks.furnace));
		smeltingRod.setCraftedItem(new ItemStack(EIItems.smeltingRod));
		// Water Rod
		waterRod.add(new ItemStack(EIItems.waterRune));
		waterRod.add(new ItemStack(Items.stick));
		waterRod.add(new ItemStack(EIBlocks.voidiumStone));
		waterRod.setCraftedItem(new ItemStack(EIItems.waterRod));
		// Snow
		snowRod.add(new ItemStack(EIItems.waterRune));
		snowRod.add(new ItemStack(EIItems.waterRod));
		snowRod.add(new ItemStack(Blocks.snow));
		snowRod.setCraftedItem(new ItemStack(EIItems.snowRod));
		// Snow Golum
		snowGolumRod.add(new ItemStack(EIItems.waterRune));
		snowGolumRod.add(new ItemStack(EIItems.snowRod));
		snowGolumRod.add(new ItemStack(Blocks.snow));
		snowGolumRod.add(new ItemStack(Blocks.pumpkin));
		snowGolumRod.setCraftedItem(new ItemStack(EIItems.snowGolumRod));
		//waterRod.setDescription("Crafting: Water Rod");
		// Earth Rod
		earthRod.add(new ItemStack(EIItems.earthRune));
		earthRod.add(new ItemStack(Items.stick));
		earthRod.add(new ItemStack(EIBlocks.voidiumStone));
		earthRod.setCraftedItem(new ItemStack(EIItems.earthRod));
		// Dirt Rod
		dirtRod.add(new ItemStack(EIItems.earthRune));
		dirtRod.add(new ItemStack(EIItems.earthRod));
		dirtRod.add(new ItemStack(Blocks.dirt, 64));
		dirtRod.setCraftedItem(new ItemStack(EIItems.dirtRod));
		// CobbleStone Rod
		cobbleStoneRod.add(new ItemStack(EIItems.earthRune));
		cobbleStoneRod.add(new ItemStack(EIItems.earthRod));
		cobbleStoneRod.add(new ItemStack(Blocks.cobblestone, 64));
		cobbleStoneRod.setCraftedItem(new ItemStack(EIItems.cobbleStoneRod));
		//earthRod.setDescription("Crafting: Earth Rod");
		// Wind Rod
		windRod.add(new ItemStack(EIItems.windRune));
		windRod.add(new ItemStack(Items.stick));
		windRod.add(new ItemStack(EIBlocks.voidiumStone));
		windRod.setCraftedItem(new ItemStack(EIItems.windRod));
		// Travel
		travelRod.add(new ItemStack(EIItems.windRune));
		travelRod.add(new ItemStack(EIItems.windRod));
		travelRod.add(new ItemStack(Items.feather, 32));
		travelRod.setCraftedItem(new ItemStack(EIItems.travelRod));
		// Blast
		blastRod.add(new ItemStack(EIItems.windRune));
		blastRod.add(new ItemStack(EIItems.windRod));
		blastRod.add(new ItemStack(Items.gunpowder, 32));
		blastRod.setCraftedItem(new ItemStack(EIItems.blastRod));
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
		// Runes
		add("fire_rune", fireRune);
		add("water_rune", waterRune);
		add("earth_rune", earthRune);
		add("wind_rune", windRune);
		add("voidium_rune", voidiumRune);
		// Voidium Ingot
		add("voidium_ingot", voidiumIngot);
		// Voidium Crystla
		add("voidium_crystal", voidiumCrystal);
		// Prima Rods
		// Fire
		add("fire_rod", fireRod);
		add("lava_rod", lavaRod);
		add("smelting_rod", smeltingRod);
		// Water
		add("water_rod", waterRod);
		add("snow_rod", snowRod);
		add("snow_golum_rod", snowGolumRod);
		// Earth
		add("earth_rod", earthRod);
		add("dirt_rod", dirtRod);
		add("cobble_stone_rod", cobbleStoneRod);
		// Wind
		add("wind_rod", windRod);
		add("travel_rod", travelRod);
		add("blast_rod", blastRod);
		// Voidium
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
