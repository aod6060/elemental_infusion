package com.derf.ei.items.tools;

import net.minecraft.item.Item.ToolMaterial;

import com.derf.ei.items.vanilla.ItemPickaxe;
import com.derf.ei.items.vanilla.ToolAttributes;


public class EIItemPickaxe extends ItemPickaxe {

	public EIItemPickaxe(String name, ToolMaterial material) {
		super(new ToolAttributes(material, ToolAttributes.PICKAXE));
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}

}
