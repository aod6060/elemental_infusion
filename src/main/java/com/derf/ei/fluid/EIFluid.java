package com.derf.ei.fluid;

import net.minecraftforge.fluids.Fluid;

public class EIFluid extends Fluid {

	public EIFluid(
			String fluidName, 
			int luminosity, 
			int density, 
			int temperature, 
			int viscosity,
			boolean isGaseous) {
		super(fluidName);
		// TODO Auto-generated constructor stub
		this.setLuminosity(luminosity);
		this.setDensity(density);
		this.setTemperature(temperature);
		this.setViscosity(viscosity);
		this.setGaseous(isGaseous);
	}

}
