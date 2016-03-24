package com.derf.ei.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EIBlockLight extends Block {
	public EIBlockLight(Material material, String name) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}
	
	@Override
	public int quantityDropped(IBlockState p_quantityDropped_1_,
			int p_quantityDropped_2_, Random p_quantityDropped_3_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public int getLightValue(IBlockState state) {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
