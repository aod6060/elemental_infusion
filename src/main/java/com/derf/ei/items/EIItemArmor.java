package com.derf.ei.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class EIItemArmor extends ItemArmor {

	public EIItemArmor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
		super(material, renderIndex, armorType);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}
	
	
}
