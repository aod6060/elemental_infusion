package com.derf.ei.items.vanilla;

import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class ItemHoe extends Item {
	private ToolAttributes attributes;
	
	private static Set<Block> effectedBlocks = Sets.newHashSet(new Block[] {Blocks.dirt, Blocks.grass, Blocks.grass_path});
	
	public ItemHoe(ToolAttributes attributes) {
		this.attributes = attributes;
		this.setMaxStackSize(1);
		this.setMaxDamage(attributes.getMaxUses());
	}

	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!player.canPlayerEdit(pos, facing, stack)) {
			return EnumActionResult.FAIL;
		} else {
			int hook = ForgeEventFactory.onHoeUse(stack, player, world, pos);
			
			if(hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
			
			IBlockState state = world.getBlockState(pos);
			
			if(facing != EnumFacing.DOWN && world.isAirBlock(pos.up())) {
				if(this.checkForCorrectBlock(state)) {
					IBlockState new_state = null;
					
					if(state.getBlock() == Blocks.dirt) {
						BlockDirt.DirtType dirtType = state.getValue(BlockDirt.VARIANT);
						
						if(dirtType == BlockDirt.DirtType.COARSE_DIRT) {
							new_state = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT);
						} else {
							new_state = Blocks.farmland.getDefaultState();
						}
					} else {
						new_state = Blocks.farmland.getDefaultState();
					}
					
					world.playSound(player, pos, SoundEvents.item_hoe_till, SoundCategory.BLOCKS, 1.0f, 1.0f);
					
					if(!world.isRemote) {
						world.setBlockState(pos, new_state);
						stack.damageItem(1, player);
					}
					
					return EnumActionResult.SUCCESS;
				} else {
					return EnumActionResult.PASS;
				}
			} else {
				return EnumActionResult.PASS;
			}
		}
	}


	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		// TODO Auto-generated method stub
		stack.damageItem(1, attacker);
		return true;
	}
	
	public String getToolMaterialName() {
		return attributes.getToolMaterial().toString();
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(
			EntityEquipmentSlot slot, ItemStack stack) {
		// TODO Auto-generated method stub
		
		Multimap<String, AttributeModifier> attributes = HashMultimap.<String, AttributeModifier>create();
		
		if(slot == EntityEquipmentSlot.MAINHAND) {
			attributes.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attributes.getDamageVsEntity(), 0));
			attributes.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attributes.getAttackSpeed(), 0));
		}
		
		return attributes;
	}
	
	protected boolean checkForCorrectBlock(IBlockState state) {
		
		boolean temp = false;
		
		Iterator<Block> it = effectedBlocks.iterator();
		
		while(it.hasNext()) {
			if(state.getBlock() == it.next()) {
				temp = true;
				break;
			}
		}
		
		return temp;
		
	}
	
	
}
