package com.derf.ei.block;

import com.derf.ei.tileentity.EITileEntityMachineCore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EIBlockMachineCore extends EIBlockContainer {

	public EIBlockMachineCore() {
		super("machine_core", Material.rock, 1.0f, 1.0f, "pickaxe", 1, Block.soundTypeStone);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new EITileEntityMachineCore();
	}
}
