package com.derf.ei.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.derf.ei.EIType;
import com.derf.ei.tileentity.EITileEntityAirTotem;
import com.derf.ei.tileentity.EITileEntityEarthTotem;
import com.derf.ei.tileentity.EITileEntityFireTotem;
import com.derf.ei.tileentity.EITileEntityTotem;
import com.derf.ei.tileentity.EITileEntityWaterTotem;

public class EIBlockTotemHead extends EIBlockContainer {

	private EIType type;
	
	public EIBlockTotemHead(String name, Material material, float hardness,
			float res, String tool, int level, SoundType sound, EIType type) {
		super(name, material, hardness, res, tool, level, sound);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		
		if(type == EIType.FIRE) {
			return new EITileEntityFireTotem();
		} else if(type == EIType.WATER) {
			return new EITileEntityWaterTotem();
		} else if(type == EIType.AIR) {
			return new EITileEntityAirTotem();
		} else if(type == EIType.EARTH) {
			return new EITileEntityEarthTotem();
		} else {
			return null;
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int side, EntityPlayer player) {
		EITileEntityTotem totem = (EITileEntityTotem)world.getTileEntity(x, y, z);
		totem.changeBack(x, y, z);
	}

	
}
