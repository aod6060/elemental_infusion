package com.derf.ei.items.rods;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.derf.ei.util.EIVec3;

public class EIItemRodLivingMagnet extends EIItemRodMagnetism {

	public EIItemRodLivingMagnet(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMagnetUpdate(ItemStack stack, World world, Entity entity) {
		// TODO Auto-generated method stub
		AxisAlignedBB box = this.getBox(entity);
		ArrayList<Entity> list = this.getEntitiesWithinAABB(world, EntityLiving.class, box);
		EIVec3 playerPos = new EIVec3(entity.posX, entity.posY, entity.posZ);
		for(int i = 0; i < list.size(); i++) {
			Entity ei = list.get(i);
			EIVec3 v = new EIVec3(ei.posX, ei.posY, ei.posZ);
			EIVec3 s = EIVec3.sub(playerPos, v);
			s = EIVec3.unit(s);
			s = EIVec3.mul(s, strength);
			ei.motionX += s.getX();
			ei.motionY += s.getY();
			ei.motionZ += s.getZ();
		}
	}

	
}
