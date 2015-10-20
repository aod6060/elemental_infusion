package com.derf.ei.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EIBlockItemDrop extends EIBlock {

	private Block drop;
	
	public EIBlockItemDrop(String name, Material material, float hardness, float res, String tool, int level, SoundType sound, Block drop) {
		super(name, material, hardness, res, tool, level, sound);
		// TODO Auto-generated constructor stub
		this.drop = drop;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) {
		// TODO Auto-generated method stub
		
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(drop));
		return drops;
	}
	
	
}
