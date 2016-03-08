package com.derf.ei.items.rods;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.derf.ei.util.EIVec3;

public class EIItemRodWind extends EIItemRod {
	
	/*
	public static final double strength = 2.0;
	public static final double range = 16.0;
	
	public static final int BLAST = 0;
	public static final int TRAVEL = 1;
	public static final int EROSION = 2;
	*/
	
	public EIItemRodWind(String name) {
		super(name);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		
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
		
		return true;
	}
}
