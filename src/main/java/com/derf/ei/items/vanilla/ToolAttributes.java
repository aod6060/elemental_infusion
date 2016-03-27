package com.derf.ei.items.vanilla;

import java.util.Map;

import net.minecraft.item.Item.ToolMaterial;

import com.google.common.collect.Maps;

/**
 * This class is an enhancement to the ToolMaterial class. All
 * of my vanilla tool class is passed this rather than a 
 * ToolMaterial class due to the fact that ToolMaterial doesn't
 * have AttackSpeed implemented yet.
 * @author Fred
 *
 */
public class ToolAttributes {
	// Tool class to use with the Tools Attributes
	public static final String PICKAXE = "pickaxe";
	public static final String SHOVEL = "shovel";
	public static final String SWORD = "sword";
	public static final String AXE = "axe";
	public static final String HOE = "hoe";
	
	// This holds the tool's material from vanilla's code
	private ToolMaterial material = null;
	// This holds the attack speed of the tool
	private float attackSpeed = 0.0f;
	// This holds the actual damageVsEntity
	private float damageVsEntity = 0.0f;
	// Static Naming list for attack speeds
	private static Map<String, Float> toolsAttackSpeeds = Maps.newHashMap();
	// Static Naming list for damange vs entity
	private static Map<String, Float> toolsDamageVsEntity = Maps.newHashMap();
	/*
	 * 
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiencyOnProperMaterial;
        private final float damageVsEntity;
        private final int enchantability;
	 */
	static {
		// Tool Attack Speeds
		toolsAttackSpeeds.put("pickaxe", 2.0f);
		toolsAttackSpeeds.put("shovel", 0.5f);
		toolsAttackSpeeds.put("sword", 1.5f);
		toolsAttackSpeeds.put("axe", 2.5f);
		toolsAttackSpeeds.put("hoe", 1.5f);
		// Tool Damange Vs Entity
		toolsDamageVsEntity.put("pickaxe", 3.0f);
		toolsDamageVsEntity.put("shovel", 2.5f);
		toolsDamageVsEntity.put("sword", 4.0f);
		toolsDamageVsEntity.put("axe", 5.0f);
		toolsDamageVsEntity.put("hoe", 3.5f);
	}
	
	public ToolAttributes(ToolMaterial material, String toolClass) {
		// Set Material
		this.material = material;
		
		this.attackSpeed = caculateAttackSpeed(toolClass);
		this.damageVsEntity = caculateDamageVsEntity(toolClass);
	}
	
	private float caculateDamageVsEntity(String toolClass) {
		// TODO Auto-generated method stub
		float attack = toolsDamageVsEntity.get(toolClass);
		return material.getDamageVsEntity() * attack;
	}

	private float caculateAttackSpeed(String toolClass) {
		// TODO Auto-generated method stub
		float speed = toolsAttackSpeeds.get(toolClass);
		return -(speed + (1.0f - (material.getEfficiencyOnProperMaterial() / ToolMaterial.DIAMOND.getEfficiencyOnProperMaterial())));
	}

	public int getHarvestLevel() {
		return material.getHarvestLevel();
	}
	
	public int getMaxUses() {
		return material.getMaxUses();
	}
	
	public float getEfficiencyOnProperMaterial() {
		return material.getEfficiencyOnProperMaterial();
	}
	
	public float getDamageVsEntity() {
		return this.damageVsEntity;
	}
	
	public int getEnchantablitlity() {
		return material.getEnchantability();
	}
	
	public float getAttackSpeed() {
		return this.attackSpeed;
	}
	
	public ToolMaterial getToolMaterial() {
		return this.material;
	}
}
