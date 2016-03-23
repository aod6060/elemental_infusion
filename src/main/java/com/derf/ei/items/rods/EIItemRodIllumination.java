package com.derf.ei.items.rods;

import com.derf.ei.entity.EIEntityLight;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EIItemRodIllumination extends EIItemRod {

	public EIItemRodIllumination(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EIEntityLight(world, player));
		}
		
		return super.onItemRightClick(stack, world, player, hand);
	}
	
}
