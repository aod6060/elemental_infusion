package com.derf.ei.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class EIRendererRegister {
	
	public static void register(Block block, int meta, String name) {
		register(Item.getItemFromBlock(block), meta, name);
	}
	
	public static void register(Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(name, "inventory"));
	}
	
}
