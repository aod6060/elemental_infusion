package com.derf.ei.crafting;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class EIInfuserRecipe {
	public ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
	public ItemStack craftedItem;
	
	public int size() {
		return itemStacks.size();
	}
	
	public ItemStack get(int i) {
		return itemStacks.get(i);
	}
	
	public void add(ItemStack stack) {
		itemStacks.add(stack);
	}
	
	public void clear() {
		itemStacks.clear();
	}
	
	public void setCraftedItem(ItemStack stack) {
		this.craftedItem = stack;
	}
	
	public ItemStack getCraftedItem() {
		return this.craftedItem;
	}
	
	public boolean checkInventory(IInventory inv) {
		boolean b = true;
		
		for(int i = 0; i < size(); i++) {
			int j = 0;
			int s = itemStacks.get(i).stackSize;
			
			for(; j < inv.getSizeInventory(); j++) {
				
				if(inv.getStackInSlot(j) != null) {
					if(inv.getStackInSlot(j).getItem() == itemStacks.get(i).getItem()) {
						s -= inv.getStackInSlot(j).stackSize;
						if(s <= 0) {
							break;
						}
					}
				}
			}
			
			if(j >= inv.getSizeInventory()) {
				b = false;
				break;
			}
		}
		
		return b;
	}
}
