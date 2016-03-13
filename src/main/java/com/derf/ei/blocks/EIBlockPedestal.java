package com.derf.ei.blocks;

import com.derf.ei.blocks.tileentity.EITileEntityPedestal;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EIBlockPedestal extends BlockContainer {

	public EIBlockPedestal(String name) {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setHardness(1.0f);
		this.setResistance(1.0f);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		// TODO Auto-generated method stub
		return new EITileEntityPedestal();
	}
	
	
}
