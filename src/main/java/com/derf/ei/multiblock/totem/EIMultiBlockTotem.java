package com.derf.ei.multiblock.totem;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.crafting.EICraftingBlockRecipe;
import com.derf.ei.crafting.EICraftingBlockSlot;
import com.derf.ei.crafting.EICraftingMultiBlock;
import com.derf.ei.multiblock.EIMultiBlock;

public abstract class EIMultiBlockTotem extends EIMultiBlock {
	
	protected EICraftingBlockSlot[] blockSlots = new EICraftingBlockSlot[8];
	
	private Block basicBlock = null;
	private Block totemHead = null;
	private ArrayList<EICraftingBlockRecipe> recipes = null;
	
	@Override
	public void update(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		super.update(world, x, y, z);
		
		if(this.isMultiBlockComplete(world, x, y, z)) {
			//System.out.println("Multi Block Complete");
			this.checkSlotExist(world, x, y, z);
			this.updateSlots(world, this.recipes);
		}
	}
	
	private ArrayList<Block> createBlockList(World world, int x, int y, int z) {
		ArrayList<Block> list = new ArrayList<Block>();
		
		list.add(world.getBlock(x, y+2, z)); // Totem Head
		list.add(world.getBlock(x-1, y, z));
		list.add(world.getBlock(x+1, y, z));
		list.add(world.getBlock(x, y, z-1));
		list.add(world.getBlock(x, y, z+1));
		list.add(world.getBlock(x-1, y, z-1));
		list.add(world.getBlock(x+1, y, z-1));
		list.add(world.getBlock(x+1, y, z+1));
		list.add(world.getBlock(x-1, y, z+1));
		list.add(world.getBlock(x, y+1, z));
		
		
		return list;
	}
	
	private boolean isMultiBlockComplete(World world, int x, int y, int z) {
		ArrayList<Block> blockList = this.createBlockList(world, x, y, z);
		boolean b = true;
				
		if(!EIBlocks.isBlock(this.totemHead, blockList.get(0))) {
			b = false;
		}
		
		for(int i = 1; i < blockList.size() - 1; i++) {
			if(!EIBlocks.isBlock(this.basicBlock, blockList.get(i))) {
				b = false;
				break;
			}
		}
		
		return b;
	}
	
	private void checkSlotExist(World world, int x, int y, int z) {
		
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
	
	private void updateSlots(World world, ArrayList<EICraftingBlockRecipe> recipes) {
		for(int i = 0; i < blockSlots.length; i++) {
			blockSlots[i].update(world, recipes);
		}
		
	}

	protected void setBasicBlock(Block block) {
		this.basicBlock = block;
	}
	
	protected void setTotemHead(Block block) {
		this.totemHead = block;
	}

	protected void setRecipesList(ArrayList<EICraftingBlockRecipe> recipes) {
		this.recipes = recipes;
	}
}
