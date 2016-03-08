package com.derf.ei.items.rods;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

abstract public class EIItemRod extends Item {
	
	public EIItemRod(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
}
