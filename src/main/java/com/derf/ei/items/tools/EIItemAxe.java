package com.derf.ei.items.tools;

import com.derf.ei.items.vanilla.ItemAxe;
import com.derf.ei.items.vanilla.ToolAttributes;

public class EIItemAxe extends ItemAxe {

	public EIItemAxe(String name, ToolMaterial material) {
		super(new ToolAttributes(material, ToolAttributes.AXE));
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
	}

	
}
