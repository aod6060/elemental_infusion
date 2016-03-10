package com.derf.ei.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class EIBlockBasic extends Block {

	public EIBlockBasic(
			Material material, 
			String name, 
			String tool, 
			int tool_level, 
			float hardness, 
			float resistance, 
			float lightLevel, 
			boolean unbreaking) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setHarvestLevel(tool, tool_level);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(lightLevel);
		if(unbreaking) {
			this.setBlockUnbreakable();
		}
	}

}
