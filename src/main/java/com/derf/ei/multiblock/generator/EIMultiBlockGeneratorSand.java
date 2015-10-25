package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;

import com.derf.ei.block.EIBlocks;

public class EIMultiBlockGeneratorSand extends EIMultiBlockGenerator {
	public EIMultiBlockGeneratorSand() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.fireIronBlock);
		this.setRightBlock(EIBlocks.airIronBlock);
		this.setGenerated(Blocks.sand);
	}
}
