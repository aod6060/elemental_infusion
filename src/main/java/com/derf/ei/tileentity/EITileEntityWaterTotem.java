package com.derf.ei.tileentity;

import com.derf.ei.block.EIBlocks;


public class EITileEntityWaterTotem extends EITileEntityTotem {

	@Override
	protected void updateOreBlocks() {
		// TODO Auto-generated method stub
		this.scanTBS();
		this.updateBlock(EIBlocks.waterIronBlock);
	}

}
