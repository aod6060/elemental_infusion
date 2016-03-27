package com.derf.ei.items.vanilla;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

public class ItemPickaxe extends ItemTool {
	
	// Tool Material
	//private final ToolMaterial material;
	private ToolAttributes attributes;
	// Set<Block> blocks
	private static final Set<Block> effectedBlocks = Sets.newHashSet(new Block[] {Blocks.activator_rail, Blocks.coal_block, Blocks.coal_block, Blocks.cobblestone, Blocks.detector_rail, Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block, Blocks.gold_ore, Blocks.ice, Blocks.iron_block, Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.redstone_ore, Blocks.sandstone, Blocks.red_sandstone, Blocks.stone, Blocks.stone_slab, Blocks.stone_button, Blocks.stone_pressure_plate});
	
	public ItemPickaxe(ToolAttributes attributes) {
		super(attributes.getToolMaterial(), effectedBlocks);
		this.attributes = attributes;
		// Set Tool Class
		this.setHarvestLevel("pickaxe", attributes.getHarvestLevel());
		// Damage
		this.damageVsEntity = attributes.getDamageVsEntity();
		// Speed
		this.attackSpeed = attributes.getAttackSpeed();
	}

	private boolean checkStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		
		
		return material == Material.iron ||
			   material == Material.anvil ||
			   material == Material.rock ||
			   (((state.getBlock().getHarvestTool(state) != null && state.getBlock().getHarvestTool(state).equals("pickaxe"))? true : false) && state.getBlock().getHarvestLevel(state) <= this.attributes.getHarvestLevel());
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		// TODO Auto-generated method stub
		return (!this.checkStrVsBlock(stack, state))? super.getStrVsBlock(stack, state) : attributes.getEfficiencyOnProperMaterial();
	}
	
	
}
