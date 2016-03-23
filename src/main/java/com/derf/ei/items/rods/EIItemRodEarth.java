package com.derf.ei.items.rods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EIItemRodEarth extends EIItemRod {
	
	public EIItemRodEarth(String name) {
		super(name);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		
		if(!world.isRemote) {
			// TODO Auto-generated method stub
			// Earth Rod does unrosion
			if(world.getBlockState(pos).getBlock() == Blocks.stone) {
				world.setBlockState(pos, Blocks.stonebrick.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.cobblestone) {
				world.setBlockState(pos, Blocks.stone.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.gravel) {
				world.setBlockState(pos, Blocks.cobblestone.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.sand) {
				world.setBlockState(pos, Blocks.gravel.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.dirt) {
				world.setBlockState(pos, Blocks.grass.getDefaultState());
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
	
}
