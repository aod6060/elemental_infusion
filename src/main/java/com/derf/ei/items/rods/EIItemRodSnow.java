package com.derf.ei.items.rods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemRodSnow extends EIItemRod {

	public EIItemRodSnow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			if(facing.getName().compareTo("up") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.snow.getDefaultState());
				//world.forceBlockUpdateTick(p_forceBlockUpdateTick_1_, p_forceBlockUpdateTick_2_, p_forceBlockUpdateTick_3_);
			} else if(facing.getName().compareTo("down") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.snow.getDefaultState());
			} else if(facing.getName().compareTo("west") == 0) {
				world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.snow.getDefaultState());
			} else if(facing.getName().compareTo("east") == 0) {
				world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.snow.getDefaultState());
			} else if(facing.getName().compareTo("north") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.snow.getDefaultState());
			} else if(facing.getName().compareTo("south") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.snow.getDefaultState());
			}
		}
		
		return true;
	}
}
