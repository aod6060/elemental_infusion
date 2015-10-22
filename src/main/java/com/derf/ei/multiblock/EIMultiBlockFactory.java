package com.derf.ei.multiblock;

import com.derf.ei.tileentity.EITileEntityMachineCore;

public final class EIMultiBlockFactory {
	public final static IMultiBlock createMultiBlock(int id) {
		IMultiBlock block = null;
		
		if(id == EITileEntityMachineCore.FIRE_TOTEM) {
			block = new EIMultiBlockFireTotem();
		} else if(id == EITileEntityMachineCore.WATER_TOTEM) {
			block = new EIMultiBlockWaterTotem();
		} else if(id == EITileEntityMachineCore.AIR_TOTEM) {
			block = new EIMultiBlockAirTotem();
		} else if(id == EITileEntityMachineCore.EARTH_TOTEM) {
			block = new EIMultiBlockEarthTotem();
		} else if(id == EITileEntityMachineCore.VOID_TOTEM) {
			block = new EIMultiBlockVoidTotem();
		}
		
		return block;
	}
}
