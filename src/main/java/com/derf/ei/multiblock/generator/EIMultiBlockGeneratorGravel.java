package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;

import com.derf.ei.block.EIBlocks;

public class EIMultiBlockGeneratorGravel extends EIMultiBlockGenerator {
	public EIMultiBlockGeneratorGravel() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.fireIronBlock);
		this.setRightBlock(EIBlocks.earthIronBlock);
		this.setGenerated(Blocks.gravel);
	}
}
