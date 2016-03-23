package com.derf.ei.items.rods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EIItemRodDirt extends EIItemRod {

	public EIItemRodDirt(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			// TODO Auto-generated method stub
			// Place Dirt :)
			if(facing.getName().compareTo("up") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.dirt.getDefaultState());
			} else if(facing.getName().compareTo("down") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.dirt.getDefaultState());
			} else if(facing.getName().compareTo("west") == 0) {
				world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.dirt.getDefaultState());
			} else if(facing.getName().compareTo("east") == 0) {
				world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.dirt.getDefaultState());
			} else if(facing.getName().compareTo("north") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.dirt.getDefaultState());
			} else if(facing.getName().compareTo("south") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.dirt.getDefaultState());
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
}
