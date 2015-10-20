package com.derf.ei.tileentity;

import com.derf.ei.block.EIBlocks;


public class EITileEntityEarthTotem extends EITileEntityTotem {

	@Override
	protected void updateOreBlocks() {
		// TODO Auto-generated method stub
		this.scanTBS();
		this.updateBlock(EIBlocks.earthIronBlock);
	}

}
