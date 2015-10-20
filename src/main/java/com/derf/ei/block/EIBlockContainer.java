package com.derf.ei.block;

import com.derf.ei.Main;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;

public abstract class EIBlockContainer extends BlockContainer {
	public EIBlockContainer(String name, Material material, float hardness, float res, String tool, int level, SoundType sound) {
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
