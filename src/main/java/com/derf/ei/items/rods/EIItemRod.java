package com.derf.ei.items.rods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

abstract public class EIItemRod extends Item {
	
	public EIItemRod(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}

	@Override
	public void onUpdate(ItemStack stack, World world,
			Entity entity, int i, boolean b) {
		// TODO Auto-generated method stub
		super.onUpdate(stack, world, entity, i, b);
		
		if(entity instanceof EntityPlayer) {
			this.onCreateNBT(stack, world, (EntityPlayer)entity);
		}
	}
	
	protected void onCreateNBT(ItemStack stack, World world, EntityPlayer entity) {}
}
