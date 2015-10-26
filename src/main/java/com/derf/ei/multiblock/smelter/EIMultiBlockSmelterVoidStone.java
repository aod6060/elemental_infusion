package com.derf.ei.multiblock.smelter;

import com.derf.ei.block.EIBlocks;

public class EIMultiBlockSmelterVoidStone extends EIMultiBlockSmelter {
	public EIMultiBlockSmelterVoidStone() {
		this.setMaxTime(0.2f);
		this.setQuantity(2);
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicInputBlock(EIBlocks.voidStoneItemInput);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setFireBlock(EIBlocks.fireIronBlock);
	}
}