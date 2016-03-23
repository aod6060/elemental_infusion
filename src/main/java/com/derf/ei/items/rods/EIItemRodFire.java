package com.derf.ei.items.rods;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EIItemRodFire extends EIItemRod {
	
	public EIItemRodFire(String name) {
		super(name);
		
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		
		if(!world.isRemote) {
			
			if(facing.getName().compareTo("up") == 0) {
				world.setBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ()), Blocks.fire.getDefaultState());
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
}
