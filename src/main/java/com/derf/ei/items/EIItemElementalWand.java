package com.derf.ei.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.blocks.tileentity.EITileEntityElementalInfuser;
import com.derf.ei.handler.EIHandlers;

public class EIItemElementalWand extends Item {
	
	public EIItemElementalWand(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}

	
	@Override
	public boolean onItemUse(ItemStack stack,
							 EntityPlayer player, 
							 World world,
							 BlockPos pos, 
							 EnumFacing facing,
							 float fx, 
							 float fy, 
							 float fz) {
		
		if(!world.isRemote) {
			IBlockState state;
			state = world.getBlockState(pos);
			
			
			if(player.isSneaking()) {
				if(state.getBlock() == EIBlocks.elementalStone) {
					world.setBlockState(pos, EIBlocks.elementalInfuser.getDefaultState());
				} else if(state.getBlock() == EIBlocks.elementalInfuser) {
					EITileEntityElementalInfuser core = (EITileEntityElementalInfuser) world.getTileEntity(pos);
					core.toggleMode(player);
				}
			} else {
				if(state.getBlock() == EIBlocks.elementalInfuser) {
					//player.addChatComponentMessage(new ChatComponentText("Machine Core"));
					// To do add the ability to change to different multi blocks (this is similar to the older one, however
					// less multi blocks).
					EITileEntityElementalInfuser core = (EITileEntityElementalInfuser) world.getTileEntity(pos);
					
					core.launch(player);
				}
			}
		}
		
		return true;
	}


	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int meta, boolean b) {
		// TODO Auto-generated method stub
		
		
		if(!world.isRemote) {
			if(entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				
				MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, false);
				
				if(mop != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					
					BlockPos blockPos = mop.getBlockPos();
					
					IBlockState state = world.getBlockState(blockPos);
					
					if(state.getBlock() == EIBlocks.elementalInfuser) {
						
						EITileEntityElementalInfuser infuser = (EITileEntityElementalInfuser) world.getTileEntity(blockPos);
						
						EIHandlers.craftingOverlay.setShown(true);
						
						EIHandlers.craftingOverlay.setCurrentInfuser(infuser);
						
					} else {
						EIHandlers.craftingOverlay.setShown(false);
						EIHandlers.craftingOverlay.setCurrentInfuser(null);
					}
				} else {
					EIHandlers.craftingOverlay.setShown(false);
					EIHandlers.craftingOverlay.setCurrentInfuser(null);
				}
				
			}
		}
		
		super.onUpdate(stack, world, entity, meta,b);
	}
	
	
}
