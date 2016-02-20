package com.derf.ei.crafting;

import java.util.ArrayList;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EIInfuserRecipe {
	private ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
	private ItemStack craftedItem;
	private String description;
	
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
	
	public void doCraft(IInventory inv, World world, BlockPos pos) {
		// Consumes Items
		for(int i = 0; i < size(); i++) {
			int s = itemStacks.get(i).stackSize;
			
			for(int j = 0; j < inv.getSizeInventory(); j++) {
				
				if(inv.getStackInSlot(j) != null) {
					if(inv.getStackInSlot(j).getItem() == itemStacks.get(i).getItem()) {
						int amount = s - inv.getStackInSlot(j).stackSize;
						
						
						inv.decrStackSize(j, s);
						
						if(amount <= 0) {
							break;
						}
						
						s = amount;
					}
				}
			}
		}
		
		// Add Item to inventory
		int i = 0;
		int left = 0;
		
		for(; i < inv.getSizeInventory(); i++) {
			
			
			if(left > 0) {
				if(inv.getStackInSlot(i) == null) {
					inv.setInventorySlotContents(i, new ItemStack(craftedItem.getItem(), left));
					break;
				}
				
				if(inv.getStackInSlot(i).getItem() == this.craftedItem.getItem() &&
				   inv.getStackInSlot(i).stackSize < inv.getInventoryStackLimit() &&
				   inv.getStackInSlot(i).stackSize < inv.getStackInSlot(i).getMaxStackSize()) {
					int amount = left;
					
					int addingStack = inv.getStackInSlot(i).stackSize + amount;
					
					left = addingStack - inv.getStackInSlot(i).getMaxStackSize();
					
					if(left <= 0) {
						inv.getStackInSlot(i).stackSize += amount;
						break;
					} else {
						inv.getStackInSlot(i).stackSize = inv.getStackInSlot(i).getMaxStackSize();
						continue;
					}
				}
			} else {
				if(inv.getStackInSlot(i) == null) {
					inv.setInventorySlotContents(i, this.craftedItem.copy());
					break;
				}
				
				if(inv.getStackInSlot(i).getItem() == this.craftedItem.getItem() &&
				   inv.getStackInSlot(i).stackSize < inv.getInventoryStackLimit() &&
				   inv.getStackInSlot(i).stackSize < inv.getStackInSlot(i).getMaxStackSize()) {
					
					int addingStack = inv.getStackInSlot(i).stackSize + craftedItem.stackSize;
					
					left = addingStack - inv.getStackInSlot(i).getMaxStackSize();
					
					if(left <= 0) {
						inv.getStackInSlot(i).stackSize += craftedItem.stackSize;
						break;
					} else {
						inv.getStackInSlot(i).stackSize = inv.getStackInSlot(i).getMaxStackSize();
						continue;
					}
				}
			}
		}
		
		
		// If there is now room in the chest
		
		if(i >= inv.getSizeInventory()) {
			if(left < 0) {
				world.spawnEntityInWorld(new EntityItem(world,pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(craftedItem.getItem(), left)));
			} else {
				world.spawnEntityInWorld(new EntityItem(world,pos.getX(), pos.getY() + 1, pos.getZ(), craftedItem.copy()));
			}
		}
	}
	
	public void setDescription(String name) {
		this.description = name;
	}
	
	public String getDescription() {
		return this.description;
	}
}
