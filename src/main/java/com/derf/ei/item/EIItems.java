package com.derf.ei.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

import com.derf.ei.CommonProxy;
import com.derf.ei.block.EIBlocks;
import com.derf.ei.fluid.EIFluids;
import com.derf.ei.handlers.EIBucketHandler;

import cpw.mods.fml.common.registry.GameRegistry;

public final class EIItems {
	
	/*
	 * Elemental Dusts
	 * 
	 * - fire element dust
	 * - water element dust
	 * - air element dust
	 * - earth element dust
	 * 
	 * There are only 4 for now.
	 * I might add in darkness and
	 * light element
	 */
	// Elemental Dusts
	public static Item fireDust;
	public static Item waterDust;
	public static Item airDust;
	public static Item earthDust;
	public static Item voidDust;
	// Elemental Iron Ingots
	public static Item fireIronIngot;
	public static Item waterIronIngot;
	public static Item airIronIngot;
	public static Item earthIronIngot;
	public static Item voidIronIngot;
	// Elemental Diamonds
	public static Item fireDiamond;
	public static Item waterDiamond;
	public static Item airDiamond;
	public static Item earthDiamond;
	public static Item voidDiamond;
	// Void Stick
	public static Item voidStick;
	// Void Tool
	public static Item voidTool;
	// Elemental Dust Buckets
	public static Item bucketLiquidFireDust;
	public static Item bucketLiquidWaterDust;
	public static Item bucketLiquidAirDust;
	public static Item bucketLiquidEarthDust;
	
	// Simple Debug Tool
	public static Item debugTool;
	// Void Tooles (Void Diamond, Void Iron)
	
