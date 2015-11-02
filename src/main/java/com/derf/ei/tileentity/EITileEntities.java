package com.derf.ei.tileentity;

import com.derf.ei.handlers.EIBucketHandler;

import cpw.mods.fml.common.registry.GameRegistry;

public final class EITileEntities {
	public static void create() {
		GameRegistry.registerTileEntity(EITileEntityMachineCore.class, "tile_entity_machine_core");
		GameRegistry.registerTileEntity(EITileEntityTank.class, "tile_entity_tank");
	}
}
