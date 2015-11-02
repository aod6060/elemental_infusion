package com.derf.ei.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.tileentity.EITileEntityMachineCore;
import com.derf.ei.tileentity.EITileEntityTank;

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
			
			if(isVoidStone(block)) {
				
				if(EIBlocks.isVoidStone(block)) {
					world.setBlock(x, y, z, EIBlocks.voidStoneItemInput);
				} else if(EIBlocks.isVoidStoneItemInput(block)) {
					world.setBlock(x, y, z, EIBlocks.voidStoneItemOutput);
				} else if(EIBlocks.isVoidStoneItemOutput(block)) {
					world.setBlock(x, y, z, EIBlocks.voidStoneLiquidInput);
				} else if(EIBlocks.isVoidStoneLiquidInput(block)) {
					world.setBlock(x, y, z, EIBlocks.voidStoneLiquidOutput);
				} else if(EIBlocks.isVoidStoneLiquidOutput(block)) {
					world.setBlock(x, y, z, EIBlocks.voidStone);
				}
				
			} else if(EIBlocks.isMachineCore(block)) {
			
				EITileEntityMachineCore tentity = (EITileEntityMachineCore) world.getTileEntity(x, y, z);
				
				if(player.isSneaking()) {
					tentity.printType(player);
				} else {
					tentity.toggleMode();
					tentity.printType(player);
				}
				
			} else if(this.isTank(block)) {
				//player.addChatComponentMessage(new ChatComponentText("This is a tank"));
				
				EITileEntityTank tank = (EITileEntityTank)world.getTileEntity(x, y, z);
				
				if(tank != null) {
					FluidTankInfo[] info = tank.getTankInfo(ForgeDirection.UNKNOWN);
					
					if(info != null) {
						int capacity = info[0].capacity;
						
						if(info[0].fluid == null) {
							player.addChatComponentMessage(new ChatComponentText("Tank is empty."));
						} else {
							player.addChatComponentMessage(new ChatComponentText("Current Amount: "+info[0].fluid.amount+"/"+capacity+": Liquid Name: "+info[0].fluid.getLocalizedName()));
						}
					}
				}
			} else {
				player.addChatComponentMessage(new ChatComponentText(block.getLocalizedName() + ": isn't a block that your void tool can interact with."));
			}
		}
		
		return true;
	}
	
	private boolean isVoidStone(Block block) {
		return EIBlocks.isVoidStone(block) ||
			   EIBlocks.isVoidStoneItemInput(block) ||
			   EIBlocks.isVoidStoneItemOutput(block) ||
			   EIBlocks.isVoidStoneLiquidInput(block) ||
			   EIBlocks.isVoidStoneLiquidOutput(block);
	}
	
	private boolean isTank(Block block) {
		return EIBlocks.isVoidTank(block);
	}
}
