package com.derf.ei.multiblock.totem;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingMultiBlock;

public class EIMultiBlockTotemEarth extends EIMultiBlockTotem {
	
	public EIMultiBlockTotemEarth() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setTotemHead(EIBlocks.earthBlock);
		this.setRecipesList(EICraftingMultiBlock.getEarthTotemRecipes());
	}
	
}
