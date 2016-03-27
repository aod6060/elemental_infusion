package com.derf.ei.items.tools;

import com.derf.ei.items.vanilla.ItemHoe;
import com.derf.ei.items.vanilla.ToolAttributes;


public class EIItemHoe extends ItemHoe {

	public EIItemHoe(String name, ToolMaterial material) {
		super(new ToolAttributes(material, ToolAttributes.HOE));
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}

}
