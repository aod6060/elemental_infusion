package com.derf.ei.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class EIBlockOre extends Block {

	private Item drop;
	private int meta;
	private int min;
	private int max;
	
	public EIBlockOre(String name, Material material, Item drop, int meta, int min, int max, int harvestLevel, float hardness, float res) {
		super(material);
		// TODO Auto-generated constructor stub
		this.drop = drop;
		this.meta = meta;
		this.min = min;
		this.max = max;
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setHardness(hardness);
		this.setResistance(res);
		this.setUnlocalizedName(name);
	}

	@Override
	public int damageDropped(IBlockState p_damageDropped_1_) {
		// TODO Auto-generated method stub
		return this.meta;
	}

	@Override
	public Item getItemDropped(IBlockState p_getItemDropped_1_,
			Random p_getItemDropped_2_, int p_getItemDropped_3_) {
		// TODO Auto-generated method stub
		return this.drop;
	}

	@Override
	public int quantityDropped(IBlockState bs,
			int fortune, Random random) {
		// TODO Auto-generated method stub
		
		if(this.min >= this.max) {
			return this.min;
		} else {
			return this.min + random.nextInt(this.max - this.min + fortune + 1);
		}
	}
	
	
}
