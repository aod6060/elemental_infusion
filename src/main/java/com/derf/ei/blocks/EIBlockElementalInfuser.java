package com.derf.ei.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.derf.ei.blocks.tileentity.EITileEntityElementalInfuser;

public class EIBlockElementalInfuser extends BlockContainer {

	protected EIBlockElementalInfuser(String name, Material material) {
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
		return new EITileEntityElementalInfuser();
	}

	@Override
	public int getRenderType() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		if(!world.isRemote && player.inventory.getStackInSlot(player.inventory.currentItem) == null) {
			
			System.out.println("player inventory: "+player.inventory.currentItem);
			EITileEntityElementalInfuser core = (EITileEntityElementalInfuser)world.getTileEntity(pos);
			core.currentMode(player);
		}
		
		return super.onBlockActivated(world, pos,
				state, player, facing,
				fx, fy, fz);
	}
}
