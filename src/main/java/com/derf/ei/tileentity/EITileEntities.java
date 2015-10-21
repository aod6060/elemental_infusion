package com.derf.ei.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public final class EITileEntities {
	public static void create() {
		GameRegistry.registerTileEntity(EITileEntityMachineCore.class, "tile_entity_machine_core");
	}
}
