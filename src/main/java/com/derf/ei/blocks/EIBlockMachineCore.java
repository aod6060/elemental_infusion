package com.derf.ei.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.derf.ei.blocks.tileentity.EITileEntityMachineCore;

public class EIBlockMachineCore extends BlockContainer {

	protected EIBlockMachineCore(String name, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setHardness(1.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		// TODO Auto-generated method stub
		return new EITileEntityMachineCore();
	}

	@Override
	public int getRenderType() {
		// TODO Auto-generated method stub
		return 3;
	}

	
	
}
