package com.derf.ei.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.derf.ei.blocks.EIIMetaBlockName;

public class EIItemBlock extends ItemBlock {

	public EIItemBlock(Block block) {
		super(block);
		// TODO Auto-generated constructor stub
		
		if(!(block instanceof EIIMetaBlockName)) {
			throw new IllegalArgumentException("The block isn't using EIIMetaBlockName interface.");
		}
		
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		// TODO Auto-generated method stub
		return super.getUnlocalizedName(stack) + "." + ((EIIMetaBlockName)this.block).getSpecialName(stack);
	}
	
	
}
