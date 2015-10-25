package com.derf.ei.multiblock.generator;

import net.minecraft.init.Blocks;
import com.derf.ei.block.EIBlocks;


public class EIMultiBlockGeneratorCobblestone extends EIMultiBlockGenerator {
	
	public EIMultiBlockGeneratorCobblestone() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setLeftBlock(EIBlocks.fireIronBlock);
		this.setRightBlock(EIBlocks.waterIronBlock);
		//this.setGeneratedBlock(Blocks.cobblestone);
		this.setGenerated(Blocks.cobblestone);
	}
}
