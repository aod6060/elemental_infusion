package com.derf.ei.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.derf.ei.blocks.EIBlocks;
import com.derf.ei.util.EIVec3d;

public class EIEntityLight extends EntityThrowable {

	private int currentAirTime = 0;
	private int maxAirTime = 1000;
	
	public EIEntityLight(World world) {
		super(world);
		// TODO Auto-generated constructor stub
		this.setSize(0.5f, 0.5f);
	}
	
	public EIEntityLight(World world, double x, double y, double z) {
		super(world);
		this.setSize(0.5f, 0.5f);
		this.setPosition(x, y, z);
	}
	
	public EIEntityLight(World world, EntityLivingBase player) {
		super(world, player);
		this.setSize(0.5f, 0.5f);
		EIVec3d velocity = new EIVec3d(player.getLookVec());
		velocity = EIVec3d.mul(velocity, 10.0);
		this.setLocationAndAngles(player.posX, player.posY + player.height, player.posZ, 0.0f, 0.0f);
		this.motionX = velocity.getX();
		this.motionY = velocity.getY();
		this.motionZ = velocity.getZ();
	}
	
	
	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		super.onUpdate();
		
		if(this.currentAirTime > this.maxAirTime) {
			this.setDead();
		} else {
			this.currentAirTime += 1;
		}
	}

	@Override
	protected float getGravityVelocity() {
		// TODO Auto-generated method stub
		return 0.0f;
	}
	
	
	@Override
	protected void onImpact(RayTraceResult mop) {
		// TODO Auto-generated method stub
		if(mop.typeOfHit == RayTraceResult.Type.BLOCK) {
			EnumFacing sideHit = mop.sideHit;
			BlockPos blockPos = mop.getBlockPos().offset(sideHit);
			
			if(worldObj.isAirBlock(blockPos)) {
				worldObj.setBlockState(blockPos, EIBlocks.light.getDefaultState());
			}
			
			this.setDead();
		}
	}


}
