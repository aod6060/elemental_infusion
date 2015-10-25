package com.derf.ei.multiblock.totem;

import java.util.ArrayList;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingMultiBlock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EIMultiBlockTotemFire extends EIMultiBlockTotem {
	
	@Override
	public void update(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		super.update(world, x, y, z);
		
		if(this.isMultiBlockComplete(world, x, y, z, EIBlocks.fireBlock)) {
			//System.out.println("Multi Block Complete");
			this.checkSlotExist(world, x, y, z);
			this.updateSlots(world, EICraftingMultiBlock.getFireTotemRecipes());
		}
	}
}
