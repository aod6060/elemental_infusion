package com.derf.ei.crafting;

import net.minecraft.block.Block;

public class EICraftingBlockRecipe {
	private Block inputBlock;
	private Block outputBlock;
	private float duration;
	
	public EICraftingBlockRecipe(Block inputBlock, Block outputBlock, float duration) {
		this.inputBlock = inputBlock;
		this.outputBlock = outputBlock;
		this.duration = duration;
	}
	
	public Block getInputBlock() {
		return inputBlock;
	}
	
	public Block getOuputBlock() {
		return outputBlock;
	}
	
	public float getDuration() {
		return duration;
	}
	
	public boolean isInputBlock(Block block) {
		return inputBlock.getUnlocalizedName().equals(block.getUnlocalizedName());
	}
}
