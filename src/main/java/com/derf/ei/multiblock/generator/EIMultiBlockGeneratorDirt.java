package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;
import com.derf.ei.block.EIBlocks;


public class EIMultiBlockGeneratorDirt extends EIMultiBlockGenerator {
	public EIMultiBlockGeneratorDirt() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.earthIronBlock);
		this.setRightBlock(EIBlocks.earthIronBlock);
		this.setGenerated(Blocks.dirt);
	}
}
