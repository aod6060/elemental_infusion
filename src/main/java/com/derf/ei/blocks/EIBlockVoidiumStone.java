package com.derf.ei.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class EIBlockVoidiumStone extends Block {

	public EIBlockVoidiumStone(String name, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setHardness(1.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	public int damageDropped(IBlockState p_damageDropped_1_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item getItemDropped(IBlockState p_getItemDropped_1_,
			Random p_getItemDropped_2_, int p_getItemDropped_3_) {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(EIBlocks.voidiumStone);
	}

	@Override
	public int quantityDropped(IBlockState p_quantityDropped_1_,
			int p_quantityDropped_2_, Random p_quantityDropped_3_) {
		// TODO Auto-generated method stub
		return 1;
	}

	
}
