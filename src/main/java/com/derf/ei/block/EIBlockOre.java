package com.derf.ei.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.derf.ei.Main;

public class EIBlockOre extends EIBlock {

	private Item drop;
	private int meta;
	private int min_quantity;
	private int max_quantity;
	
	public EIBlockOre(String name, Material material, float hardness, float res, String tool, int level, Item drop, int meta, int min_quantity, int max_quantity) {
		super(name, material, hardness, res, tool, level, soundTypeStone);
		// TODO Auto-generated constructor stub
		this.drop = drop;
		this.meta = meta;
		this.min_quantity = min_quantity;
		this.max_quantity = max_quantity;
	}
	
	public EIBlockOre(String name, Material material, float hardness, float res, String tool, int level, Item drop, int min_quantity, int max_quantity) {
		this(name, 
			 material,
			 hardness,
			 res,
			 tool,
			 level,
			 drop,
			 0,
			 min_quantity,
			 max_quantity);
	}
	
	public EIBlockOre(String name, Material material, float hardness, float res, String tool, int level, Item drop) {
		this(name, 
				 material,
				 hardness,
				 res,
				 tool,
				 level,
				 drop,
				 1,
				 1);	
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		// TODO Auto-generated method stub
		return this.drop;
	}

	@Override
	public int damageDropped(int p_149692_1_) {
		// TODO Auto-generated method stub
		return this.meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		// TODO Auto-generated method stub
		return this.min_quantity + random.nextInt(this.max_quantity - this.min_quantity + fortune + 1);
	}
	
	
}
