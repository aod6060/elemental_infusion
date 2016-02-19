package com.derf.ei.creativetabs;

import com.derf.ei.items.EIItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public final class EICreativeTabs {
	
	public static CreativeTabs tabEI;
	
	public static void create() {
		tabEI = new CreativeTabs("tabEI") {

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return EIItems.fireDust;
			}
			
		};
	}
}
