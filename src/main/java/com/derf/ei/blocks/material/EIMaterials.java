package com.derf.ei.blocks.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public final class EIMaterials {
	
	public static Material light;
	
	public static void create() {
		// Material Light
		light = new EIMaterialLight();
	}
}
