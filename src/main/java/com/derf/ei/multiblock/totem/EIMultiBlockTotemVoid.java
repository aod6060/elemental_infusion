package com.derf.ei.multiblock.totem;

import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingMultiBlock;

public class EIMultiBlockTotemVoid extends EIMultiBlockTotem {
	public EIMultiBlockTotemVoid() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setTotemHead(EIBlocks.voidBlock);
		this.setRecipesList(EICraftingMultiBlock.getVoidTotemRecipe());
	}
}
