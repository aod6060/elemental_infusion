package com.derf.ei.items.vanilla;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class ItemSword extends Item{
	private ToolAttributes attributes;
	
	public ItemSword(ToolAttributes attributes) {
		this.attributes = attributes;
		this.maxStackSize = 1;
		this.setMaxDamage(attributes.getMaxUses());
	}
	
	public float getDamageVsEntity() {
		return attributes.getToolMaterial().getDamageVsEntity();
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		// TODO Auto-generated method stub
		
		if(state.getBlock() == Blocks.web) {
			return attributes.getEfficiencyOnProperMaterial();
		} else {
			Material material = state.getMaterial();
			return (material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd)? 1.0f : attributes.getEfficiencyOnProperMaterial() * 0.5f;
		}
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		return true;
	}
	

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world,IBlockState block, BlockPos pos, EntityLivingBase entityLiving) {
		// TODO Auto-generated method stu
		
		// block.getBlockHardness(world, pos) != 0.0f bad, because of float point rounding issues >:( . Naughty Mojang
		if(block.getBlockHardness(world, pos) > 0.0f) {
			stack.damageItem(1, entityLiving);
		}
		
		return true;
	}
	
	
	@Override
	public boolean canHarvestBlock(IBlockState state) {
		// TODO Auto-generated method stub
		return state.getBlock() == Blocks.web;
	}

	
	@Override
	public int getItemEnchantability() {
		// TODO Auto-generated method stub
		return this.attributes.getEnchantablitlity();
	}

	public String getToolMaterialName() {
		return attributes.getToolMaterial().toString();
	}
	
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		// TODO Auto-generated method stub
		boolean temp = false;
		ItemStack mat = this.attributes.getToolMaterial().getRepairItemStack();
		if(mat != null && OreDictionary.itemMatches(mat, repair, false)) {
			temp = true;
		}
		return temp;
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
}
