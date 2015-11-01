package com.derf.ei.multiblock.itemvoid;

import com.derf.ei.block.EIBlocks;

/**
 * 3 levels
 * 
 * Basic 		0.5  seconds 1  item
 * Renforced    0.25 seconds 32 items
 * Omni			0.1  seconds 64	items
 * @author Fred
 *
 */
public class EIMultiBlockItemVoidBasic extends EIMultiBlockItemVoid {
	public EIMultiBlockItemVoidBasic() {
		this.setLeftBlock(EIBlocks.voidBlock);
		this.setRightBlock(EIBlocks.voidBlock);
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicInputBlock(EIBlocks.voidStoneItemInput);
		this.setMaxTime(0.1f);
		this.setQuantity(64);
	}
}
