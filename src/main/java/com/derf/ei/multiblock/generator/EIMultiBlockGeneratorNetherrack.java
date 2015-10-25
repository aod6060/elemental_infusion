package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;

import com.derf.ei.block.EIBlocks;

public class EIMultiBlockGeneratorNetherrack extends EIMultiBlockGenerator {
	
	public EIMultiBlockGeneratorNetherrack() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.fireIronBlock);
		this.setRightBlock(EIBlocks.fireIronBlock);
		this.setGenerated(Blocks.netherrack);
	}
	
}
