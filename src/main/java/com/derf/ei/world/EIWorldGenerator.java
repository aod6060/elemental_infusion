package com.derf.ei.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.derf.ei.blocks.EIBlocks;

public class EIWorldGenerator implements IWorldGenerator {

	private WorldGenerator genFireOre;
	private WorldGenerator genWaterOre;
	private WorldGenerator genEarthOre;
	private WorldGenerator genWindOre;
	
	public EIWorldGenerator() {
		this.genFireOre = new WorldGenMinable(EIBlocks.fireOre.getDefaultState(), 8);
		this.genWaterOre = new WorldGenMinable(EIBlocks.waterOre.getDefaultState(), 8);
		this.genEarthOre = new WorldGenMinable(EIBlocks.earthOre.getDefaultState(), 8);
		this.genWindOre = new WorldGenMinable(EIBlocks.windOre.getDefaultState(), 8);
	}
	
	@Override
	public void generate(
			Random random, 
			int chunkX, 
			int chunkZ, 
			World world,
			IChunkGenerator chunkGenerator, 
			IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
		switch(world.provider.getDimension()) {
		case 0:
			this.runGenerator(genFireOre, world, random, chunkX, chunkZ, 8, 5, 35);
			this.runGenerator(genWaterOre, world, random, chunkX, chunkZ, 8, 5, 35);
			this.runGenerator(genEarthOre, world, random, chunkX, chunkZ, 8, 5, 35);
			this.runGenerator(genWindOre, world, random, chunkX, chunkZ, 8, 5, 35);
			break;
		case -1:
			break;
		case 1:
			break;
		}
	}
	
	private void runGenerator(
			WorldGenerator g, 
			World world, 
			Random rand, 
			int chunkX, 
			int chunkZ, 
			int chanceToSpawn, 
			int minHeight, 
			int maxHeight) {
		
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
			throw new IllegalArgumentException("Illegal Height Argument for EIWorldGenerator");
		}
		
		int hdt = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chanceToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int z = chunkZ * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(hdt);
			g.generate(world, rand, new BlockPos(x, y, z));
		}
	}


}
