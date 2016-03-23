package com.derf.ei.items.rods;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EIItemRodSmelting extends EIItemRod {

	public EIItemRodSmelting(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		
		if(!world.isRemote) {
			ItemStack block = new ItemStack(world.getBlockState(pos).getBlock());
			
			if(FurnaceRecipes.instance().getSmeltingResult(block) != null) {
				ItemStack temp = FurnaceRecipes.instance().getSmeltingResult(block);
				world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), temp.copy()));
				world.setBlockToAir(pos);
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
	
}
