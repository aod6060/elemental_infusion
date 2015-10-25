package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;

import com.derf.ei.block.EIBlocks;

public class EIMultiBlockGeneratorClay extends EIMultiBlockGenerator {
	public EIMultiBlockGeneratorClay() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.waterIronBlock);
		this.setRightBlock(EIBlocks.airIronBlock);
		this.setGenerated(Blocks.clay);
	}
}
