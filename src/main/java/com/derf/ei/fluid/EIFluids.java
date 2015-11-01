package com.derf.ei.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public final class EIFluids {
	// Elemental Liquids
	public static Fluid fireDustFluid;
	public static Fluid waterDustFluid;
	public static Fluid airDustFluid;
	public static Fluid earthDustFluid;
	
	public static void create() {
		fireDustFluid = new EIFluid("liquid_fire_dust", 20, 1000, 1000, 100, false);
		waterDustFluid = new EIFluid("liquid_water_dust", 0, 1000, 20, 1000, false);
		airDustFluid = new EIFluid("liquid_air_dust", 0, -1, 300, 1500, false);
		earthDustFluid = new EIFluid("liquid_earth_dust", 0, 2000, 300, 10000, false);
		
		FluidRegistry.registerFluid(fireDustFluid);
		FluidRegistry.registerFluid(waterDustFluid);
		FluidRegistry.registerFluid(airDustFluid);
		FluidRegistry.registerFluid(earthDustFluid);
	}
}
