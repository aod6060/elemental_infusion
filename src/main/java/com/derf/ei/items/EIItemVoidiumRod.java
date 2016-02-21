package com.derf.ei.items;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemVoidiumRod extends Item {
	
	public static final int VOID_1x1 = 0;
	public static final int VOID_3x3 = 1;
	public static final int VOID_5x5 = 2;
	public static final int VOID_7x7 = 3;
	public static final int VOID_9x9 = 4;
	//public static final int PLACE_VOID_BLOCK = 4;
	
	public EIItemVoidiumRod(String name) {
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
				tag.setInteger("mode", VOID_1x1);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				switch(stack.getTagCompound().getInteger("mode")) {
				case VOID_1x1:
					stack.getTagCompound().setInteger("mode", VOID_3x3);
					player.addChatMessage(new ChatComponentText("Mode: Void 3x3 area"));
					break;
				case VOID_3x3:
					stack.getTagCompound().setInteger("mode", VOID_5x5);
					player.addChatMessage(new ChatComponentText("Mode: Void 5x5 area"));
					break;
				case VOID_5x5:
					stack.getTagCompound().setInteger("mode", VOID_7x7);
					player.addChatMessage(new ChatComponentText("Mode: Void 7x7 area"));
					break;
				case VOID_7x7:
					stack.getTagCompound().setInteger("mode", VOID_9x9);
					player.addChatMessage(new ChatComponentText("Mode: Void 9x9 area"));
					break;
				case VOID_9x9:
					stack.getTagCompound().setInteger("mode", VOID_1x1);
					player.addChatMessage(new ChatComponentText("Mode: Void 1x1 area"));
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
				tag.setInteger("mode", VOID_1x1);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
				b = true;
			} else {
				switch(stack.getTagCompound().getInteger("mode")) {
				case VOID_1x1:
					void_1x1(world, pos, player, facing);
					break;
				case VOID_3x3:
					void_3x3(world, pos, player, facing);
					break;
				case VOID_5x5:
					void_5x5(world, pos, player, facing);
					break;
				case VOID_7x7:
					void_7x7(world, pos, player, facing);
					break;
				case VOID_9x9:
					void_9x9(world, pos, player, facing);
					break;
				}
				
				b = true;
			}
		}
		

		return b;
	}

	private void void_1x1(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		if(!this.isUnbreable(world, pos)) {	
			world.destroyBlock(pos, false);
		}
	}

	private void void_3x3(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> bpos = getBlock3x3(world, pos, facing);
		
		for(int i = 0; i < bpos.size(); i++) {
			if(!this.isUnbreable(world, pos)) {	
				world.destroyBlock(bpos.get(i), false);
			}
		}
	}

	private ArrayList<BlockPos> getBlock3x3(World world, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> temp = new ArrayList<BlockPos>();
		
		if(facing.getName().contains("up") || facing.getName().contains("down")) {
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1));
		} else if(facing.getName().contains("west")) {
			
		} else if(facing.getName().contains("east")) {
			
		} else if(facing.getName().contains("north")) {
			
		} else if(facing.getName().contains("south")) {
			
		}
		return temp;
	}

	private void void_5x5(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		
	}

	private void void_7x7(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		
	}

	private void void_9x9(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isUnbreable(World world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.bedrock || world.getBlockState(pos).getBlock() == Blocks.end_portal_frame;
	}
}
