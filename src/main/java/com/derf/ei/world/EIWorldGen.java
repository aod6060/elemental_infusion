package com.derf.ei.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.derf.ei.Main;
import com.derf.ei.block.EIBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class EIWorldGen implements IWorldGenerator {

	
	private WorldGenerator genFireOre;
	private WorldGenerator genWaterOre;
	private WorldGenerator genAirOre;
	private WorldGenerator genEarthOre;
	
	public EIWorldGen() {
		this.genFireOre = new WorldGenMinable(EIBlocks.fireOre, Main.fireOreVeinSize);
		this.genWaterOre = new WorldGenMinable(EIBlocks.waterOre, Main.waterOreVeinSize);
		this.genAirOre = new WorldGenMinable(EIBlocks.airOre, Main.airOreVeinSize);
		this.genEarthOre = new WorldGenMinable(EIBlocks.earthOre, Main.earthOreVeinSize);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
		
		switch(world.provider.dimensionId) {
		case 0:
			this.runGenerator(genFireOre, world, random, chunkX, chunkZ, Main.fireOreChances, Main.fireOreMin, Main.fireOreMax);
			this.runGenerator(genWaterOre, world, random, chunkX, chunkZ, Main.waterOreChances, Main.waterOreMin, Main.waterOreMax);
			this.runGenerator(genAirOre, world, random, chunkX, chunkZ, Main.airOreChances, Main.airOreMin, Main.airOreMax);
			this.runGenerator(genEarthOre, world, random, chunkX, chunkZ, Main.earthOreChances, Main.earthOreMin, Main.earthOreMax);
			break;
		case -1:
			break;
		case 1:
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chanceToSpawn, int minHeight, int maxHeight) {
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		}
		
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chanceToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int z = chunkZ * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			generator.generate(world, rand, x, y, z);
		}
	}
}
