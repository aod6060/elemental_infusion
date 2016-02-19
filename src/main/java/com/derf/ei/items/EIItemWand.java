package com.derf.ei.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.blocks.tileentity.EITileEntityMachineCore;

public class EIItemWand extends Item {
	
	public EIItemWand(String name) {
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
			
			if(isVoidiumStone(state)) {
				
				if(state.getBlock() == EIBlocks.voidiumStone) {
					world.setBlockState(pos, EIBlocks.voidiumStoneInput.getDefaultState());
				} else if(state.getBlock() == EIBlocks.voidiumStoneInput) {
					world.setBlockState(pos, EIBlocks.voidiumStoneOutput.getDefaultState());
				} else if(state.getBlock() == EIBlocks.voidiumStoneOutput) {
					world.setBlockState(pos, EIBlocks.voidiumStoneIO.getDefaultState());
				} else if(state.getBlock() == EIBlocks.voidiumStoneIO) {
					world.setBlockState(pos, EIBlocks.voidiumStone.getDefaultState());
				}
			} else if(state.getBlock() == EIBlocks.machineCore) {
				//player.addChatComponentMessage(new ChatComponentText("Machine Core"));
				// To do add the ability to change to different multi blocks (this is similar to the older one, however
				// less multi blocks).
				EITileEntityMachineCore core = (EITileEntityMachineCore) world.getTileEntity(pos);
				
				core.launch(player);
			}
		}
		
		return true;
	}
	
	
	private boolean isVoidiumStone(IBlockState state) {
		return state.getBlock() == EIBlocks.voidiumStone ||
			   state.getBlock() == EIBlocks.voidiumStoneInput ||
			   state.getBlock() == EIBlocks.voidiumStoneOutput ||
			   state.getBlock() == EIBlocks.voidiumStoneIO;
	}
}
