package com.derf.ei.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class EICraftingMultiBlock {
	private static ArrayList<EICraftingBlockRecipe> fireTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> waterTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> airTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> earthTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> voidTotem = new ArrayList<EICraftingBlockRecipe>();
	private static Map<String, String> oreDictionary = new HashMap<String, String>();
	private static Map<Item, Item> smelterRecipes = new HashMap<Item, Item>();
	
	public static void init() {
		registerOreDictionaryNames("oreGold", "ingotGold");
		registerOreDictionaryNames("oreIron", "ingotIron");
		registerOreDictionaryNames("oreAluminum", "ingotAluminum");
		registerOreDictionaryNames("oreCopper", "ingotCopper");
		registerOreDictionaryNames("oreLead", "ingotLead");
		registerOreDictionaryNames("oreSilver", "ingotSilver");
		registerOreDictionaryNames("oreTin", "ingotTin");
		registerOreDictionaryNames("oreUranium", "ingotUranium");
		registerOreDictionaryNames("oreArdite", "ingotArdite");
		registerOreDictionaryNames("oreCobalt", "ingotCobalt");
		registerOreDictionaryNames("oreMithril", "ingotMithril");
		registerOreDictionaryNames("oreNickel", "ingotNickel");
		registerOreDictionaryNames("orePlatinum", "ingotPlatinum");
		
		
		
		Iterator it = oreDictionary.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
			
			if(OreDictionary.doesOreNameExist(pair.getKey()) && OreDictionary.doesOreNameExist(pair.getValue())) {
				System.out.println("Both "+pair.getKey()+" and "+pair.getValue()+" exists.");
				
				ArrayList<ItemStack> ores = OreDictionary.getOres(pair.getKey());
				ArrayList<ItemStack> ingots = OreDictionary.getOres(pair.getValue());
				
				for(int i = 0; i < ores.size(); i++) {
					smelterRecipes.put(ores.get(i).getItem(), ingots.get(0).getItem());
					System.out.println(ores.get(i).getUnlocalizedName() + ":" + ingots.get(0).getUnlocalizedName());
				}
			} else {
				System.out.println("Both "+pair.getKey()+" and "+pair.getValue()+" doesn't exists.");
			}
			
		}
		
	}
	
	public static void addFireTotemRecipe(EICraftingBlockRecipe recipe) {
		fireTotem.add(recipe);
	}
	
	public static void addWaterTotemRecipe(EICraftingBlockRecipe recipe) {
		waterTotem.add(recipe);
	}
	
	public static void addAirTotemRecipe(EICraftingBlockRecipe recipe) {
		airTotem.add(recipe);
	}
	
	public static void addEarthTotemRecipe(EICraftingBlockRecipe recipe) {
		earthTotem.add(recipe);
	}
	
	public static void addVoidTotemRecipe(EICraftingBlockRecipe recipe) {
		voidTotem.add(recipe);
	}
	
	public static ArrayList<EICraftingBlockRecipe> getFireTotemRecipes() {
		return fireTotem;
	}
	
	public static ArrayList<EICraftingBlockRecipe> getWaterTotemRecipes() {
		return waterTotem;
	}
	
	public static ArrayList<EICraftingBlockRecipe> getAirTotemRecipes() {
		return airTotem;
	}
	
	public static ArrayList<EICraftingBlockRecipe> getEarthTotemRecipes() {
		return earthTotem;
	}
	
	public static ArrayList<EICraftingBlockRecipe> getVoidTotemRecipe() {
		return voidTotem;
	}
	
	private static void registerOreDictionaryNames(String ore, String ingot) {
		oreDictionary.put(ore, ingot);
	}
	
	public static Item getSmelterResult(ItemStack itemStack) {
		return smelterRecipes.get(itemStack.getItem());
	}
}
