package com.derf.ei.multiblock.totem;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingMultiBlock;

public class EIMultiBlockTotemWater extends EIMultiBlockTotem {
	public EIMultiBlockTotemWater() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setTotemHead(EIBlocks.waterBlock);
		this.setRecipesList(EICraftingMultiBlock.getWaterTotemRecipes());
	}
}
