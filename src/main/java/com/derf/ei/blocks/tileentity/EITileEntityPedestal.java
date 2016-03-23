package com.derf.ei.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;

public class EITileEntityPedestal extends TileEntity implements IInventory{
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack decrStackSize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getField(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isItemValidForSlot(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack removeStackFromSlot(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setField(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInventorySlotContents(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

}
