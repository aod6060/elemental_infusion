package com.derf.ei.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.derf.ei.blocks.tileentity.EITileEntityCore;

public class EIBlockCore extends BlockContainer {

	protected EIBlockCore(String name) {
		super(Material.rock);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setHardness(2.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	/*
	@Override
	public int getRenderType() {
		// TODO Auto-generated method stub
		return 3;
	}
	*/
	
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		// TODO Auto-generated method stub
		return new EITileEntityCore();
	}
	
	
}
