package com.derf.ei.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class EIEntityTNTPrimed extends EntityTNTPrimed {

	public EIEntityTNTPrimed(World arg0, double arg1, double arg2, double arg3, EntityLivingBase arg4, int fuse) {
		super(arg0, arg1, arg2, arg3, arg4);
		this.setFuse(fuse);
	}
	
	
}
