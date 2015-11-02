package com.derf.ei.item;

import com.derf.ei.Main;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class EIItemBucket extends ItemBucket {

	public EIItemBucket(String name, Block block) {
		super(block);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + name);
		this.setContainerItem(Items.bucket);
	}

}
