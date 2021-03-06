package com.derf.ei.items;

import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.derf.ei.EILoader;
import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.client.EIRendererRegister;
import com.derf.ei.creativetabs.EICreativeTabs;
import com.derf.ei.items.rods.EIItemRodBlast;
import com.derf.ei.items.rods.EIItemRodCobbleStone;
import com.derf.ei.items.rods.EIItemRodDirt;
import com.derf.ei.items.rods.EIItemRodEarth;
import com.derf.ei.items.rods.EIItemRodFire;
import com.derf.ei.items.rods.EIItemRodGrowth;
import com.derf.ei.items.rods.EIItemRodIllumination;
import com.derf.ei.items.rods.EIItemRodLava;
import com.derf.ei.items.rods.EIItemRodLivingMagnet;
import com.derf.ei.items.rods.EIItemRodMagnetism;
import com.derf.ei.items.rods.EIItemRodMinning;
import com.derf.ei.items.rods.EIItemRodSmelting;
import com.derf.ei.items.rods.EIItemRodSnow;
import com.derf.ei.items.rods.EIItemRodSnowGolum;
import com.derf.ei.items.rods.EIItemRodTravel;
import com.derf.ei.items.rods.EIItemRodVoidium;
import com.derf.ei.items.rods.EIItemRodWater;
import com.derf.ei.items.rods.EIItemRodWind;
import com.derf.ei.items.tools.EIItemAxe;
import com.derf.ei.items.tools.EIItemHoe;
import com.derf.ei.items.tools.EIItemPickaxe;
import com.derf.ei.items.tools.EIItemSpade;
import com.derf.ei.items.tools.EIItemSword;

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
	// Wand
	public static Item elementalWand;
	// Rods
	// Fire
	public static Item fireRod;
	public static Item lavaRod;
	public static Item smeltingRod;
	// Water
	public static Item waterRod;
	public static Item snowRod;
	public static Item snowGolumRod;
	// Earth
	public static Item earthRod;
	public static Item dirtRod;
	public static Item cobbleStoneRod;
	// Wind
	public static Item windRod;
	public static Item travelRod;
	public static Item blastRod;
	// Voidium
	public static Item voidiumRod;
	// Complex
	public static Item magnetismRod;
	public static Item illuminationRod;
	public static Item growthRod;
	public static Item minningRod;
	public static Item livingMagnetRod;
	
	public static void create() {
		VOIDIUM = EnumHelper.addToolMaterial("VOIDIUM", 2, 750, 6.0F, 2.0F, 0);
		VOIDIUM_CRYSTAL = EnumHelper.addToolMaterial("VOIDIUM_CRYSTAL", 3, 3122, 8.0F, 3.0F, 0);
		AM_VOIDIUM = EnumHelper.addArmorMaterial("AM_VOIDIUM", EILoader.modid + ":voidium", 15, new int[]{2, 6, 5, 2}, 0, null);
		AM_VOIDIUM_CRYSTAL = EnumHelper.addArmorMaterial("AM_VOIDIUM_CRYSTAL", EILoader.modid + ":voidium_crystal", 20, new int[]{3, 8, 6, 3}, 0, null);
		// Elemental Dust
		fireDust = new EIItemBasic("fire_dust");
		waterDust = new EIItemBasic("water_dust");
		earthDust = new EIItemBasic("earth_dust");
		windDust = new EIItemBasic("wind_dust");
		// Voidium Ingot
		voidiumIngot = new EIItemBasic("voidium_ingot");
		// Voidium Crystal
		voidiumCrystal = new EIItemBasic("voidium_crystal");
		// Tier 1 Tools VOIDIUM
		// Tools
		voidiumSword = new EIItemSword("voidium_sword", VOIDIUM);
		voidiumPickaxe = new EIItemPickaxe("voidium_pickaxe", VOIDIUM);
		voidiumSpade = new EIItemSpade("voidium_shovel", VOIDIUM);
		voidiumAxe = new EIItemAxe("voidium_axe", VOIDIUM);
		voidiumHoe = new EIItemHoe("voidium_hoe", VOIDIUM);
		// Armor
		voidiumHelmet = new EIItemArmor("voidium_helmet", AM_VOIDIUM, 1, EntityEquipmentSlot.HEAD);
		voidiumChestplate = new EIItemArmor("voidium_chestplate", AM_VOIDIUM, 1, EntityEquipmentSlot.CHEST);
		voidiumLeggings = new EIItemArmor("voidium_leggings", AM_VOIDIUM, 2, EntityEquipmentSlot.LEGS);
		voidiumBoots = new EIItemArmor("voidium_boots", AM_VOIDIUM, 1, EntityEquipmentSlot.FEET);
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		voidiumCrystalSword = new EIItemSword("voidium_crystal_sword", VOIDIUM_CRYSTAL);
		voidiumCrystalPickaxe = new EIItemPickaxe("voidium_crystal_pickaxe", VOIDIUM_CRYSTAL);
		voidiumCrystalSpade = new EIItemSpade("voidium_crystal_shovel", VOIDIUM_CRYSTAL);
		voidiumCrystalAxe = new EIItemAxe("voidium_crystal_axe", VOIDIUM_CRYSTAL);
		voidiumCrystalHoe = new EIItemHoe("voidium_crystal_hoe", VOIDIUM_CRYSTAL);
		// Armor
		voidiumCrystalHelmet = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 1, EntityEquipmentSlot.HEAD);
		voidiumCrystalChestplate = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 1, EntityEquipmentSlot.CHEST);
		voidiumCrystalLeggings = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 2, EntityEquipmentSlot.LEGS);
		voidiumCrystalBoots = new EIItemArmor("voidium_crystal_helmet", AM_VOIDIUM_CRYSTAL, 1, EntityEquipmentSlot.FEET);
		// Runes
		// Blank Rune
		blankRune = new EIItemBasic("blank_rune");
		// Prima Runes
		fireRune = new EIItemBasic("fire_rune");
		waterRune = new EIItemBasic("water_rune");
		earthRune = new EIItemBasic("earth_rune");
		windRune = new EIItemBasic("wind_rune");
		voidiumRune = new EIItemBasic("voidium_rune");
		// Wand
		elementalWand = new EIItemElementalWand("elemental_wand");
		// Rods
		// Fire
		fireRod = new EIItemRodFire("fire_rod");
		lavaRod = new EIItemRodLava("lava_rod");
		smeltingRod = new EIItemRodSmelting("smelting_rod");
		// Water
		waterRod = new EIItemRodWater("water_rod");
		snowRod = new EIItemRodSnow("snow_rod");
		snowGolumRod = new EIItemRodSnowGolum("snow_golum_rod");
		// Earth
		earthRod = new EIItemRodEarth("earth_rod");
		dirtRod = new EIItemRodDirt("dirt_rod");
		cobbleStoneRod = new EIItemRodCobbleStone("cobble_stone_rod");
		// Wind
		windRod = new EIItemRodWind("wind_rod");
		travelRod = new EIItemRodTravel("travel_rod");
		blastRod = new EIItemRodBlast("blast_rod");
		// Voidium
		voidiumRod = new EIItemRodVoidium("voidium_rod");
		// Complex
		magnetismRod = new EIItemRodMagnetism("magnetism_rod");
		illuminationRod = new EIItemRodIllumination("illumination_rod");
		growthRod = new EIItemRodGrowth("growth_rod");
		minningRod = new EIItemRodMinning("minning_rod");
		livingMagnetRod = new EIItemRodLivingMagnet("living_magnet_rod");
	}
	
	public static void register() {
		// Elemental Dust
		GameRegistry.registerItem(fireDust, "fire_dust");
		GameRegistry.registerItem(waterDust, "water_dust");
		GameRegistry.registerItem(earthDust, "earth_dust");
		GameRegistry.registerItem(windDust, "wind_dust");
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
		// Wand
		GameRegistry.registerItem(elementalWand, "elemental_wand");
		// Rods
		// Fire
		GameRegistry.registerItem(fireRod, "fire_rod");
		GameRegistry.registerItem(lavaRod, "lava_rod");
		GameRegistry.registerItem(smeltingRod, "smelting_rod");
		// Water
		GameRegistry.registerItem(waterRod, "water_rod");
		GameRegistry.registerItem(snowRod, "snow_rod");
		GameRegistry.registerItem(snowGolumRod, "snow_golum_rod");
		// Earth
		GameRegistry.registerItem(earthRod, "earth_rod");
		GameRegistry.registerItem(dirtRod, "dirt_rod");
		GameRegistry.registerItem(cobbleStoneRod, "cobble_stone_rod");
		// Wind
		GameRegistry.registerItem(windRod, "wind_rod");
		GameRegistry.registerItem(travelRod, "travel_rod");
		GameRegistry.registerItem(blastRod, "blast_rod");
		// Voidium
		GameRegistry.registerItem(voidiumRod, "voidium_rod");
		// Complex
		GameRegistry.registerItem(magnetismRod, "magnetism_rod");
		GameRegistry.registerItem(illuminationRod, "illumination_rod");
		GameRegistry.registerItem(growthRod, "growth_rod");
		GameRegistry.registerItem(minningRod, "minning_rod");
		GameRegistry.registerItem(livingMagnetRod, "living_magnet_rod");
	}
	
	public static void creativeTabs() {
		// Elemental Dust
		fireDust.setCreativeTab(EICreativeTabs.tabEI);
		waterDust.setCreativeTab(EICreativeTabs.tabEI);
		earthDust.setCreativeTab(EICreativeTabs.tabEI);
		windDust.setCreativeTab(EICreativeTabs.tabEI);
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
		// Elemental Wand
		elementalWand.setCreativeTab(EICreativeTabs.tabEI);
		// Rods
		// Fire
		fireRod.setCreativeTab(EICreativeTabs.tabEI);
		lavaRod.setCreativeTab(EICreativeTabs.tabEI);
		smeltingRod.setCreativeTab(EICreativeTabs.tabEI);
		// Water
		waterRod.setCreativeTab(EICreativeTabs.tabEI);
		snowRod.setCreativeTab(EICreativeTabs.tabEI);
		snowGolumRod.setCreativeTab(EICreativeTabs.tabEI);
		// Earth
		earthRod.setCreativeTab(EICreativeTabs.tabEI);
		dirtRod.setCreativeTab(EICreativeTabs.tabEI);
		cobbleStoneRod.setCreativeTab(EICreativeTabs.tabEI);
		// Wind
		windRod.setCreativeTab(EICreativeTabs.tabEI);
		travelRod.setCreativeTab(EICreativeTabs.tabEI);
		blastRod.setCreativeTab(EICreativeTabs.tabEI);
		// Voidium
		voidiumRod.setCreativeTab(EICreativeTabs.tabEI);
		// Complex
		magnetismRod.setCreativeTab(EICreativeTabs.tabEI);
		illuminationRod.setCreativeTab(EICreativeTabs.tabEI);
		growthRod.setCreativeTab(EICreativeTabs.tabEI);
		minningRod.setCreativeTab(EICreativeTabs.tabEI);
		livingMagnetRod.setCreativeTab(EICreativeTabs.tabEI);
	}
	
	public static void crafting() {
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
				'v', voidiumCrystal);
		// Elemental Wand
		GameRegistry.addRecipe(
				new ItemStack(elementalWand),
				"v",
				"s",
				"v",
				'v', EIBlocks.elementalStone,
				's', Items.stick);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenderer() {
		// Elemental Dust
		EIRendererRegister.register(fireDust, "fire_dust");
		EIRendererRegister.register(waterDust, "water_dust");
		EIRendererRegister.register(earthDust, "earth_dust");
		EIRendererRegister.register(windDust, "wind_dust");
		// Voidium Ingot
		EIRendererRegister.register(voidiumIngot, "voidium_ingot");
		// Voidium Crystal
		EIRendererRegister.register(voidiumCrystal, "voidium_crystal");
		// Tier 1 Tools VOIDIUM
		// Tools
		EIRendererRegister.register(voidiumSword, "voidium_sword");
		EIRendererRegister.register(voidiumPickaxe, "voidium_pickaxe");
		EIRendererRegister.register(voidiumSpade, "voidium_shovel");
		EIRendererRegister.register(voidiumAxe, "voidium_axe");
		EIRendererRegister.register(voidiumHoe, "voidium_hoe");
		// Armor
		EIRendererRegister.register(voidiumHelmet, "voidium_helmet");
		EIRendererRegister.register(voidiumChestplate, "voidium_chestplate");
		EIRendererRegister.register(voidiumLeggings, "voidium_leggings");
		EIRendererRegister.register(voidiumBoots, "voidium_boots");
		// Tier 2 Tools (Voidium Crystal Tools and Armor)
		// Tools
		EIRendererRegister.register(voidiumCrystalSword, "voidium_crystal_sword");
		EIRendererRegister.register(voidiumCrystalPickaxe, "voidium_crystal_pickaxe");
		EIRendererRegister.register(voidiumCrystalSpade, "voidium_crystal_shovel");
		EIRendererRegister.register(voidiumCrystalAxe, "voidium_crystal_axe");
		EIRendererRegister.register(voidiumCrystalHoe, "voidium_crystal_hoe");
		// Armor
		// Armor
		EIRendererRegister.register(voidiumCrystalHelmet, "voidium_crystal_helmet");
		EIRendererRegister.register(voidiumCrystalChestplate, "voidium_crystal_chestplate");
		EIRendererRegister.register(voidiumCrystalLeggings, "voidium_crystal_leggings");
		EIRendererRegister.register(voidiumCrystalBoots, "voidium_crystal_boots");
		// Runes
		EIRendererRegister.register(blankRune, "blank_rune");
		// Prima Runes
		EIRendererRegister.register(fireRune, "fire_rune");
		EIRendererRegister.register(waterRune, "water_rune");
		EIRendererRegister.register(earthRune, "earth_rune");
		EIRendererRegister.register(windRune, "wind_rune");
		EIRendererRegister.register(voidiumRune, "voidium_rune");
		// Wand
		EIRendererRegister.register(elementalWand, "elemental_wand");
		// Rods
		// Fire
		EIRendererRegister.register(fireRod, "fire_rod");
		EIRendererRegister.register(lavaRod, "lava_rod");
		EIRendererRegister.register(smeltingRod, "smelting_rod");
		// Water
		EIRendererRegister.register(waterRod, "water_rod");
		EIRendererRegister.register(snowRod, "snow_rod");
		EIRendererRegister.register(snowGolumRod, "snow_golum_rod");
		// Earth
		EIRendererRegister.register(earthRod, "earth_rod");
		EIRendererRegister.register(dirtRod, "dirt_rod");
		EIRendererRegister.register(cobbleStoneRod, "cobble_stone_rod");
		// Wind
		EIRendererRegister.register(windRod, "wind_rod");
		EIRendererRegister.register(travelRod, "travel_rod");
		EIRendererRegister.register(blastRod, "blast_rod");
		// Voidium
		EIRendererRegister.register(voidiumRod, "voidium_rod");
		// Complex
		EIRendererRegister.register(magnetismRod, "magnetism_rod");
		EIRendererRegister.register(illuminationRod, "illumination_rod");
		EIRendererRegister.register(growthRod, "growth_rod");
		EIRendererRegister.register(minningRod, "minning_rod");
		EIRendererRegister.register(livingMagnetRod, "living_magnet_rod");
	}
}
