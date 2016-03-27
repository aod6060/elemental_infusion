package com.derf.ei.items.vanilla;

import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * This is an implementation of the ItemAxe. This class was created
 * due to a bug in ItemAxe that results in an "Array out of Bound"
 * exception in the constructor. 
 * 
 * Note: You don't need permission from me to use this code. Just use it
 * if your having the same problem I'm having. :)
 * @author derf6060
 */
public class ItemAxe extends ItemTool {
	// A holder object for the tool material
	//private ToolMaterial material = null;
	private ToolAttributes attribute;
	// This is a list of 
	private static final Set<Block> effectedBlocks = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder, Blocks.wooden_button, Blocks.wooden_pressure_plate});
    /**
	 * This initializes the ItemAxeCustom object.
	 * @param ToolMaterial material
	 */
	public ItemAxe(ToolAttributes attributes) {
		super(attributes.getToolMaterial(), effectedBlocks);
		this.setHarvestLevel("axe", attributes.getHarvestLevel());
		
		// These are the values from ATTACK_DAMAGE array: 6.0F, 8.0F, 8.0F, 8.0F, 6.0F
		this.damageVsEntity = attributes.getDamageVsEntity();
		// These are the values from ATTACK_SPEED array: -3.2F, -3.2F, -3.1F, -3.0F, -3.0F
		this.attackSpeed = attributes.getAttackSpeed();
	}

	/**
	 * This check if the block can be mined by the custom axe
	 * @param ItemStack stack
	 * @param IBlockState state
	 * @return
	 */
	private boolean checkStrVsBlock(ItemStack stack, IBlockState state) {
		// Check Materials
		Material material = state.getMaterial();
		
		// Added in harvest tool and harvest level
		return material == Material.wood || 
			   material == Material.plants || 
			   material == Material.vine || 
			   (((state.getBlock().getHarvestTool(state) != null && state.getBlock().getHarvestTool(state).equals("axe"))? true : false) && state.getBlock().getHarvestLevel(state) <= this.attribute.getHarvestLevel());
	}
	
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		// TODO Auto-generated method stub
		return (!checkStrVsBlock(stack, state))? super.getStrVsBlock(stack, state) : this.attribute.getEfficiencyOnProperMaterial();
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		// TODO Auto-generated method stub
		//return super.getAttributeModifiers(slot, stack);
		
		HashMultimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
		
		if(slot == EntityEquipmentSlot.MAINHAND) {
			float damage = this.damageVsEntity;
			
			float speed = this.attackSpeed;
			
			Random rand = new Random();
			
			if(rand.nextInt(10) == 0) {
				damage *= 2.0f;
			}
			
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.damageVsEntity, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, 0));
		}
		return multimap;
	}
	
	
}
