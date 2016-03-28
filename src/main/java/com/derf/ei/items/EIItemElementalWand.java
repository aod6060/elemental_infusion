package com.derf.ei.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.derf.ei.blocks.EIBlockVoidiumStone;
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
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos,  EnumHand hand, EnumFacing face, float fx, float fy, float fz) {
		EnumActionResult result = EnumActionResult.SUCCESS;
		
		System.out.println("Hello, World");
		
		if(!world.isRemote) {
			IBlockState state;
			state = world.getBlockState(pos);
			
			if(player.isSneaking()) {
				if(state.getBlock() == EIBlocks.elementalStone) {
					world.setBlockState(pos, EIBlocks.elementalInfuser.getDefaultState());
				} else if(state.getBlock() == EIBlocks.elementalInfuser) {
					EITileEntityElementalInfuser infuser = (EITileEntityElementalInfuser) world.getTileEntity(pos);
					infuser.toggleMode(player);
				}
			} else {
				if(state.getBlock() == EIBlocks.elementalInfuser) {
					EITileEntityElementalInfuser infuser = (EITileEntityElementalInfuser) world.getTileEntity(pos);
					
					System.out.println("Hello, World");
					
					infuser.launch(player);
					
				} else if(state.getBlock() == EIBlocks.voidiumStone) {
					changeVoidium(world, state, pos);
				}
			}
		}
		
		return result;
	}

	@SuppressWarnings("incomplete-switch")
	private void changeVoidium(World world, IBlockState state, BlockPos pos) {
		// TODO Auto-generated method stub
		
		EIBlockVoidiumStone.VoidiumStoneType type = state.getValue(EIBlockVoidiumStone.TYPE);
		
		switch(type) {
		case REGULAR:
			world.setBlockState(pos, EIBlocks.voidiumStone.getDefaultState().withProperty(EIBlockVoidiumStone.TYPE, EIBlockVoidiumStone.VoidiumStoneType.INPUT));
			break;
		case INPUT:
			world.setBlockState(pos, EIBlocks.voidiumStone.getDefaultState().withProperty(EIBlockVoidiumStone.TYPE, EIBlockVoidiumStone.VoidiumStoneType.OUTPUT));
			break;
		case OUTPUT:
			world.setBlockState(pos, EIBlocks.voidiumStone.getDefaultState().withProperty(EIBlockVoidiumStone.TYPE, EIBlockVoidiumStone.VoidiumStoneType.BIDIRECTIONAL));
			break;
		case BIDIRECTIONAL:
			world.setBlockState(pos, EIBlocks.voidiumStone.getDefaultState().withProperty(EIBlockVoidiumStone.TYPE, EIBlockVoidiumStone.VoidiumStoneType.REGULAR));
			break;
		}
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int meta, boolean b) {
		// TODO Auto-generated method stub
		
		
		if(!world.isRemote) {
			if(entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entity;
				
				RayTraceResult mop = this.getMovingObjectPositionFromPlayer(world, player, false);
				
				if(mop != null && mop.typeOfHit == RayTraceResult.Type.BLOCK) {
					
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
