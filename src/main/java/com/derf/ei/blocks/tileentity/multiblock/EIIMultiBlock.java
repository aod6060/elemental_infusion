package com.derf.ei.blocks.tileentity.multiblock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface EIIMultiBlock {
	
	public void update(World world, BlockPos pos);
	
	public void writeToNBT(NBTTagCompound comp);
	
	public void readFromNBT(NBTTagCompound comp);
}
