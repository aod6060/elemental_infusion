package com.derf.ei.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemEarthRod extends Item {
	
	private static final int DIRT = 0;
	private static final int COBBLE = 1;
	private static final int UNROSION = 2;
	
	public EIItemEarthRod(String name) {
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
				tag.setInteger("mode", DIRT);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				
				switch(stack.getTagCompound().getInteger("mode")) {
				case DIRT:
					stack.getTagCompound().setInteger("mode", COBBLE);
					player.addChatMessage(new ChatComponentText("Mode: COBBLE"));
					break;
				case COBBLE:
					stack.getTagCompound().setInteger("mode", UNROSION);
					player.addChatMessage(new ChatComponentText("Mode: UNROSION"));
					break;
				case UNROSION:
					stack.getTagCompound().setInteger("mode", DIRT);
					player.addChatMessage(new ChatComponentText("Mode: DIRT"));
					break;
				}
			} else {
				
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
				tag.setInteger("mode", DIRT);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				b = true;
			} else {
				switch(stack.getTagCompound().getInteger("mode")) {
				case DIRT:
					placeDirt(world, player, pos, facing);
					break;
				case COBBLE:
					placeCobble(world, player, pos, facing);
					break;
				case UNROSION:
					unrosion(world, player, pos);
					break;
				}
			}
		}
		return b;
	}

	private void placeDirt(World world, EntityPlayer player, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
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

	private void placeCobble(World world, EntityPlayer player, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		if(facing.getName().compareTo("up") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.cobblestone.getDefaultState());
		} else if(facing.getName().compareTo("down") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.cobblestone.getDefaultState());
		} else if(facing.getName().compareTo("west") == 0) {
			world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.cobblestone.getDefaultState());
		} else if(facing.getName().compareTo("east") == 0) {
			world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.cobblestone.getDefaultState());
		} else if(facing.getName().compareTo("north") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.cobblestone.getDefaultState());
		} else if(facing.getName().compareTo("south") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.cobblestone.getDefaultState());
		}
	}

	private void unrosion(World world, EntityPlayer player, BlockPos pos) {
		// TODO Auto-generated method stub
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
	
	
	
}
