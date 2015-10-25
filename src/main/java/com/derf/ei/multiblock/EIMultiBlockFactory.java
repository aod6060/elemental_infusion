package com.derf.ei.multiblock;

import com.derf.ei.multiblock.furnace.EIMultiBlockFurnaceVoidStone;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorClay;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorCobblestone;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorDirt;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorGravel;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorNetherrack;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorSand;
import com.derf.ei.multiblock.generator.EIMultiBlockGeneratorSoulsand;
import com.derf.ei.multiblock.totem.EIMultiBlockTotemAir;
import com.derf.ei.multiblock.totem.EIMultiBlockTotemEarth;
import com.derf.ei.multiblock.totem.EIMultiBlockTotemFire;
import com.derf.ei.multiblock.totem.EIMultiBlockTotemVoid;
import com.derf.ei.multiblock.totem.EIMultiBlockTotemWater;
import com.derf.ei.tileentity.EITileEntityMachineCore;

public final class EIMultiBlockFactory {
	
	public final static IMultiBlock createMultiBlock(int id) {
		IMultiBlock block = null;
		
		if(id == EITileEntityMachineCore.FIRE_TOTEM) {
			block = new EIMultiBlockTotemFire();
		} else if(id == EITileEntityMachineCore.WATER_TOTEM) {
			block = new EIMultiBlockTotemWater();
		} else if(id == EITileEntityMachineCore.AIR_TOTEM) {
			block = new EIMultiBlockTotemAir();
		} else if(id == EITileEntityMachineCore.EARTH_TOTEM) {
			block = new EIMultiBlockTotemEarth();
		} else if(id == EITileEntityMachineCore.VOID_TOTEM) {
			block = new EIMultiBlockTotemVoid();
		} else if(id == EITileEntityMachineCore.COBBLE_STONE_GENERATOR) {
			block = new EIMultiBlockGeneratorCobblestone();
		} else if(id == EITileEntityMachineCore.DIRT_GENERATOR) {
			block = new EIMultiBlockGeneratorDirt();
		} else if(id == EITileEntityMachineCore.SAND_GENERATOR) {
			block = new EIMultiBlockGeneratorSand();
		} else if(id == EITileEntityMachineCore.CLAY_GENERATOR) {
			block = new EIMultiBlockGeneratorClay();
		} else if(id == EITileEntityMachineCore.GRAVEL_GENERATOR) {
			block = new EIMultiBlockGeneratorGravel();
		} else if(id == EITileEntityMachineCore.NETHER_GENERATOR) {
			block = new EIMultiBlockGeneratorNetherrack();
		} else if(id == EITileEntityMachineCore.SOULSAND_GENERATOR) {
			block = new EIMultiBlockGeneratorSoulsand();
		} else if(id == EITileEntityMachineCore.VOID_STONE_FURNACE) {
			block = new EIMultiBlockFurnaceVoidStone();
		}
		
		return block;
	}
	
}
