package com.derf.ei.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class EITileEntityTank extends EITileEntity implements IFluidHandler {
	protected FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME * 32);

	/*
	 * Original implementation: GYTH
	 * Created By darkhax
	 * https://github.com/Darkhax-Minecraft/GYTH/blob/master/src/main/java/net/darkhax/gyth/common/tileentity/TileEntityModularTank.java
	 */
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		int fluid = tank.fill(resource, doFill);
		
		if(fluid > 0 && doFill) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, this.getBlockType());
		}
		
		return fluid;
	}
	/*
	 * Original implementation: GYTH
	 * Created By darkhax
	 * https://github.com/Darkhax-Minecraft/GYTH/blob/master/src/main/java/net/darkhax/gyth/common/tileentity/TileEntityModularTank.java
	 */
	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if(tank.getFluidAmount() > 0 && tank.getFluid().getFluid() == resource.getFluid()) {
			return this.drain(from, resource.amount, doDrain);
		}
		return null;
	}
	/*
	 * Original implementation: GYTH
	 * Created By darkhax
	 * https://github.com/Darkhax-Minecraft/GYTH/blob/master/src/main/java/net/darkhax/gyth/common/tileentity/TileEntityModularTank.java
	 */
	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		FluidStack stack = tank.drain(maxDrain, doDrain);
		
		if(stack != null && doDrain) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, this.getBlockType());
		}
		
		return stack;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return tank.getFluidAmount() < tank.getCapacity() && tank.getFluid().getFluid() == fluid;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return tank.getFluidAmount() > 0;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		// TODO Auto-generated method stub
		return new FluidTankInfo[] { tank.getInfo() };
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		System.out.println("Hello From readFromNBT");
		int capacity = compound.getInteger("capacity");
		
		FluidStack liquid;
		
		if(compound.getBoolean("Empty")) {
			liquid = null;
		} else {
			liquid = FluidStack.loadFluidStackFromNBT(compound);
		}
		
		this.tank = new FluidTank(liquid, capacity);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		System.out.println("Hello From writeToNBT");
		
		compound.setInteger("capacity", this.tank.getCapacity());
		
		if(this.tank.getFluid() == null) {
			compound.setBoolean("Empty", true);
		} else {
			compound.setBoolean("Empty", false);
			FluidStack fluid = tank.getFluid();
			fluid.writeToNBT(compound);
		}
	}
	
	public boolean isEmpty() {
		return this.tank.getFluid() == null;
	}
}
