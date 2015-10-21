package com.derf.ei.multiblock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IMultiBlock {
	public void update(World world, int x, int y, int z);
	
	public void writeToNBT(NBTTagCompound compound);
	
	public void readFromNBT(NBTTagCompound compound);
	
}
