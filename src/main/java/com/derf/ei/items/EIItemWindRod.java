package com.derf.ei.items;

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

public class EIItemWindRod extends Item {
	
	
	public static final double strength = 5.0;
	public static final double range = 16.0;
	
	public static final int BLAST = 0;
	public static final int TRAVEL = 1;
	public static final int EROSION = 2;
	
	public EIItemWindRod(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		if(!world.isRemote) {
			if(stack.getTagCompound() == null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("mode", BLAST);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				switch(stack.getTagCompound().getInteger("mode")) {
				case BLAST:
					stack.getTagCompound().setInteger("mode", TRAVEL);
					player.addChatMessage(new ChatComponentText("Mode: TRAVEL"));
					break;
				case TRAVEL:
					stack.getTagCompound().setInteger("mode", EROSION);
					player.addChatMessage(new ChatComponentText("Mode: EROSION"));
					break;
				case EROSION:
					stack.getTagCompound().setInteger("mode", BLAST);
					player.addChatMessage(new ChatComponentText("Mode: BLAST"));
					break;
				}
			} else {
				switch(stack.getTagCompound().getInteger("mode")) {
				case BLAST:
					blast(world, player);
					break;
				case TRAVEL:
					travel(player);
					break;
				}
			}
		} 
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		
		boolean b = false;
		
		if(!world.isRemote) {
			if(stack.getTagCompound() == null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("mode", BLAST);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				b = true;
			} else {
				switch(stack.getTagCompound().getInteger("mode")) {
				case BLAST:
				case TRAVEL:
					b = true;
					break;
				case EROSION:
					erosion(world, player, pos);
					break;
				}
			}
		}
		return b;
	}


	private void blast(World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		AxisAlignedBB box = this.getRangedBox(player);
		ArrayList<Entity> list = this.getEntitiesWithAABB(world, EntityCreature.class, box);
		
		EIVec3 pp = new EIVec3(
				player.posX,
				player.posY,
				player.posZ);
		
		
		for(int i = 0; i < list.size(); i++) {
			Entity ei = list.get(i);
			EIVec3 v = new EIVec3(ei.posX, ei.posY, ei.posZ);
			EIVec3 s = EIVec3.sub(v, pp);
			s = EIVec3.unit(s);
			s = EIVec3.mul(s, this.strength);
			ei.motionX += s.getX();
			ei.motionY += 2;
			ei.motionZ += s.getZ();
		}
	}

	private void travel(EntityPlayer player) {
		// TODO Auto-generated method stub
		Vec3 v = player.getLookVec();
		EIVec3 direction = new EIVec3(v);
		
		direction = EIVec3.mul(direction, 2.0);
		
		player.motionX = direction.getX();
		player.motionY = direction.getY();
		player.motionZ = direction.getZ();
		// Thanks Mr. WayOfTime
		player.velocityChanged = true;
		player.fallDistance = 0;
	}
	
	private void erosion(World world, EntityPlayer player, BlockPos pos) {
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
	
	private AxisAlignedBB getRangedBox(Entity player) {
		AxisAlignedBB box = new AxisAlignedBB(
				player.posX - range,
				player.posY - range,
				player.posZ - range,
				player.posX + range,
				player.posY + range,
				player.posZ + range
				);
		return box;
	}
	
	private ArrayList<Entity> getEntitiesWithAABB(World world, Class cls, AxisAlignedBB box) {
		ArrayList<Entity> temp;
		
		temp = (ArrayList<Entity>) world.getEntitiesWithinAABB(cls, box);
		
		return temp;
	}
}
