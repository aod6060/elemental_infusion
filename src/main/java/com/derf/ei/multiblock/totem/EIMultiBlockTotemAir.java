package com.derf.ei.multiblock.totem;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingMultiBlock;

public class EIMultiBlockTotemAir extends EIMultiBlockTotem {
	public EIMultiBlockTotemAir() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setTotemHead(EIBlocks.airBlock);
		this.setRecipesList(EICraftingMultiBlock.getAirTotemRecipes());
	}
}
