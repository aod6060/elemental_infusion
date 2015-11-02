package com.derf.ei.handlers;

import net.minecraftforge.common.MinecraftForge;

public final class EIHandlers {
	public static void create() {
		MinecraftForge.EVENT_BUS.register(EIBucketHandler.INSTANCE);
	}
}
