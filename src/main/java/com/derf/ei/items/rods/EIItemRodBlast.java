package com.derf.ei.items.rods;

import java.util.ArrayList;

import com.derf.ei.util.EIVec3d;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EIItemRodBlast extends EIItemRod {
	private static final double strength = 2.0;
	private static final double range = 16.0;
	
	public EIItemRodBlast(String name) {
		super(name);
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
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			// TODO Auto-generated method stub
			AxisAlignedBB box = this.getRangedBox(player);
			ArrayList<Entity> list = this.getEntitiesWithAABB(world, EntityCreature.class, box);
			
			EIVec3d pp = new EIVec3d(
					player.posX,
					player.posY,
					player.posZ);
			
			
			for(int i = 0; i < list.size(); i++) {
				Entity ei = list.get(i);
				EIVec3d v = new EIVec3d(ei.posX, ei.posY, ei.posZ);
				EIVec3d s = EIVec3d.sub(v, pp);
				s = EIVec3d.unit(s);
				s = EIVec3d.mul(s, this.strength);
				ei.motionX += s.getX();
				ei.motionY += strength;
				ei.motionZ += s.getZ();
			}
		}
		
		return super.onItemRightClick(stack, world, player, hand);
	}

	private ArrayList<Entity> getEntitiesWithAABB(World world, Class cls, AxisAlignedBB box) {
		ArrayList<Entity> temp;
		
		temp = (ArrayList<Entity>) world.getEntitiesWithinAABB(cls, box);
		
		return temp;
	}
}
