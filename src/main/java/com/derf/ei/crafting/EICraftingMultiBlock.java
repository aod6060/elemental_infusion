package com.derf.ei.crafting;

import java.util.ArrayList;

public final class EICraftingMultiBlock {
	private static ArrayList<EICraftingBlockRecipe> fireTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> waterTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> airTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> earthTotem = new ArrayList<EICraftingBlockRecipe>();
	private static ArrayList<EICraftingBlockRecipe> voidTotem = new ArrayList<EICraftingBlockRecipe>();
	
	
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
}
