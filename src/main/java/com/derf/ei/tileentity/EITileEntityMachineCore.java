package com.derf.ei.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

import com.derf.ei.multiblock.EIMultiBlockFactory;
import com.derf.ei.multiblock.IMultiBlock;


public class EITileEntityMachineCore extends EITileEntity {
	// Fire Totem
	public static final int FIRE_TOTEM = 0;
	// Water Totem
	public static final int WATER_TOTEM = 1;
	// Air Totem
	public static final int AIR_TOTEM = 2;
	// Earth Totem
	public static final int EARTH_TOTEM = 3;
	
	private int mode = FIRE_TOTEM;
	
	private IMultiBlock multiBlock = EIMultiBlockFactory.createMultiBlock(FIRE_TOTEM);
	
	
	@Override
	public void updateEntity() {
		// TODO Auto-generated method stub
		super.updateEntity();
		
		if(!worldObj.isRemote) {
			
			
			if(multiBlock != null) {
				multiBlock.update(worldObj, xCoord, yCoord, zCoord);
			}
		}
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
		this.multiBlock = EIMultiBlockFactory.createMultiBlock(this.mode);
	}
	
	public void toggleMode() {
		if(mode == FIRE_TOTEM) {
			//mode = WATER_TOTEM;
			this.setMode(WATER_TOTEM);
		} else if(mode == WATER_TOTEM) {
			//mode = AIR_TOTEM;
			this.setMode(AIR_TOTEM);
		} else if(mode == AIR_TOTEM) {
			//mode = EARTH_TOTEM;
			this.setMode(EARTH_TOTEM);
		} else if(mode == EARTH_TOTEM) {
			//mode = FIRE_TOTEM;
			this.setMode(FIRE_TOTEM);
		}
	}
	
	public void printType(EntityPlayer player) {
		
		switch(mode) {
		case FIRE_TOTEM:
			player.addChatComponentMessage(new ChatComponentText("Machine Core Configuration: Currently set to Fire Totem."));
			break;
		case WATER_TOTEM:
			player.addChatComponentMessage(new ChatComponentText("Machine Core Configuration: Currently set to Water Totem."));
			break;
		case AIR_TOTEM:
			player.addChatComponentMessage(new ChatComponentText("Machine Core Configuration: Currently set to Air Totem."));
			break;
		case EARTH_TOTEM:
			player.addChatComponentMessage(new ChatComponentText("Machine Core Configuration: Currently set to Earth Totem."));
			break;
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		
		// Grab mode from NBT Compound
		this.setMode(compound.getInteger("mode"));
		// This section will be for the multiblock interface
		
		if(multiBlock != null) {
			multiBlock.readFromNBT(compound);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		
		// Add mode to NBT Compound
		compound.setInteger("mode", this.getMode());
		// This section will save the data to the 
		// NBT multiblock interface
		if(multiBlock != null) {
			multiBlock.writeToNBT(compound);
		}
	}
	
	
}