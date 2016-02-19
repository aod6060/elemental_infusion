package com.derf.ei.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.derf.ei.EILoader;
import com.derf.ei.client.EIRendererRegister;
import com.derf.ei.creativetabs.EICreativeTabs;

public final class EIItems {
	// Materials
	public static ToolMaterial VOIDIUM;
	public static ToolMaterial VOIDIUM_CRYSTAL;
	public static ArmorMaterial AM_VOIDIUM;
	public static ArmorMaterial AM_VOIDIUM_CRYSTAL;
	// Basic Building Blocks
	// Elemental Dusts
	public static Item fireDust;
	public static Item waterDust;
	public static Item earthDust;
	public static Item windDust;
	public static Item voidiumDust;
	// Voidium Ingot
	public static Item voidiumIngot;
	// VoidiumCrystal
	public static Item voidiumCrystal;
	// Tier 1 Tools (Voidium Ingot Tools and Armor)
	// Tools
	public static Item voidiumSword;
	public static Item voidiumPickaxe;
	public static Item voidiumSpade;
	public static Item voidiumAxe;
	public static Item voidiumHoe;
	// Armor
	public static Item voidiumHelmet;
	public static Item voidiumChestplate;
	public static Item voidiumLeggings;
	public static Item voidiumBoots;
	// Tier 2 Tools (Voidium Crystal Tools and Armor)
	// Tools
	public static Item voidiumCrystalSword;
	public static Item voidiumCrystalPickaxe;
	public static Item voidiumCrystalSpade;
	public static Item voidiumCrystalAxe;
	public static Item voidiumCrystalHoe;
	// Armor
	public static Item voidiumCrystalHelmet;
	public static Item voidiumCrystalChestplate;
	public static Item voidiumCrystalLeggings;
	public static Item voidiumCrystalBoots;
	// Runes (This section contains all of the runes that)
	// Blank Rune
	public static Item blankRune;
	// Prima Rune
	public static Item fireRune;
	public static Item waterRune;
	public static Item earthRune;
	public static Item windRune;
	public static Item voidiumRune;
	// Secondary Runes
	// Wand
	public static Item wand;
	
