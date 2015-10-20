package com.derf.ei.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public final class EITileEntities {
	public static void create() {
		GameRegistry.registerTileEntity(EITileEntityFireTotem.class, "ei_tileentity_fire_totem");
		GameRegistry.registerTileEntity(EITileEntityWaterTotem.class, "ei_tileentity_water_totem");
		GameRegistry.registerTileEntity(EITileEntityAirTotem.class, "ei_tileentity_air_totem");
		GameRegistry.registerTileEntity(EITileEntityEarthTotem.class, "ei_tileentity_earth_totem");
	}
}
