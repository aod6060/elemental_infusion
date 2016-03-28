package com.derf.ei.crafting;

import java.util.ArrayList;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.derf.ei.util.EIVec3d;

public class EIInfuserRecipe {
	private ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
	private ItemStack craftedItem;
	//private String description;
	
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
	
	public void doCraft(IInventory inv, World world, BlockPos pos, EntityPlayer player) {
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
		
		if(!player.inventory.addItemStackToInventory(craftedItem.copy())) {
			// Spits out item :)
			world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, craftedItem.copy()));
		}
	}
	
	private ItemStack createCraftingItem(int left) {
		// TODO Auto-generated method stub
		ItemStack stack = new ItemStack(this.craftedItem.getItem(), left, this.craftedItem.getItemDamage());
		return stack;
	}

	public String getDescription() {
		return "Crafting: " + craftedItem.getDisplayName();
	}
}
