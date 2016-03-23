package com.derf.ei.items.rods;

import java.util.ArrayList;
import java.util.Random;

import com.derf.ei.util.EIVec3;

import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EIItemRodGrowth extends EIItemRod {

	public EIItemRodGrowth(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			BlockPos pos = new BlockPos(player.posX, player.posY, player.posZ);
			// Grab All blocks states. around player in a 5x5 square
			ArrayList<BlockPos> bp = this.getPositions(pos);
			ArrayList<IBlockState> bs = this.getBlockStates(bp, world);
			// For loop through all of the blocks
			for(int i = 0; i < bs.size(); i++) {
				// Check if block is crops
				if(bs.get(i).getBlock() instanceof BlockCrops) {
					// Update Plant
					
					if(bs.get(i).getBlock() instanceof BlockBeetroot) {
						updateBeetrootCrop(bs.get(i), bp.get(i), world);
						System.out.println(bs.get(i));
					} else {
						updateCrop(bs.get(i), bp.get(i), world);
						System.out.println(bs.get(i));
					}
				} else {
					if(world.rand.nextInt(2) == 0) {
						bs.get(i).getBlock().updateTick(world, bp.get(i), bs.get(i), world.rand);
					}
				}
			}
		
		}
		
		return super.onItemRightClick(stack, world, player, hand);
	}
	
	private void updateBeetrootCrop(IBlockState state, BlockPos pos, World world) {
		// TODO Auto-generated method stub
		int age = ((Integer)state.getValue(BlockBeetroot.BEETROOT_AGE)).intValue();
		Random rand = new Random();
		if(age < 3) {
			if(rand.nextInt(3) == 0) {
				++age;
				world.setBlockState(pos, state.withProperty(BlockBeetroot.BEETROOT_AGE, age));
			}
		}
	}

	private void updateCrop(IBlockState state, BlockPos pos, World world) {
		// TODO Auto-generated method stub
		int age = ((Integer)state.getValue(BlockCrops.AGE)).intValue();
		Random rand = new Random();
		if(age < 7) {
			if(rand.nextInt(2) == 0) {
				++age;
				world.setBlockState(pos, state.withProperty(BlockCrops.AGE, age));
			}
		}
	}

	protected ArrayList<BlockPos> getPositions(BlockPos p) {
		ArrayList<BlockPos> temp = new ArrayList<BlockPos>();
		
		// +1
		this.createPositions(temp, new BlockPos(p.getX(), p.getY() + 1, p.getZ()));
		// 0
		this.createPositions(temp, p);
		// -1
		this.createPositions(temp, new BlockPos(p.getX(), p.getY() - 1, p.getZ()));
		
		return temp;
	}
	
	protected void createPositions(ArrayList<BlockPos> temp, BlockPos pos) {
		// -2 x
		temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-2));
		temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()-1));
		temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()));
		temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+1));
		temp.add(new BlockPos(pos.getX()-2, pos.getY(), pos.getZ()+2));
		// -1 x
		temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-2));
		temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1));
		temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()));
		temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1));
		temp.add(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+2));
		// x
		temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-2));
		temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1));
		temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
		temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1));
		temp.add(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+2));
		// +1 x
		temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-2));
		temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1));
		temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()));
		temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1));
		temp.add(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+2));
		// +2 x
		temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-2));
		temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()-1));
		temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()));
		temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+1));
		temp.add(new BlockPos(pos.getX()+2, pos.getY(), pos.getZ()+2));
	}
	
	protected ArrayList<IBlockState> getBlockStates(ArrayList<BlockPos> pos, World world) {
		ArrayList<IBlockState> temp = new ArrayList<IBlockState>();
		for(int i = 0; i < pos.size(); i++) {
			temp.add(world.getBlockState(pos.get(i)));
		}
		return temp;
	}
}
