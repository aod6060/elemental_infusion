package com.derf.ei.items.rods;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
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

import com.derf.ei.util.EIVec3d;

public class EIItemRodWind extends EIItemRod {
	
	public EIItemRodWind(String name) {
		super(name);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		
		if(!world.isRemote) {
			// This will do errosion
			// TODO Auto-generated method stub
			// stone_brick > stone > cobblestone > gravel > sand > nothing
			// grass > dirt > nothing
			if(world.getBlockState(pos).getBlock() == Blocks.stonebrick) {
				world.setBlockState(pos, Blocks.stone.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.stone) {
				world.setBlockState(pos, Blocks.cobblestone.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.cobblestone) {
				world.setBlockState(pos, Blocks.gravel.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.gravel) {
				world.setBlockState(pos, Blocks.sand.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.sand) {
				world.setBlockToAir(pos);
			} else if(world.getBlockState(pos).getBlock() == Blocks.grass) {
				world.setBlockState(pos, Blocks.dirt.getDefaultState());
			} else if(world.getBlockState(pos).getBlock() == Blocks.dirt) {
				world.setBlockToAir(pos);
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
	
}
