package com.derf.ei.items.rods;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import com.derf.ei.util.EIVec3d;

public class EIItemRodMagnetism extends EIItemRod {

	protected static double strength = 0.3;
	protected static double range = 16.0;
	
	public EIItemRodMagnetism(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world,EntityPlayer player, EnumHand hand) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			if(stack.getTagCompound() == null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setBoolean("toggle", false);
				stack.setTagCompound(tag);
			}
			
			if(!player.isSneaking()) {
				this.toggle(stack);
				player.addChatMessage(new TextComponentString(String.format("%s: is %s", stack.getDisplayName(), ((isToggle(stack))? "on" : "off"))));
			} else {
				player.addChatMessage(new TextComponentString(String.format("%s: is %s", stack.getDisplayName(), ((isToggle(stack))? "on" : "off"))));
			}
		}
		
		return super.onItemRightClick(stack, world, player, hand);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world,
			Entity entity, int meta, boolean b) {
		// TODO Auto-generated method stub
		super.onUpdate(stack, world, entity, meta, b);
		
		if(stack.getTagCompound() == null) {
			NBTTagCompound tag = new NBTTagCompound();
			tag.setBoolean("toggle", false);
			stack.setTagCompound(tag);
		}
		
		
		if(this.isToggle(stack)) {
			this.onMagnetUpdate(stack, world, entity);
		}
	}

	protected void onMagnetUpdate(ItemStack stack, World world, Entity entity) {
		// TODO Auto-generated method stub
		AxisAlignedBB box = this.getBox(entity);
		ArrayList<Entity> list = this.getEntitiesWithinAABB(world, EntityItem.class, box);
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
		list = this.getEntitiesWithinAABB(world, EntityXPOrb.class, box);
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

	private void toggle(ItemStack stack) {
		// TODO Auto-generated method stub
		this.setToggle(stack, !this.isToggle(stack));
	}
	
	private boolean isToggle(ItemStack stack) {
		return stack.getTagCompound().getBoolean("toggle");
	}
	
	private void setToggle(ItemStack stack, boolean value) {
		stack.getTagCompound().setBoolean("toggle", value);
	}
	
	protected AxisAlignedBB getBox(Entity player) {
		AxisAlignedBB box = new AxisAlignedBB(
				player.posX - range,
				player.posY - range,
				player.posZ - range,
				player.posX + range,
				player.posY + range,
				player.posZ + range);
		return box;
	}
	
	protected ArrayList<Entity> getEntitiesWithinAABB(World world, Class cls, AxisAlignedBB box) {
		ArrayList<Entity> temp;
		temp = (ArrayList<Entity>)world.getEntitiesWithinAABB(cls, box);
		return temp;
	}
}
