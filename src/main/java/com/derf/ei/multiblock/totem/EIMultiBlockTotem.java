package com.derf.ei.multiblock.totem;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingBlockRecipe;
import com.derf.ei.crafting.EICraftingBlockSlot;
import com.derf.ei.multiblock.EIMultiBlock;

public abstract class EIMultiBlockTotem extends EIMultiBlock {
	
	protected EICraftingBlockSlot[] blockSlots = new EICraftingBlockSlot[8];
	
	protected ArrayList<Block> createBlockList(World world, int x, int y, int z) {
		ArrayList<Block> list = new ArrayList<Block>();
		
		list.add(world.getBlock(x-1, y, z));
		list.add(world.getBlock(x+1, y, z));
		list.add(world.getBlock(x, y, z-1));
		list.add(world.getBlock(x, y, z+1));
		list.add(world.getBlock(x-1, y, z-1));
		list.add(world.getBlock(x+1, y, z-1));
		list.add(world.getBlock(x+1, y, z+1));
		list.add(world.getBlock(x-1, y, z+1));
		list.add(world.getBlock(x, y+1, z));
		list.add(world.getBlock(x, y+2, z));
		
		return list;
	}
	
	protected boolean isMultiBlockComplete(World world, int x, int y, int z, Block block) {
		ArrayList<Block> blockList = this.createBlockList(world, x, y, z);
		boolean b = true;
		
		for(int i = 0; i < blockList.size() - 1; i++) {
			if(!EIBlocks.isVoidStone(blockList.get(i))) {
				b = false;
				break;
			}
		}
		
		if(!blockList.get(blockList.size() - 1).getUnlocalizedName().equals(block.getUnlocalizedName())) {
			b = false;
		}
		
		return b;
	}
	
	protected void checkSlotExist(World world, int x, int y, int z) {
		
		if(blockSlots[0] == null) {
			blockSlots[0] = new EICraftingBlockSlot(x-1, y+1, z);
		}
		
		if(blockSlots[1] == null) {
			blockSlots[1] = new EICraftingBlockSlot(x+1, y+1, z);
		}
		
		if(blockSlots[2] == null) {
			blockSlots[2] = new EICraftingBlockSlot(x, y+1, z-1);
		}
		
		if(blockSlots[3] == null) {
			blockSlots[3] = new EICraftingBlockSlot(x, y+1, z+1);
		}
		
		if(blockSlots[4] == null) {
			blockSlots[4] = new EICraftingBlockSlot(x-1, y+1, z-1);
		}
		
		if(blockSlots[5] == null) {
			blockSlots[5] = new EICraftingBlockSlot(x+1, y+1, z-1);
		}
		
		if(blockSlots[6] == null) {
			blockSlots[6] = new EICraftingBlockSlot(x+1, y+1, z+1);
		}
		
		if(blockSlots[7] == null) {
			blockSlots[7] = new EICraftingBlockSlot(x-1, y+1, z+1);
		}
	}
	
	protected void updateSlots(World world, ArrayList<EICraftingBlockRecipe> recipes) {
		for(int i = 0; i < blockSlots.length; i++) {
			blockSlots[i].update(world, recipes);
		}
		
	}
}
