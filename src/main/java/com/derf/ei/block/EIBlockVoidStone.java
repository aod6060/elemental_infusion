package com.derf.ei.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class EIBlockVoidStone extends EIBlock {

	public EIBlockVoidStone(String name) {
		super(name, Material.rock, 1.0f, 1.0f, "pickaxe", 1, Block.soundTypeStone);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(EIBlocks.voidStone);
	}

	@Override
	public int damageDropped(int p_149692_1_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		// TODO Auto-generated method stub
		return 1;
	}
}
