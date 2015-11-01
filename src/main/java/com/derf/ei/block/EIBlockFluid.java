package com.derf.ei.block;

import com.derf.ei.Main;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class EIBlockFluid extends BlockFluidClassic {
	public EIBlockFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		// TODO Auto-generated constructor stub
		this.setBlockName(name);
		this.setBlockTextureName(Main.MODID + ":" + name);
	}
}
