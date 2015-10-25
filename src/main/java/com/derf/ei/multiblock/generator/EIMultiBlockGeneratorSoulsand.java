package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;

import com.derf.ei.block.EIBlocks;

public class EIMultiBlockGeneratorSoulsand extends EIMultiBlockGenerator {
	
	public EIMultiBlockGeneratorSoulsand() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.airIronBlock);
		this.setRightBlock(EIBlocks.airIronBlock);
		this.setGenerated(Blocks.soul_sand);
	}
	
}
