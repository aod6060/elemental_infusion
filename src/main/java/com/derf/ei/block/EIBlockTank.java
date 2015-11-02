package com.derf.ei.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

import com.derf.ei.tileentity.EITileEntityTank;

/*
 * Tanks will have amounts
 *   32000    mb Void Level
 *  128000    mb Renforced Level
 * 1024000    mb Onmi Level
 */
public class EIBlockTank extends EIBlockContainer {

	public EIBlockTank(String name, int capacity) {
		super(name, Material.glass, 1.0f, 1.0f, "pickaxe", 0, soundTypeGlass);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new EITileEntityTank();
	}

	/*
	 * Used a little from GYTH
	 * Created By darkhax
	 * https://github.com/Darkhax-Minecraft/GYTH/blob/master/src/main/java/net/darkhax/gyth/common/blocks/BlockModularTank.java
	 * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, int, int, int, net.minecraft.entity.player.EntityPlayer, int, float, float, float)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float fx, float fy, float fz) {
		
		if(!world.isRemote) {
			ItemStack stack = player.inventory.getCurrentItem();
			
			if(stack != null) {
				FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(stack);
				EITileEntityTank tank = (EITileEntityTank)world.getTileEntity(x, y, z);
				
				if(liquid != null) {
					int amount = tank.fill(ForgeDirection.UNKNOWN, liquid, false);
					
					if(amount == liquid.amount) {
						tank.fill(ForgeDirection.UNKNOWN, liquid, true);
						
						if(!player.capabilities.isCreativeMode) {
							player.inventory.setInventorySlotContents(player.inventory.currentItem, useItem(stack));
						}
						
						return true;
					} else {
						return true;
					}
				} else if(FluidContainerRegistry.isBucket(stack)) {
					
					FluidTankInfo[] tanks = tank.getTankInfo(ForgeDirection.UNKNOWN);
					
					
					if(tanks[0] != null) {
						
						FluidStack fillFluid = tanks[0].fluid;
						ItemStack fillStack = FluidContainerRegistry.fillFluidContainer(fillFluid, stack);
						
						if(fillStack != null) {
							tank.drain(ForgeDirection.UNKNOWN, FluidContainerRegistry.getFluidForFilledItem(fillStack), true);
							
							if(!player.capabilities.isCreativeMode) {
								
								if(stack.stackSize == 1) {
									player.inventory.setInventorySlotContents(player.inventory.currentItem, fillStack);
								} else {
									player.inventory.setInventorySlotContents(player.inventory.currentItem, useItem(stack));
									
									if(!player.inventory.addItemStackToInventory(fillStack)) {
										System.out.println("Testing...");
										player.dropPlayerItemWithRandomChoice(fillStack, false);
									}
								}
								
								return true;
							} else {
								return true;
							}
						}
					}
				}
			}
			
			return false;
		} else {
			return true;
		}
	}

	public ItemStack useItem(ItemStack stack) {
		if(stack.stackSize == 1) {
			if(stack.getItem().hasContainerItem(stack)) {
				return stack.getItem().getContainerItem(stack);
			} else {
				return null;
			}
		} else {
			stack.splitStack(1);
			return stack;
		}
	}
	
	
	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x,
			int y, int z, boolean willHarvest) {
		// TODO Auto-generated method stub
		
		if(!player.capabilities.isCreativeMode) {
				EITileEntityTank tank = (EITileEntityTank) world.getTileEntity(x, y, z);
				NBTTagCompound compound = new NBTTagCompound();
				tank.writeToNBT(compound);
				ItemStack itemStack = new ItemStack(this, 1);
				/*
				if(tank.isEmpty()) {
					itemStack.setStackDisplayName(itemStack.getDisplayName() + "(Empty)");
				} else {
					FluidTankInfo info = tank.getTankInfo(ForgeDirection.UNKNOWN)[0];
					itemStack.setStackDisplayName(itemStack.getDisplayName() + "("+info.fluid.getLocalizedName()+": "+info.fluid.amount+"/"+info.capacity+")");
				}
				*/
				itemStack.setTagCompound(compound);
				world.spawnEntityInWorld(new EntityItem(world, x, y+1, z, itemStack));
		}
		
		return world.setBlockToAir(x, y, z);
	}

	@Override
	public void onBlockPlacedBy(World world, int x,int y, int z, EntityLivingBase entity, ItemStack stack) {
		
		if(!world.isRemote) {
			if(stack.hasTagCompound()) {
				EITileEntityTank tank = (EITileEntityTank)world.getTileEntity(x, y, z);
				
				if(tank != null) {
					NBTTagCompound tag = stack.getTagCompound();
					tank.readFromNBT(tag);
				}
			}
		}
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
