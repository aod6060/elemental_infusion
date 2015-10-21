package com.derf.ei.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.derf.ei.tileentity.EITileEntityMachineCore;

public class EIItemVoidTool extends EIItem {

	public EIItemVoidTool(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.setMaxStackSize(1);
		
	}

	@Override
	public boolean onItemUse(
			ItemStack itemStack, 
			EntityPlayer player, 
			World world, 
			int x, 
			int y, 
			int z, 
			int side, 
			float fx, 
			float fy, 
			float fz) {
		
		
		
		if(!world.isRemote) {
			Block block;
			block = world.getBlock(x, y, z);
			
			if(block.getUnlocalizedName().equals("tile.void_stone")) {
				player.addChatComponentMessage(new ChatComponentText("This is a Void Stone."));
			} else if(block.getUnlocalizedName().equals("tile.machine_core")) {
				EITileEntityMachineCore tentity = (EITileEntityMachineCore) world.getTileEntity(x, y, z);
				
				if(player.isSneaking()) {
					tentity.printType(player);
				} else {
					tentity.toggleMode();
					tentity.printType(player);
				}
				
			} else {
				player.addChatComponentMessage(new ChatComponentText(block.getLocalizedName() + ": isn't a block that your void tool can interact with."));
			}
		}
		
		return true;
	}
	
	
}
