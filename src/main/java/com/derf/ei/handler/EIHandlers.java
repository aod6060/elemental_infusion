package com.derf.ei.handler;

import net.minecraftforge.common.MinecraftForge;

public class EIHandlers {
	
	public static void create() {
		MinecraftForge.EVENT_BUS.register(new EIGuiOverlayHandler());
	}
}
