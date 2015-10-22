package com.derf.ei.crafting;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class EICraftingBlockSlot {
	private final static float INTERVAL = 20.0f / 1000.0f;
	
	private int x;
	private int y;
	private int z;
	private float duration;
	private boolean isProcessing = false;
	
	public EICraftingBlockSlot(int x, int y, int z) {
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
	
	public void update(World world, ArrayList<EICraftingBlockRecipe> recipes) {
		Block block = world.getBlock(this.getX(), this.getY(), this.getZ());
		
		for(int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).isInputBlock(block)) {
				if(!isProcessing) {
					isProcessing = true;
					this.setDuration(recipes.get(i).getDuration());
				}
				
				if(this.getDuration() <= 0.0f) {
					world.setBlock(this.getX(), this.getY(), this.getZ(), recipes.get(i).getOuputBlock());
					this.isProcessing = false;
				} else {
					this.setDuration(this.getDuration() - INTERVAL);
				}
			}
		}
	}
}
