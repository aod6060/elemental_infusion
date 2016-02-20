package com.derf.ei.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.blocks.tileentity.EITileEntityElementalInfuser;

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
				if(state.getBlock() == EIBlocks.voidiumStone) {
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
}
