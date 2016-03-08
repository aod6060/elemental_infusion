package com.derf.ei.items.rods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.derf.ei.util.EIVec3;

public class EIItemRodTravel extends EIItemRod {

	private static double speed = 3.0;
	
	public EIItemRodTravel(String name) {
		super(name);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		if(!world.isRemote) {
			// TODO Auto-generated method stub
			Vec3 v = player.getLookVec();
			EIVec3 direction = new EIVec3(v);
			
			direction = EIVec3.mul(direction, speed);
			
			player.motionX = direction.getX();
			player.motionY = direction.getY();
			player.motionZ = direction.getZ();
			// Thanks Mr. WayOfTime
			player.velocityChanged = true;
			player.fallDistance = 0;
		} 
		
		return super.onItemRightClick(stack, world, player);
	}
}
