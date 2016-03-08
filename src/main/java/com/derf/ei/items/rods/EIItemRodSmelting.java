package com.derf.ei.items.rods;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemRodSmelting extends EIItemRod {

	public EIItemRodSmelting(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			ItemStack block = new ItemStack(world.getBlockState(pos).getBlock());
			
			if(FurnaceRecipes.instance().getSmeltingResult(block) != null) {
				ItemStack temp = FurnaceRecipes.instance().getSmeltingResult(block);
				world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), temp.copy()));
				world.setBlockToAir(pos);
			}
		}


		return true;
	}
}
