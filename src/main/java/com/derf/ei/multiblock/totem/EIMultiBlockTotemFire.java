package com.derf.ei.multiblock.totem;

import java.util.ArrayList;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingMultiBlock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EIMultiBlockTotemFire extends EIMultiBlockTotem {
	
	public EIMultiBlockTotemFire() {
		this.setBasicBlock(EIBlocks.voidStone);
		this.setTotemHead(EIBlocks.fireBlock);
		this.setRecipesList(EICraftingMultiBlock.getFireTotemRecipes());
	}
	
}
