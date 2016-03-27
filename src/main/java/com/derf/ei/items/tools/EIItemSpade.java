package com.derf.ei.items.tools;

import com.derf.ei.items.vanilla.ItemSpade;
import com.derf.ei.items.vanilla.ToolAttributes;

public class EIItemSpade extends ItemSpade {

	public EIItemSpade(String name, ToolMaterial material) {
		super(new ToolAttributes(material, ToolAttributes.SHOVEL));
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}

}
