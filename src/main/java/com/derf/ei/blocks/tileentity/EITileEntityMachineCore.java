package com.derf.ei.blocks.tileentity;

import java.util.ArrayList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.crafting.EIInfuserRecipeManager;
import com.derf.ei.items.EIItems;

public class EITileEntityMachineCore extends TileEntity {
	
	BlockPos chest;
	
	public void launch(EntityPlayer player) {
		
		if(!worldObj.isRemote) {
			if(isMultiBlockComplete(player)) {
				player.addChatMessage(new ChatComponentText("Lauchning Recipe..."));
				
				
				if(doCrafting(player)) {
					player.addChatMessage(new ChatComponentText("Have the required items for blank slates."));
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
		
		b = EIInfuserRecipeManager.blankSlate.checkInventory((IInventory)worldObj.getTileEntity(chest));
		
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


}
