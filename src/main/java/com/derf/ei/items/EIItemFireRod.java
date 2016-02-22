package com.derf.ei.items;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemFireRod extends Item {
	
	private static final int FIRE = 0;
	private static final int LAVA = 1;
	private static final int SMELT = 2;
	
	public EIItemFireRod(String name) {
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
				tag.setInteger("mode", FIRE);
				stack.setTagCompound(tag);
			}
			
			
			if(player.isSneaking()) {
				if(stack.getTagCompound().getInteger("mode") == FIRE) {
					player.addChatMessage(new ChatComponentText("Mode: LAVA"));
					stack.getTagCompound().setInteger("mode", LAVA);
				} else if(stack.getTagCompound().getInteger("mode") == LAVA) {
					stack.getTagCompound().setInteger("mode", SMELT);
					player.addChatMessage(new ChatComponentText("Mode: SMELT"));
				} else if(stack.getTagCompound().getInteger("mode") == SMELT) {
					stack.getTagCompound().setInteger("mode", FIRE);
					player.addChatMessage(new ChatComponentText("Mode: FIRE"));
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
				tag.setInteger("mode", FIRE);
				stack.setTagCompound(tag);
			}
			
			if(player.isSneaking()) {
			} else {
				switch(stack.getTagCompound().getInteger("mode")) {
				case FIRE:
					setFire(world, player, pos, facing);
					break;
				case LAVA:
					setLava(world, player, pos, facing);
					break;
				case SMELT:
					doSmelt(world, player, pos);
					break;
				}
			}
		}
		
		return true;
	}

	private void setFire(World world, EntityPlayer player, BlockPos pos, EnumFacing facing) {
		// TODO Auto-generated method stub
		//player.addChatMessage(new ChatComponentText("Facing: " + facing.getName() + ": index: " + facing.getIndex()));
		
		if(facing.getName().compareTo("up") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.fire.getDefaultState());
		}
	}
	
	private void setLava(World world, EntityPlayer player, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		// Thanks WayOfTime https://github.com/WayofTime/BloodMagic/blob/1.8/src/main/java/WayofTime/bloodmagic/item/sigil/ItemSigilLava.java
		if(facing.getName().compareTo("up") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.flowing_lava.getDefaultState());
		} else if(facing.getName().compareTo("down") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.flowing_lava.getDefaultState());
		} else if(facing.getName().compareTo("west") == 0) {
			world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.flowing_lava.getDefaultState());
		} else if(facing.getName().compareTo("east") == 0) {
			world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.flowing_lava.getDefaultState());
		} else if(facing.getName().compareTo("north") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.flowing_lava.getDefaultState());
		} else if(facing.getName().compareTo("south") == 0) {
			world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.flowing_lava.getDefaultState());
		} 
	}
	
	private void doSmelt(World world, EntityPlayer player, BlockPos pos) {
		
		if(world.getBlockState(pos).getBlock() == Blocks.cobblestone) {
			world.setBlockState(pos, Blocks.stone.getDefaultState());
		} else if(world.getBlockState(pos).getBlock() == Blocks.sand) {
			world.setBlockState(pos, Blocks.glass.getDefaultState());
		} else if(world.getBlockState(pos).getBlock() == Blocks.log || world.getBlockState(pos).getBlock() == Blocks.log2) {
			world.setBlockToAir(pos);
			world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.coal, 1, 1)));
		} else if(world.getBlockState(pos).getBlock() == Blocks.iron_ore) {
			world.setBlockToAir(pos);
			world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.iron_ingot)));
		} else if(world.getBlockState(pos).getBlock() == Blocks.gold_ore) {
			world.setBlockToAir(pos);
			world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.gold_ingot)));
		} else if(world.getBlockState(pos).getBlock() == Blocks.netherrack) {
			world.setBlockToAir(pos);
			world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.netherbrick)));
		} else if(world.getBlockState(pos).getBlock() == Blocks.clay) {
			world.setBlockState(pos, Blocks.hardened_clay.getDefaultState());
		} else if(world.getBlockState(pos).getBlock() == Blocks.ice) {
			world.setBlockState(pos, Blocks.flowing_water.getDefaultState());
		} else if(world.getBlockState(pos).getBlock() == Blocks.packed_ice) {
			world.setBlockState(pos, Blocks.ice.getDefaultState());
		}
	}
}
