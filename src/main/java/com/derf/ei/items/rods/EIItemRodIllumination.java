package com.derf.ei.items.rods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.derf.ei.entity.EIEntityLight;

public class EIItemRodIllumination extends EIItemRod {

	public EIItemRodIllumination(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack,World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EIEntityLight(world, player));
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
	
}
