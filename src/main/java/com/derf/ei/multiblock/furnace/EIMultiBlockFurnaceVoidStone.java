package com.derf.ei.multiblock.furnace;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.util.EIPosition;

public class EIMultiBlockFurnaceVoidStone extends EIMultiBlockFurnace {
	public EIMultiBlockFurnaceVoidStone() {
		this.setMaxTime(0.2f);
		this.setBasicBlock(EIBlocks.voidStone);
		this.setBasicInputBlock(EIBlocks.voidStoneItemInput);
		this.setBasicOutputBlock(EIBlocks.voidStoneItemOutput);
		this.setFireBlock(EIBlocks.fireBlock);
	}
}
