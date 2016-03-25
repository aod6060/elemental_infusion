package com.derf.ei.items.rods;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import com.derf.ei.util.EIVec3d;

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
		EIVec3d playerPos = new EIVec3d(entity.posX, entity.posY, entity.posZ);
		for(int i = 0; i < list.size(); i++) {
			Entity ei = list.get(i);
			EIVec3d v = new EIVec3d(ei.posX, ei.posY, ei.posZ);
			EIVec3d s = EIVec3d.sub(playerPos, v);
			s = EIVec3d.unit(s);
			s = EIVec3d.mul(s, strength);
			ei.motionX += s.getX();
			ei.motionY += s.getY();
			ei.motionZ += s.getZ();
		}
	}

	
}
