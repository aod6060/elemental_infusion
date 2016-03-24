package com.derf.ei.items.rods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EIItemRodVoidium extends EIItemRod {
	
	public static final int VOID_1x1 = 0;
	public static final int VOID_3x3 = 1;
	public static final int VOID_5x5 = 2;
	public static final int VOID_7x7 = 3;
	public static final int VOID_9x9 = 4;
	protected boolean isMinable = false;
	
	public EIItemRodVoidium(String name) {
		super(name);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world,EntityPlayer player, EnumHand hand) {
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
					//player.addChatMessage(new TextComponentString("Mode: Void 3x3 area"));
					this.print(world, player, "Mode: 3x3 Area!");
					break;
				case VOID_3x3:
					stack.getTagCompound().setInteger("mode", VOID_5x5);
					//player.addChatMessage(new TextComponentString("Mode: Void 5x5 area"));
					this.print(world, player, "Mode: 5x5 Area!");
					break;
				case VOID_5x5:
					stack.getTagCompound().setInteger("mode", VOID_7x7);
					//player.addChatMessage(new TextComponentString("Mode: Void 7x7 area"));
					this.print(world, player, "Mode: 7x7 Area!");
					break;
				case VOID_7x7:
					stack.getTagCompound().setInteger("mode", VOID_9x9);
					//player.addChatMessage(new TextComponentString("Mode: Void 9x9 area"));
					this.print(world, player, "Mode: 9x9 Area!");
					break;
				case VOID_9x9:
					stack.getTagCompound().setInteger("mode", VOID_1x1);
					//player.addChatMessage(new TextComponentString("Mode: Void 1x1 area"));
					this.print(world, player, "Mode: 1x1 Area!");
					break;
				}
			} else {
				
			}
		}
		return super.onItemRightClick(stack, world, player, hand);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		
		if(!world.isRemote) {
			if(stack.getTagCompound() == null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("mode", VOID_1x1);
				stack.setTagCompound(tag);
			}		
			
			// This needs to be in both 
			if(player.isSneaking()) {
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
					// I need to work on this
					break;
				case VOID_7x7:
					void_7x7(world, pos, player, facing);
					// I need to work on this
					break;
				case VOID_9x9:
					void_9x9(world, pos, player, facing);
					// I need to work on this
					break;
				}
			}
		}
		return EnumActionResult.SUCCESS;
	}
	
	private void void_1x1(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		if(!this.isUnbreable(world, pos)) {	
			destroyBlock(world, pos, pos, this.isMinable);
		}
	}

	private void void_3x3(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> bpos = getBlock3x3(world, pos, facing);
		
		for(int i = 0; i < bpos.size(); i++) {
			if(!this.isUnbreable(world, bpos.get(i))) {	
				destroyBlock(world, bpos.get(i), pos, this.isMinable);
				//System.out.println(bpos.get(i));
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
			
		} else if(facing.getName().contains("west") || facing.getName().contains("east")) {
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1));
			
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1));
		
		} else if(facing.getName().contains("north") || facing.getName().contains("south")) {
			temp.add(new BlockPos(pos.getX()-1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()-1, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ()));
			
		}
		return temp;
	}

	private void void_5x5(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<BlockPos> bpos = getBlock5x5(world, pos, facing);
		
		for(int i = 0; i < bpos.size(); i++) {
			if(!this.isUnbreable(world, bpos.get(i))) {	
				destroyBlock(world, bpos.get(i), pos, this.isMinable);
			}
		}
	}

	private ArrayList<BlockPos> getBlock5x5(World world, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> temp = new ArrayList<BlockPos>();
		
		if(facing.getName().contains("up") || facing.getName().contains("down")) {
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-2));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-1));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+1));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+2));
			
		} else if(facing.getName().contains("west") || facing.getName().contains("east")) {
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+2));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+2));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+2));
			
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+2));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+2));
			
		} else if(facing.getName().contains("north") || facing.getName().contains("south")) {
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+3, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+1, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-2, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()-1, pos.getZ()));
		}
		
		return temp;
	}

	private void void_7x7(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> bpos = getBlock7x7(world, pos, facing);
		
		for(int i = 0; i < bpos.size(); i++) {
			if(!this.isUnbreable(world, bpos.get(i))) {	
				destroyBlock(world, bpos.get(i), pos, this.isMinable);
			}
		}
	}

	private ArrayList<BlockPos> getBlock7x7(World world, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> temp = new ArrayList<BlockPos>();
		
		if(facing.getName().contains("up") || facing.getName().contains("down")) {
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-3));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-2));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-1));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+1));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+2));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+3));
			
		} else if(facing.getName().contains("west") || facing.getName().contains("east")) {
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+3));
			
		} else if(facing.getName().contains("north") || facing.getName().contains("south")) {
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+5, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+4, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+3, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+2, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+1, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-3, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()-1, pos.getZ()));
		}
		
		return temp;
	}

	private void void_9x9(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<BlockPos> bpos = getBlock9x9(world, pos, facing);
		
		for(int i = 0; i < bpos.size(); i++) {
			if(!this.isUnbreable(world, bpos.get(i))) {	
				destroyBlock(world, bpos.get(i), pos, this.isMinable);
			}
		}
	}
	
	private ArrayList<BlockPos> getBlock9x9(World world, BlockPos pos,
			EnumFacing facing) {
		// TODO Auto-generated method stub
		ArrayList<BlockPos> temp = new ArrayList<BlockPos>();
		
		if(facing.getName().contains("up") || facing.getName().contains("down")) {
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  -4));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()-4));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  -3));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()-3));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  -2));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()-2));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  -1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()-1));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  +1));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()+1));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  +2));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()+2));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  +3));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()+3));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()  +4));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()+4));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()+4));
		} else if(facing.getName().contains("west") || facing.getName().contains("east")) {
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+7, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+6, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+5, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+4, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+3, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+4));
			
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-4));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-3));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-2));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()-1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+1));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+2));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+3));
			temp.add(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ()+4));
			
		} else if(facing.getName().contains("north") || facing.getName().contains("south")) {
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+7, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+7, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+6, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+6, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+5, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+5, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+4, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+4, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+3, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+3, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+2, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+2, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()+1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()+1, pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY(), pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY(), pos.getZ()));
			
			temp.add(new BlockPos(pos.getX()-4, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-3, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-2, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()-1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX(), 	pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+1, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+2, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+3, pos.getY()-1, pos.getZ()));
			temp.add(new BlockPos(pos.getX()+4, pos.getY()-1, pos.getZ()));
		}
		return temp;
	}

	private boolean isUnbreable(World world, BlockPos pos) {
		return world.getBlockState(pos).getBlock() == Blocks.bedrock || world.getBlockState(pos).getBlock() == Blocks.end_portal_frame;
	}
	
	// This should be faster than destroy block
	private void destroyBlock(World world, BlockPos pos, BlockPos center, boolean minable) {
		
		if(minable) {
			IBlockState state = world.getBlockState(pos);
			
			List<ItemStack> list = state.getBlock().getDrops(world, pos, state, 0);
			
			for(int i = 0; i < list.size(); i++) {
				world.spawnEntityInWorld(new EntityItem(world, center.getX(), center.getY(), center.getZ(), list.get(i)));
			}
			
			world.setBlockToAir(pos);
		} else {
			world.setBlockToAir(pos);
		}
	}
	
	private void print(World world, EntityPlayer player, String mode) {
		if(!world.isRemote) {
			player.addChatMessage(new TextComponentString(mode));
		}
	}
}
