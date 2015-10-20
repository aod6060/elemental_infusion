package com.derf.ei.block;

import com.derf.ei.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class EIBlock extends Block {

	public EIBlock(String name, Material material, float hardness, float res, String tool, int level, SoundType sound) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setBlockName(name);
		this.setBlockTextureName(Main.MODID + ":" + name);
		this.setHardness(hardness);
		this.setResistance(res);
		this.setHarvestLevel(tool, level);
		this.setStepSound(sound);
	}

}
