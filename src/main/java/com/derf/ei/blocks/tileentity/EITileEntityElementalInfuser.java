package com.derf.ei.blocks.tileentity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import com.derf.ei.crafting.EIInfuserRecipe;
import com.derf.ei.crafting.EIInfuserRecipeManager;

public class EITileEntityElementalInfuser extends TileEntity {
	
	private BlockPos chest;
	
	private int mode = 0;
	
	public void launch(EntityPlayer player) {
		
		if(!worldObj.isRemote) {
			if(isMultiBlockComplete(player)) {
				player.addChatMessage(new ChatComponentText("Lauchning Recipe..."));
				
				
				if(doCrafting(player)) {
					player.addChatMessage(new ChatComponentText("Crafting Complete!"));
				} else {
					player.addChatMessage(new ChatComponentText("Crafting failed, missing items."));
				}
			} else {
				player.addChatMessage(new ChatComponentText("MultiBlock Incomplete - Missing chest most likely"));
			}
		}
	}

	private boolean doCrafting(EntityPlayer player) {
		// TODO Auto-generated method stub
		boolean b = false;
		
		IInventory inv = (IInventory) worldObj.getTileEntity(chest);
		
		
		ArrayList<String> names = new ArrayList<String>();
		
		EIInfuserRecipeManager.getNames(names);
		
		player.addChatMessage(new ChatComponentText(EIInfuserRecipeManager.get(names.get(mode)).getDescription()));
		
		if(EIInfuserRecipeManager.get(names.get(mode)).checkInventory(inv)) {
			
			EIInfuserRecipeManager.get(names.get(mode)).doCraft(inv, worldObj, chest);
			
			b = true;
		}
		
		return b;
	}

	private boolean isMultiBlockComplete(EntityPlayer player) {
		// TODO Auto-generated method stub
		boolean b = false;
		
		chest = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		
		if(worldObj.getBlockState(chest).getBlock() == Blocks.chest) {
			b = true;
		}
		
		return b;
	}
	
	public int getMode() {
		return mode;
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public void toggleMode(EntityPlayer player) {
		ArrayList<String> names = new ArrayList<String>();
		EIInfuserRecipeManager.getNames(names);
		
		if(mode < names.size() - 1) {
			this.setMode(this.getMode() + 1);
		} else {
			this.setMode(0);
		}
		
		player.addChatMessage(new ChatComponentText(EIInfuserRecipeManager.get(names.get(this.mode)).getDescription()));
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.setMode(compound.getInteger("mode"));
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		compound.setInteger("mode", this.getMode());
	}
	
	public void currentMode(EntityPlayer player) {
		ArrayList<String> names = new ArrayList<String>();
		EIInfuserRecipeManager.getNames(names);
		
		player.addChatMessage(new ChatComponentText(EIInfuserRecipeManager.get(names.get(this.mode)).getDescription()));
	}
	
	public String getRecipe() {
		ArrayList<String> names = new ArrayList<String>();
		EIInfuserRecipeManager.getNames(names);
		return names.get(this.mode);
	}
}
