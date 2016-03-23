package com.derf.ei.handler;

import net.minecraftforge.common.MinecraftForge;

public class EIHandlers {
	
	public static EIGuiOverlayElementalInfuserCraftingHandler craftingOverlay = new EIGuiOverlayElementalInfuserCraftingHandler();
	
	public static void create() {
		MinecraftForge.EVENT_BUS.register(EIHandlers.craftingOverlay);
	}
}
