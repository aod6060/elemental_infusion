package com.derf.ei.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.derf.ei.EILoader;

public final class EIRendererRegister {
	
	public static void register(Block block, String name) {
		register(block, 0, name);
	}
	
	public static void register(Item item, String name) {
		register(item, 0, name);
	}
	
	public static void register(Block block, int meta, String name) {
		register(Item.getItemFromBlock(block), meta, name);
	}
	
	public static void register(Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(EILoader.modid + ":" + name, "inventory"));
	}
	
	public static void addVariant(Block block, String... args) {
		addVariant(Item.getItemFromBlock(block), args);
	}
	
	public static void addVariant(Item item, String... args) {
		
		ResourceLocation[] rls = new ResourceLocation[args.length];
		
		for(int i = 0; i < rls.length; i++) {
			rls[i] = new ResourceLocation(EILoader.modid + ":" + args[i]);
		}
		
		if(rls.length > 0) {
			ModelBakery.registerItemVariants(item, rls);
		}
	}
}
