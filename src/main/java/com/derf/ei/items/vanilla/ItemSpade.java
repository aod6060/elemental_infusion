package com.derf.ei.items.vanilla;


import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import com.google.common.collect.Sets;


public class ItemSpade extends ItemTool {
	
	// Material
	//private final ToolMaterial material;
	private ToolAttributes attributes;
	// Set<Block>
	private static final Set<Block> effectedBlocks = Sets.newHashSet(new Block[] {Blocks.clay, Blocks.dirt, Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand, Blocks.grass_path});
	
	public ItemSpade(ToolAttributes attributes) {
		super(attributes.getToolMaterial(), effectedBlocks);
		this.attributes = attributes;
		this.setHarvestLevel("shovel", attributes.getHarvestLevel());
		// Damage
		this.damageVsEntity = attributes.getDamageVsEntity();
		// Speed
		this.attackSpeed = attributes.getAttackSpeed();
	}
	
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		
		if(!player.canPlayerEdit(pos.offset(facing), facing, stack)) {
			return EnumActionResult.FAIL;
		} else {
			/*
			 * This might be a hook into the forge so I'm adding it here.
			 * int hook = ForgeEventFactory.onSpadeUse(stack, player, world, pos);
			 * if(hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
			 */
			IBlockState state = world.getBlockState(pos);
			Block block = state.getBlock();
			
			if(facing != EnumFacing.DOWN && world.getBlockState(pos.up()).getMaterial() == Material.air && block == Blocks.grass) {
				
				world.playSound(player, pos, SoundEvents.item_shovel_flatten, SoundCategory.BLOCKS, 1.0f, 1.0f);
				
				if(!world.isRemote) {
					world.setBlockState(pos, Blocks.grass_path.getDefaultState());
					stack.damageItem(1, player);
				}
				
				return EnumActionResult.SUCCESS;
			} else {
				return EnumActionResult.PASS;
			}
		}
		
		
	}


	private boolean checkStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		
		boolean b = false;
		
		Iterator<Block> it = effectedBlocks.iterator();
		
		while(it.hasNext()) {
			if(it.next() == state.getBlock()) {
				b = true;
				break;
			}
		}
		
		return b ||
				(((state.getBlock().getHarvestTool(state) != null && state.getBlock().getHarvestTool(state).equals("shovel"))? true : false) && state.getBlock().getHarvestLevel(state) <= this.attributes.getHarvestLevel());
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		// TODO Auto-generated method stub
		return (!this.checkStrVsBlock(stack, state))? super.getStrVsBlock(stack, state) : attributes.getEfficiencyOnProperMaterial();
	}
	
	
}
