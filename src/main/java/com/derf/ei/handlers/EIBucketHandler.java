package com.derf.ei.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.IFluidHandler;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Reference some stuff from OpenModLib
 * https://github.com/OpenMods/OpenModsLib/blob/master/src/main/java/openmods/liquids/BucketFillHandler.java
 * 
 * 
 * @author Fred
 *
 */
public class EIBucketHandler {
	public static EIBucketHandler INSTANCE = new EIBucketHandler();
	
	public Map<Block, Item> buckets = new HashMap<Block, Item>();
	
	private EIBucketHandler() {}
	
	public void registerBucket(Block k, Item i) {
		buckets.put(k, i);
	}
	
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {
		if(!event.world.isRemote) {
			if(event.getResult() != Result.DEFAULT) {
				return;
			}
			
			ItemStack result = fillCustomBucket(event.world, event.target);
			
			System.out.println("Hello, World");
			
			if(result == null)
				return;
			
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}
	
	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {
		
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
		
		Item bucket = buckets.get(block);
		
		if(bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else {
			return null;
		}
		
	}
	
}
