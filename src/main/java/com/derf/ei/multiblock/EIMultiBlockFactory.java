package com.derf.ei.multiblock;

import com.derf.ei.tileentity.EITileEntityMachineCore;

public final class EIMultiBlockFactory {
	public final static IMultiBlock createMultiBlock(int id) {
		IMultiBlock block = null;
		
		if(id == EITileEntityMachineCore.FIRE_TOTEM) {
			block = new EIMultiBlockFireTotem();
		}
		
		return block;
	}
}
