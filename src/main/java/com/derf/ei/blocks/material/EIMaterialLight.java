package com.derf.ei.blocks.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class EIMaterialLight extends Material {

	public EIMaterialLight() {
		super(MapColor.airColor);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public boolean blocksLight() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean blocksMovement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCanBurn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MapColor getMaterialMapColor() {
		// TODO Auto-generated method stub
		return super.getMaterialMapColor();
	}

	@Override
	public int getMaterialMobility() {
		// TODO Auto-generated method stub
		return super.getMaterialMobility();
	}

	@Override
	public boolean isLiquid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpaque() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isReplaceable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSolid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isToolNotRequired() {
		// TODO Auto-generated method stub
		return super.isToolNotRequired();
	}

	@Override
	public Material setReplaceable() {
		// TODO Auto-generated method stub
		return super.setReplaceable();
	}

	
}
