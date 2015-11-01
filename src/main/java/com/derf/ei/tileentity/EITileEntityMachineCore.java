package com.derf.ei.tileentity;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.multiblock.EIMultiBlockFactory;
import com.derf.ei.multiblock.IMultiBlock;


public class EITileEntityMachineCore extends EITileEntity {
	// Totem Section
	// Fire Totem
	public static final int FIRE_TOTEM = 0;
	// Water Totem
	public static final int WATER_TOTEM = 1;
	// Air Totem
	public static final int AIR_TOTEM = 2;
	// Earth Totem
	public static final int EARTH_TOTEM = 3;
	// Void Totem
	public static final int VOID_TOTEM = 4;
	// Generator Section
	// Cobblestone Generator
	public static final int COBBLE_STONE_GENERATOR = 5;
	// Dirt Generator
	public static final int DIRT_GENERATOR = 6;
	// Sand Generator
	public static final int SAND_GENERATOR = 7;
	// Clay Generator
	public static final int CLAY_GENERATOR = 8;
	// Gravel Generator
	public static final int GRAVEL_GENERATOR = 9;
	// Netherrack Generator
	public static final int NETHER_GENERATOR = 10;
	// Soulsand Generator
	public static final int SOULSAND_GENERATOR = 11;
	// Void Furnace [Basic Level Furnace]
	public static final int VOID_STONE_FURNACE = 12;
	// Void Smelter. [Basic Level Smelter]
	public static final int VOID_STONE_SMELTER = 13;
	// Basic Item Void
	public static final int BASIC_ITEM_VOID = 14;
	// Max Size
	public static final int MB_SIZE = 15;
	
	private int mode = FIRE_TOTEM;
	
	private static String[] messages = new String[] {
		"Machine Core Configuration: Currently set to Fire Totem.",
		"Machine Core Configuration: Currently set to Water Totem.",
		"Machine Core Configuration: Currently set to Air Totem.",
		"Machine Core Configuration: Currently set to Earth Totem.",
		"Machine Core Configuration: Currently set to Void Totem.",
		"Machine Core Configuration: Currently set to Cobblestone Generator.",
		"Machine Core Configuration: Currently set to Dirt Generator.",
		"Machine Core Configuration: Currently set to Sand Generator.",
		"Machine Core Configuration: Currently set to Clay Generator.",
		"Machine Core Configuration: Currently set to Gravel Generator.",
		"Machine Core Configuration: Currently set to Netherrack Generator.",
		"Machine Core Configuration: Currently set to Soulsand Generator.",
		"Machine Core Configuration: Currently set to Void Stone Furnace.",
		"Machine Core Configuration: Currently set to Void Stone Smelter.",
		"Machine Core Configuration: Currently set to Basic Item Void."
	};
	
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
		if(mode < MB_SIZE - 1) {
			this.setMode(this.getMode() + 1);
		} else {
			this.setMode(FIRE_TOTEM);
		}
	}
	
	public void printType(EntityPlayer player) {
		
		if(this.mode < messages.length) {
			player.addChatComponentMessage(new ChatComponentText(messages[mode]));
		} else {
			player.addChatComponentMessage(new ChatComponentText("Machine Core Configuration: Unknown because the modder frcook didn't set it yet."));
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
	
	private boolean checkForOneInputBlock(ArrayList<Block> temp) {
		int num = 0;
		
		for(int i = 2; i < temp.size(); i++) {
			if(EIBlocks.isVoidStoneItemInput(temp.get(i))) {
				num += 1;
			}
		}
		
		return num == 1;
	}
	
}
