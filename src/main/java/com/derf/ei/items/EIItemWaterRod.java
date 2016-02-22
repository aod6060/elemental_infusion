package com.derf.ei.items;

import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemWaterRod extends Item {
	
	private static final int WATER = 0;
	private static final int SNOW = 1;
	private static final int SNOW_GOLUM = 2;
	
	public EIItemWaterRod(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}

	
	@Override
	public ItemStack onItemRightClick(ItemStack stack,
			World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		
		if(!world.isRemote) {
			if(stack.getTagCompound() == null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("mode", WATER);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				if(stack.getTagCompound().getInteger("mode") == WATER) {
					player.addChatMessage(new ChatComponentText("Mode: SNOW"));
					stack.getTagCompound().setInteger("mode", SNOW);
				} else if(stack.getTagCompound().getInteger("mode") == SNOW) {
					stack.getTagCompound().setInteger("mode", SNOW_GOLUM);
					player.addChatMessage(new ChatComponentText("Mode: SNOW GOLUM"));
				} else if(stack.getTagCompound().getInteger("mode") == SNOW_GOLUM) {
					stack.getTagCompound().setInteger("mode", WATER);
					player.addChatMessage(new ChatComponentText("Mode: WATER"));
				}
				
			} else {
				
			}
		
		}
		
		return super.onItemRightClick(stack, world,
				player);
	}


	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if(!world.isRemote) {
			if(stack.getTagCompound() == null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("mode", WATER);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
			} else {
				switch(stack.getTagCompound().getInteger("mode")) {
				case WATER:
					setWater(world, player, pos, facing);
					break;
				case SNOW:
					setSnow(world, player, pos, facing);
					break;
				case SNOW_GOLUM:
					spawnSnowGolum(world, player, pos, facing);
					break;
				}
			}
		}
		
		return true;
	}





	private void setWater(World world, EntityPlayer player, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		// Thanks WayOfTime https://github.com/WayofTime/BloodMagic/blob/1.8/src/main/java/WayofTime/bloodmagic/item/sigil/ItemSigilLava.java
		
		if(player.dimension != -1) {
			if(facing.getName().compareTo("up") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.flowing_water.getDefaultState());
			} else if(facing.getName().compareTo("down") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.flowing_water.getDefaultState());
			} else if(facing.getName().compareTo("west") == 0) {
				world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.flowing_water.getDefaultState());
			} else if(facing.getName().compareTo("east") == 0) {
				world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.flowing_water.getDefaultState());
			} else if(facing.getName().compareTo("north") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.flowing_water.getDefaultState());
			} else if(facing.getName().compareTo("south") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.flowing_water.getDefaultState());
			}
		}
	}
	
	private void setSnow(World world, EntityPlayer player, BlockPos pos,
			EnumFacing facing) {
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
	
	private void spawnSnowGolum(World world, EntityPlayer player, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		if(facing.getName().compareTo("up") == 0) {
			//world.spawnEntityInWorld(new EntitySnowman(world));
			EntitySnowman entity = new EntitySnowman(world);
			
			entity.setPosition(pos.getX(), pos.getY()+1, pos.getZ());
			
			world.spawnEntityInWorld(entity);
		}
	}
}
