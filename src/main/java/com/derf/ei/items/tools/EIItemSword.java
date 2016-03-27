package com.derf.ei.items.tools;

import com.derf.ei.items.vanilla.ItemSword;
import com.derf.ei.items.vanilla.ToolAttributes;


public class EIItemSword extends ItemSword {

	public EIItemSword(String name, ToolMaterial material) {
		super(new ToolAttributes(material, ToolAttributes.SWORD));
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}

}