	public static void create() {
		// Elemental Dusts
		fireDust = new EIItem("fire_dust");
		waterDust = new EIItem("water_dust");
		airDust = new EIItem("air_dust");
		earthDust = new EIItem("earth_dust");
		voidDust = new EIItem("void_dust");
		// Elemental Iron Ingots
		fireIronIngot = new EIItem("fire_iron_ingot");
		waterIronIngot = new EIItem("water_iron_ingot");
		airIronIngot = new EIItem("air_iron_ingot");
		earthIronIngot = new EIItem("earth_iron_ingot");
		voidIronIngot = new EIItem("void_iron_ingot");
		// Elemental Diamonds
		fireDiamond = new EIItem("fire_diamond");
		waterDiamond = new EIItem("water_diamond");
		airDiamond = new EIItem("air_diamond");
		earthDiamond = new EIItem("earth_diamond");
		voidDiamond = new EIItem("void_diamond");
		// Void Stick
		voidStick = new EIItem("void_stick");
		// Void Tool
		voidTool = new EIItemVoidTool("void_tool");
		// Liquid Dust Buckets
		bucketLiquidFireDust = new EIItemBucket("bucket_liquid_fire_dust", EIBlocks.liquidFireDust);
		bucketLiquidWaterDust = new EIItemBucket("bucket_liquid_water_dust", EIBlocks.liquidWaterDust);
		bucketLiquidAirDust = new EIItemBucket("bucket_liquid_air_dust", EIBlocks.liquidAirDust);
		bucketLiquidEarthDust = new EIItemBucket("bucket_liquid_earth_dust", EIBlocks.liquidEarthDust);
		// Debug Tool
		debugTool = new EIItemDebugTool("debug_tool");
		
		GameRegistry.registerItem(fireDust, "fire_dust");
		GameRegistry.registerItem(waterDust, "water_dust");
		GameRegistry.registerItem(airDust, "air_dust");
		GameRegistry.registerItem(earthDust, "earth_dust");
		GameRegistry.registerItem(voidDust, "void_dust");
		
		GameRegistry.registerItem(fireIronIngot, "fire_iron_ingot");
		GameRegistry.registerItem(waterIronIngot, "water_iron_ingot");
		GameRegistry.registerItem(airIronIngot, "air_iron_ingot");
		GameRegistry.registerItem(earthIronIngot, "earth_iron_ingot");
		GameRegistry.registerItem(voidIronIngot, "void_iron_ingot");
		
		GameRegistry.registerItem(fireDiamond, "fire_diamond");
		GameRegistry.registerItem(waterDiamond, "water_diamond");
		GameRegistry.registerItem(airDiamond, "air_diamond");
		GameRegistry.registerItem(earthDiamond, "earth_diamond");
		GameRegistry.registerItem(voidDiamond, "void_diamond");
		
		GameRegistry.registerItem(voidStick, "void_stick");
		
		GameRegistry.registerItem(voidTool, "void_tool");
		
		GameRegistry.registerItem(bucketLiquidFireDust, "bucket_liquid_fire_dust");
		GameRegistry.registerItem(bucketLiquidWaterDust, "bucket_liquid_water_dust");
		GameRegistry.registerItem(bucketLiquidAirDust, "bucket_liquid_air_dust");
		GameRegistry.registerItem(bucketLiquidEarthDust, "bucket_liquid_earth_dust");
		
		GameRegistry.registerItem(debugTool, "debug_tool");
		
		
		// Fluid Container Registry
		FluidContainerRegistry.registerFluidContainer(EIFluids.fireDustFluid, new ItemStack(bucketLiquidFireDust), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(EIFluids.waterDustFluid, new ItemStack(bucketLiquidWaterDust), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(EIFluids.airDustFluid, new ItemStack(bucketLiquidAirDust), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(EIFluids.earthDustFluid, new ItemStack(bucketLiquidEarthDust), new ItemStack(Items.bucket));
		
		// Registering bucket to Event Handler
		EIBucketHandler.INSTANCE.buckets.put(EIBlocks.liquidFireDust, bucketLiquidFireDust);
		EIBucketHandler.INSTANCE.buckets.put(EIBlocks.liquidWaterDust, bucketLiquidWaterDust);
		EIBucketHandler.INSTANCE.buckets.put(EIBlocks.liquidAirDust, bucketLiquidAirDust);
		EIBucketHandler.INSTANCE.buckets.put(EIBlocks.liquidEarthDust, bucketLiquidEarthDust);
	}
	
	public static void creativeTabs() {
		fireDust.setCreativeTab(CommonProxy.tabEI);
		waterDust.setCreativeTab(CommonProxy.tabEI);
		airDust.setCreativeTab(CommonProxy.tabEI);
		earthDust.setCreativeTab(CommonProxy.tabEI);
		voidDust.setCreativeTab(CommonProxy.tabEI);
		
		fireIronIngot.setCreativeTab(CommonProxy.tabEI);
		waterIronIngot.setCreativeTab(CommonProxy.tabEI);
		airIronIngot.setCreativeTab(CommonProxy.tabEI);
		earthIronIngot.setCreativeTab(CommonProxy.tabEI);
		voidIronIngot.setCreativeTab(CommonProxy.tabEI);
		
		fireDiamond.setCreativeTab(CommonProxy.tabEI);
		waterDiamond.setCreativeTab(CommonProxy.tabEI);
		airDiamond.setCreativeTab(CommonProxy.tabEI);
		earthDiamond.setCreativeTab(CommonProxy.tabEI);
		voidDiamond.setCreativeTab(CommonProxy.tabEI);
		
		voidStick.setCreativeTab(CommonProxy.tabEI);
		
		voidTool.setCreativeTab(CommonProxy.tabEI);
		
		bucketLiquidFireDust.setCreativeTab(CommonProxy.tabEI);
		bucketLiquidWaterDust.setCreativeTab(CommonProxy.tabEI);
		bucketLiquidAirDust.setCreativeTab(CommonProxy.tabEI);
		bucketLiquidEarthDust.setCreativeTab(CommonProxy.tabEI);
		
		debugTool.setCreativeTab(CommonProxy.tabEI);
	
	}
}
