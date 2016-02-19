package com.derf.ei.blocks.tileentity.multiblock;

import java.util.ArrayList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class MultiBlockInfuser implements IMultiBlock {

	
	@Override
	public void update(World world, BlockPos pos) {
		// TODO Auto-generated method stub
		
		if(this.isMultiBlockComplete(world, pos)) {
			this.updateInventory(world);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readFromNBT(NBTTagCompound comp) {
		// TODO Auto-generated method stub

	}
	
	private boolean isMultiBlockComplete(World world, BlockPos pos) {
		ArrayList<BlockPos> bp = this.createPositionList(pos);
		ArrayList<IBlockState> bs = this.createBSList(world, bp);
		
		System.out.println(bs.size());
		for(int i = 0; i < bs.size(); i++) {
			//System.out.print("<"+bp.get(i).getX()+","+bp.get(i).getY()+","+bp.get(i).getZ()+"> "); System.out.println(bs.get(i).getBlock().getUnlocalizedName());
		}
		
		return false;
	}
	
	private void updateInventory(World world) {
		// TODO Auto-generated method stub
	}
	
	private ArrayList<BlockPos> createPositionList(BlockPos pos) {
		ArrayList<BlockPos> temp = new ArrayList<BlockPos>();
		
		// Input East
		temp.add(new BlockPos(pos.getX() - 3, pos.getY() - 3, pos.getZ()));
		// Input West
		temp.add(new BlockPos(pos.getX() + 3, pos.getY() - 3, pos.getZ()));
		// Input North
		temp.add(new BlockPos(pos.getX(), pos.getY() - 3, pos.getZ() - 3));
		// Input South
		temp.add(new BlockPos(pos.getX(), pos.getY() - 3, pos.getZ() + 3));
		// BiDirectional
		temp.add(new BlockPos(pos.getX(), pos.getY() - 3, pos.getZ()));
		
		return temp;
	}
	
	private ArrayList<IBlockState> createBSList(World world, ArrayList<BlockPos> pos) {
		ArrayList<IBlockState> states = new ArrayList<IBlockState>();
		
		for(int i = 0; i < pos.size(); i++) {
			states.add(world.getBlockState(pos.get(i)));
		}
		
		return states;
	
	}
}
