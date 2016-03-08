package com.derf.ei.items.rods;

import java.util.ArrayList;

import com.derf.ei.util.EIVec3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EIItemRodBlast extends EIItemRod {
	private static final double strength = 3.0;
	private static final double range = 16.0;
	
	public EIItemRodBlast(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		// TODO Auto-generated method stub
		
		if(!world.isRemote) {
			// TODO Auto-generated method stub
			AxisAlignedBB box = this.getRangedBox(player);
			ArrayList<Entity> list = this.getEntitiesWithAABB(world, EntityCreature.class, box);
			
			EIVec3 pp = new EIVec3(
					player.posX,
					player.posY,
					player.posZ);
			
			
			for(int i = 0; i < list.size(); i++) {
				Entity ei = list.get(i);
				EIVec3 v = new EIVec3(ei.posX, ei.posY, ei.posZ);
				EIVec3 s = EIVec3.sub(v, pp);
				s = EIVec3.unit(s);
				s = EIVec3.mul(s, this.strength);
				ei.motionX += s.getX();
				ei.motionY += strength;
				ei.motionZ += s.getZ();
			}
		} 
		
		return super.onItemRightClick(stack, world, player);
	}
	
	private AxisAlignedBB getRangedBox(Entity player) {
		AxisAlignedBB box = new AxisAlignedBB(
				player.posX - range,
				player.posY - range,
				player.posZ - range,
				player.posX + range,
				player.posY + range,
				player.posZ + range
				);
		return box;
	}
	
	private ArrayList<Entity> getEntitiesWithAABB(World world, Class cls, AxisAlignedBB box) {
		ArrayList<Entity> temp;
		
		temp = (ArrayList<Entity>) world.getEntitiesWithinAABB(cls, box);
		
		return temp;
	}
}
