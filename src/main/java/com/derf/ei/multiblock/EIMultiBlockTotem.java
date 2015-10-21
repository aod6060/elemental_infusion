package com.derf.ei.multiblock;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;

public final class EIMultiBlockTotem extends EIMultiBlock {
	
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
	
	
	
}