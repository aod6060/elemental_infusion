package com.derf.ei.multiblock;

import java.util.ArrayList;

import com.derf.ei.block.EIBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class EIMultiBlockFireTotem extends EIMultiBlock {
	
	class BlockRecipe {
		private final static float INTERVAL = 20.0f / 1000.0f;
		
		private int x;
		private int y;
		private int z;
		private float duration;
		private boolean isProcessing = false;
		
		public BlockRecipe(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.setDuration(-1);
		}
		
		public float getDuration() {
			return duration;
		}
		
		public void setDuration(float duration) {
			this.duration = duration;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getZ() {
			return z;
		}
		
		public void update(World world) {
			Block block = world.getBlock(this.getX(), this.getY(), this.getZ());
			
			
			if(this.isIronBlock(block)) {
				if(!isProcessing) {
					isProcessing = true;
					this.setDuration(3.0f);
				}
				
				if(this.getDuration() <= 0.0f) {
					world.setBlock(this.getX(), this.getY(), this.getZ(), EIBlocks.fireIronBlock);
					isProcessing = false;
				} else {
					this.setDuration(this.getDuration() - INTERVAL);
				}
			} else if(this.isDiamondBlock(block)) {
				if(!isProcessing) {
					isProcessing = true;
					this.setDuration(6.0f);
				}
				
				if(this.getDuration() <= 0.0f) {
					world.setBlock(this.getX(), this.getY(), this.getZ(), EIBlocks.fireDiamondBlock);
					isProcessing = false;
				} else {
					this.setDuration(this.getDuration() - INTERVAL);
				}
			}
			
		}
		
		boolean isIronBlock(Block block) {
			return block.getUnlocalizedName().equals("tile.blockIron");
		}
		
		boolean isDiamondBlock(Block block) {
			return block.getUnlocalizedName().equals("tile.blockDiamond");
		}
	}
	
	private BlockRecipe[] inventory = new BlockRecipe[8];
	
	
	@Override
	public void update(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		super.update(world, x, y, z);
		
		if(this.isMultiBlockComplete(world, x, y, z)) {
			//System.out.println("Multi Block Complete");
			this.checkIfRecipeAreaIsCreated(world, x, y, z);
			
			for(int i = 0; i < inventory.length; i++) {
				inventory[i].update(world);
			}
		}
	}
	
	private ArrayList<Block> createBlockList(World world, int x, int y, int z) {
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
	
	private boolean isMultiBlockComplete(World world, int x, int y, int z) {
		ArrayList<Block> blockList = this.createBlockList(world, x, y, z);
		boolean b = true;
		
		for(int i = 0; i < blockList.size() - 1; i++) {
			if(!blockList.get(i).getUnlocalizedName().equals("tile.void_stone")) {
				b = false;
				break;
			}
		}
		
		if(!blockList.get(blockList.size() - 1).getUnlocalizedName().equals("tile.fire_block")) {
			b = false;
		}
		
		return b;
	}
	
	private void checkIfRecipeAreaIsCreated(World world, int x, int y, int z) {
		
		if(inventory[0] == null) {
			inventory[0] = new BlockRecipe(x-1, y+1, z);
		}
		
		if(inventory[1] == null) {
			inventory[1] = new BlockRecipe(x+1, y+1, z);
		}
		
		if(inventory[2] == null) {
			inventory[2] = new BlockRecipe(x, y+1, z-1);
		}
		
		if(inventory[3] == null) {
			inventory[3] = new BlockRecipe(x, y+1, z+1);
		}
		
		if(inventory[4] == null) {
			inventory[4] = new BlockRecipe(x-1, y+1, z-1);
		}
		
		if(inventory[5] == null) {
			inventory[5] = new BlockRecipe(x+1, y+1, z-1);
		}
		
		if(inventory[6] == null) {
			inventory[6] = new BlockRecipe(x+1, y+1, z+1);
		}
		
		if(inventory[7] == null) {
			inventory[7] = new BlockRecipe(x-1, y+1, z+1);
		}
	}
}
