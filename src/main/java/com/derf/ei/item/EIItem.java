package com.derf.ei.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.derf.ei.EIType;
import com.derf.ei.Main;
import com.derf.ei.block.EIBlockVoidStone;
import com.derf.ei.block.EIBlocks;

public class EIItem extends Item {
	public EIItem(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + name);
	}
}