	public static void create() {
		VOIDIUM = EnumHelper.addToolMaterial("VOIDIUM", 2, 750, 6.0F, 2.0F, 0);
		VOIDIUM_CRYSTAL = EnumHelper.addToolMaterial("VOIDIUM_CRYSTAL", 3, 3122, 8.0F, 3.0F, 0);
		AM_VOIDIUM = EnumHelper.addArmorMaterial("AM_VOIDIUM", EILoader.modid + ":voidium", 15, new int[]{2, 6, 5, 2}, 0);
		AM_VOIDIUM_CRYSTAL = EnumHelper.addArmorMaterial("AM_VOIDIUM_CRYSTAL", EILoader.modid + ":voidium_crystal", 20, new int[]{3, 8, 6, 3}, 0);
		// Elemental Dust
		fireDust = new EIBasicItem("fire_dust");
		waterDust = new EIBasicItem("water_dust");
		earthDust = new EIBasicItem("earth_dust");
		windDust = new EIBasicItem("wind_dust");
		voidiumDust = new EIBasicItem("voidium_dust");
		// Voidium Ingot
		voidiumIngot = new EIBasicItem("voidium_ingot");
		// Voidium Crystal
		voidiumCrystal = new EIBasicItem("voidium_crystal");
		// Tier 1 Tools VOIDIUM
		// Tools
		voidiumSword = new EIItemSword("voidium_sword", VOIDIUM);
		voidiumPickaxe = new EIItemPickaxe("voidium_pickaxe", VOIDIUM);
		voidiumSpade = new EIItemSpade("voidium_shovel", VOIDIUM);
		voidiumAxe = new EIItemAxe("voidium_axe", VOIDIUM);
		voidiumHoe = new EIItemHoe("voidium_hoe", VOIDIUM);
		// Armor
		voidiumHelmet = new EIItemArmor("voidium_helmet", AM_VOIDIUM, 1, 0);
		voidiumChestplate = new EIItemArmor("voidium_chestplate", AM_VOIDIUM, 1, 1);
		voidiumLeggings = new EIItemArmor("voidium_leggings", AM_VOIDIUM, 2, 2);
		voidiumBoots = new EIItemArmor("voidium_boots", AM_VOIDIUM, 1, 3);
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		voidiumCrystalSword = new EIItemSword("voidium_crystal_sword", VOIDIUM_CRYSTAL);
		voidiumCrystalPickaxe = new EIItemPickaxe("voidium_crystal_pickaxe", VOIDIUM_CRYSTAL);
		voidiumCrystalSpade = new EIItemSpade("voidium_crystal_shovel", VOIDIUM_CRYSTAL);
		voidiumCrystalAxe = new EIItemAxe("voidium_crystal_axe", VOIDIUM_CRYSTAL);
		voidiumCrystalHoe = new EIItemHoe("voidium_crystal_hoe", VOIDIUM_CRYSTAL);
		// Armor
		voidiumCrystalHelmet = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 1, 0);
		voidiumCrystalChestplate = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 1, 1);
		voidiumCrystalLeggings = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 2, 2);
		voidiumCrystalBoots = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 1, 3);
		// Runes
		// Blank Rune
		blankRune = new EIBasicItem("blank_rune");
		// Prima Runes
		fireRune = new EIBasicItem("fire_rune");
		waterRune = new EIBasicItem("water_rune");
		earthRune = new EIBasicItem("earth_rune");
		windRune = new EIBasicItem("wind_rune");
		voidiumRune = new EIBasicItem("voidium_rune");
		// Secondary Runes
		// Wand
		wand = new EIItemWand("wand");
	}
	
	public static void register() {
		// Elemental Dust
		GameRegistry.registerItem(fireDust, "fire_dust");
		GameRegistry.registerItem(waterDust, "water_dust");
		GameRegistry.registerItem(earthDust, "earth_dust");
		GameRegistry.registerItem(windDust, "wind_dust");
		GameRegistry.registerItem(voidiumDust, "voidium_dust");
		// Voidium Ingot
		GameRegistry.registerItem(voidiumIngot, "voidium_ingot");
		// Voidium Crystal
		GameRegistry.registerItem(voidiumCrystal, "voidium_crystal");
		// Tier 1 Tools VOIDIUM
		// Tools
		GameRegistry.registerItem(voidiumSword, "voidium_sword");
		GameRegistry.registerItem(voidiumPickaxe, "voidium_pickaxe");
		GameRegistry.registerItem(voidiumSpade, "voidium_shovel");
		GameRegistry.registerItem(voidiumAxe, "voidium_axe");
		GameRegistry.registerItem(voidiumHoe, "voidium_hoe");
		// Armor
		GameRegistry.registerItem(voidiumHelmet, "voidium_helmet");
		GameRegistry.registerItem(voidiumChestplate, "voidium_chestplate");
		GameRegistry.registerItem(voidiumLeggings, "voidium_leggings");
		GameRegistry.registerItem(voidiumBoots, "voidium_boots");
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		GameRegistry.registerItem(voidiumCrystalSword, "voidium_crystal_sword");
		GameRegistry.registerItem(voidiumCrystalPickaxe, "voidium_crystal_pickaxe");
		GameRegistry.registerItem(voidiumCrystalSpade, "voidium_crystal_shovel");
		GameRegistry.registerItem(voidiumCrystalAxe, "voidium_crystal_axe");
		GameRegistry.registerItem(voidiumCrystalHoe, "voidium_crystal_hoe");
		// Armor
		GameRegistry.registerItem(voidiumCrystalHelmet, "voidium_crystal_helmet");
		GameRegistry.registerItem(voidiumCrystalChestplate, "voidium_crystal_chestplate");
		GameRegistry.registerItem(voidiumCrystalLeggings, "voidium_crystal_leggings");
		GameRegistry.registerItem(voidiumCrystalBoots, "voidium_crystal_boots");
		// Runes
		// Blank Runes
		GameRegistry.registerItem(blankRune, "blank_rune");
		// Prima Runes
		GameRegistry.registerItem(fireRune, "fire_rune");
		GameRegistry.registerItem(waterRune, "water_rune");
		GameRegistry.registerItem(earthRune, "earth_rune");
		GameRegistry.registerItem(windRune, "wind_rune");
		GameRegistry.registerItem(voidiumRune, "voidium_rune");
		// Secondary Runes
		// Wand
		GameRegistry.registerItem(wand, "wand");
	}
	
	public static void creativeTabs() {
		// Elemental Dust
		fireDust.setCreativeTab(EICreativeTabs.tabEI);
		waterDust.setCreativeTab(EICreativeTabs.tabEI);
		earthDust.setCreativeTab(EICreativeTabs.tabEI);
		windDust.setCreativeTab(EICreativeTabs.tabEI);
		voidiumDust.setCreativeTab(EICreativeTabs.tabEI);
		// Voidium Ingot
		voidiumIngot.setCreativeTab(EICreativeTabs.tabEI);
		// Voidium Crystal
		voidiumCrystal.setCreativeTab(EICreativeTabs.tabEI);
		// Tier 1 Tools VOIDIUM
		// Tools
		voidiumSword.setCreativeTab(EICreativeTabs.tabEI);
		voidiumPickaxe.setCreativeTab(EICreativeTabs.tabEI);
		voidiumSpade.setCreativeTab(EICreativeTabs.tabEI);
		voidiumAxe.setCreativeTab(EICreativeTabs.tabEI);
		voidiumHoe.setCreativeTab(EICreativeTabs.tabEI);
		// Armor
		voidiumHelmet.setCreativeTab(EICreativeTabs.tabEI);
		voidiumChestplate.setCreativeTab(EICreativeTabs.tabEI);
		voidiumLeggings.setCreativeTab(EICreativeTabs.tabEI);
		voidiumBoots.setCreativeTab(EICreativeTabs.tabEI);
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		voidiumCrystalSword.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalPickaxe.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalSpade.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalAxe.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalHoe.setCreativeTab(EICreativeTabs.tabEI);
		// Armor
		voidiumCrystalHelmet.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalChestplate.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalLeggings.setCreativeTab(EICreativeTabs.tabEI);
		voidiumCrystalBoots.setCreativeTab(EICreativeTabs.tabEI);
		// Runes
		// Blank Runes
		blankRune.setCreativeTab(EICreativeTabs.tabEI);
		// Prima Runes
		fireRune.setCreativeTab(EICreativeTabs.tabEI);
		waterRune.setCreativeTab(EICreativeTabs.tabEI);
		earthRune.setCreativeTab(EICreativeTabs.tabEI);
		windRune.setCreativeTab(EICreativeTabs.tabEI);
		voidiumRune.setCreativeTab(EICreativeTabs.tabEI);
		// Secondary Runes
		// Wand
		wand.setCreativeTab(EICreativeTabs.tabEI);
	}
	
	public static void crafting() {
		// Voidium Ingot
		GameRegistry.addShapelessRecipe(
				new ItemStack(voidiumIngot), 
				Items.iron_ingot,
				fireDust,
				waterDust,
				earthDust,
				windDust);
		// Voidium Crystal
		GameRegistry.addShapelessRecipe(
				new ItemStack(voidiumCrystal), 
				Items.diamond,
				fireDust,
				waterDust,
				earthDust,
				windDust);
		// Tier 1 Tools VOIDIUM
		// Tools
		GameRegistry.addRecipe(
				new ItemStack(voidiumSword), 
				"v",
				"v",
				"s",
				'v', voidiumIngot,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumPickaxe), 
				"vvv",
				" s ",
				" s ",
				'v', voidiumIngot,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumSpade), 
				"v",
				"s",
				"s",
				'v', voidiumIngot,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumAxe), 
				"vv ",
				"vs ",
				" s ",
				'v', voidiumIngot,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumHoe), 
				"vv ",
				" s ",
				" s ",
				'v', voidiumIngot,
				's', Items.stick);
		// Armor
		GameRegistry.addRecipe(
				new ItemStack(voidiumHelmet), 
				"vvv",
				"v v",
				"  ",
				'v', voidiumIngot);
		GameRegistry.addRecipe(
				new ItemStack(voidiumChestplate), 
				"v v",
				"vvv",
				"vvv",
				'v', voidiumIngot);
		GameRegistry.addRecipe(
				new ItemStack(voidiumLeggings), 
				"vvv",
				"v v",
				"v v",
				'v', voidiumIngot);
		GameRegistry.addRecipe(
				new ItemStack(voidiumBoots), 
				"v v",
				"v v",
				"  ",
				'v', voidiumIngot);
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalSword), 
				"v",
				"v",
				"s",
				'v', voidiumCrystal,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalPickaxe), 
				"vvv",
				" s ",
				" s ",
				'v', voidiumCrystal,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalSpade), 
				"v",
				"s",
				"s",
				'v', voidiumCrystal,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalAxe), 
				"vv ",
				"vs ",
				" s ",
				'v', voidiumCrystal,
				's', Items.stick);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalHoe), 
				"vv ",
				" s ",
				" s ",
				'v', voidiumCrystal,
				's', Items.stick);
		// Armor
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalHelmet), 
				"vvv",
				"v v",
				"  ",
				'v', voidiumCrystal);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalChestplate), 
				"v v",
				"vvv",
				"vvv",
				'v', voidiumCrystal);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalLeggings), 
				"vvv",
				"v v",
				"v v",
				'v', voidiumCrystal);
		GameRegistry.addRecipe(
				new ItemStack(voidiumCrystalBoots), 
				"v v",
				"v v",
				"  ",
				'v', voidiumCrystal);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenderer() {
		// Elemental Dust
		EIRendererRegister.register(fireDust, 0, EILoader.modid + ":fire_dust");
		EIRendererRegister.register(waterDust, 0, EILoader.modid + ":water_dust");
		EIRendererRegister.register(earthDust, 0, EILoader.modid + ":earth_dust");
		EIRendererRegister.register(windDust, 0, EILoader.modid + ":wind_dust");
		EIRendererRegister.register(voidiumDust, 0, EILoader.modid + ":voidium_dust");
		// Voidium Ingot
		EIRendererRegister.register(voidiumIngot, 0, EILoader.modid + ":voidium_ingot");
		// Voidium Crystal
		EIRendererRegister.register(voidiumCrystal, 0, EILoader.modid + ":voidium_crystal");
		// Tier 1 Tools VOIDIUM
		// Tools
		EIRendererRegister.register(voidiumSword, 0, EILoader.modid + ":voidium_sword");
		EIRendererRegister.register(voidiumPickaxe, 0, EILoader.modid + ":voidium_pickaxe");
		EIRendererRegister.register(voidiumSpade, 0, EILoader.modid + ":voidium_shovel");
		EIRendererRegister.register(voidiumAxe, 0, EILoader.modid + ":voidium_axe");
		EIRendererRegister.register(voidiumHoe, 0, EILoader.modid + ":voidium_hoe");
		// Armor
		EIRendererRegister.register(voidiumHelmet, 0, EILoader.modid + ":voidium_helmet");
		EIRendererRegister.register(voidiumChestplate, 0, EILoader.modid + ":voidium_chestplate");
		EIRendererRegister.register(voidiumLeggings, 0, EILoader.modid + ":voidium_leggings");
		EIRendererRegister.register(voidiumBoots, 0, EILoader.modid + ":voidium_boots");
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		EIRendererRegister.register(voidiumCrystalSword, 0, EILoader.modid + ":voidium_crystal_sword");
		EIRendererRegister.register(voidiumCrystalPickaxe, 0, EILoader.modid + ":voidium_crystal_pickaxe");
		EIRendererRegister.register(voidiumCrystalSpade, 0, EILoader.modid + ":voidium_crystal_shovel");
		EIRendererRegister.register(voidiumCrystalAxe, 0, EILoader.modid + ":voidium_crystal_axe");
		EIRendererRegister.register(voidiumCrystalHoe, 0, EILoader.modid + ":voidium_crystal_hoe");
		// Armor
		// Armor
		EIRendererRegister.register(voidiumCrystalHelmet, 0, EILoader.modid + ":voidium_crystal_helmet");
		EIRendererRegister.register(voidiumCrystalChestplate, 0, EILoader.modid + ":voidium_crystal_chestplate");
		EIRendererRegister.register(voidiumCrystalLeggings, 0, EILoader.modid + ":voidium_crystal_leggings");
		EIRendererRegister.register(voidiumCrystalBoots, 0, EILoader.modid + ":voidium_crystal_boots");
		// Runes
		EIRendererRegister.register(blankRune, 0, EILoader.modid + ":blank_rune");
		// Prima Runes
		EIRendererRegister.register(fireRune, 0, EILoader.modid + ":fire_rune");
		EIRendererRegister.register(waterRune, 0, EILoader.modid + ":water_rune");
		EIRendererRegister.register(earthRune, 0, EILoader.modid + ":earth_rune");
		EIRendererRegister.register(windRune, 0, EILoader.modid + ":wind_rune");
		EIRendererRegister.register(voidiumRune, 0, EILoader.modid + ":voidium_rune");
		// Secondary Runes
		// Wand
		EIRendererRegister.register(wand, 0, EILoader.modid + ":wand");
	}
}
