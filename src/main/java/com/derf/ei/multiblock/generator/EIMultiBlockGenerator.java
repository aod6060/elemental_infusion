package com.derf.ei.multiblock.generator;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.multiblock.EIMultiBlock;
import com.derf.ei.util.EIPosition;

/*
 * This is used to generator basic stuff such as 
 * cobblestone, sand, gravel, dirt, clay, netherrack,
 * soulsand, and endstone.
 */
public abstract class EIMultiBlockGenerator extends EIMultiBlock {
	
	private boolean testBlocks = false;
	
	private boolean findOutput = false;
	
	private Block basicBlock = null;
	
	private Block basicOutputBlock = null;
	
	private Block leftBlock = null;
	
	private Block rightBlock = null;
	
	private Item generated = null;
	
	private Block outputBlock = null;
	
	private EIPosition outputBlockPos = null;
	
	@Override
	public void update(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		super.update(world, x, y, z);
		
		if(isMultiBlockComplete(world, x, y, z)) {
			this.updateInventory(world);
		}
	}
	
	protected void updateInventory(World world) {
		int x = this.outputBlockPos.getX();
		int y = this.outputBlockPos.getY();
		int z = this.outputBlockPos.getZ();
		
		
		// Check 6 faces
		Block top = world.getBlock(x, y+1, z);
		
		if(top instanceof BlockContainer) {
			TileEntity entity = world.getTileEntity(x, y+1, z);
			
			if(entity instanceof IInventory) {
				IInventory inv = (IInventory)entity;
				
				int size = inv.getSizeInventory();
				
				for(int i = 0; i < size; i++) {
					if(inv.getStackInSlot(i) == null) {
						inv.setInventorySlotContents(i, new ItemStack(this.generated, 1));
						break;
					} else if(inv.getInventoryStackLimit() > inv.getStackInSlot(i).stackSize) {
						inv.getStackInSlot(i).stackSize += 1;
						break;
					}
				}
			}
		}
	}

	private ArrayList<Block> createBlockList(World world, ArrayList<EIPosition> position) {
		
		ArrayList<Block> temp = new ArrayList<Block>();
		
		for(int i = 0; i < position.size(); i++) {
			temp.add(world.getBlock(position.get(i).getX(), position.get(i).getY(), position.get(i).getZ()));
		}
		
		return temp;
	}
	
	private ArrayList<EIPosition> createPositionList(int x, int y, int z) {
		ArrayList<EIPosition> temp = new ArrayList<EIPosition>();
		
		temp.add(new EIPosition(x-1, y, z)); // Fire Iron Block
		temp.add(new EIPosition(x+1, y, z)); // Water Iron Block
		temp.add(new EIPosition(x-1, y, z-1));
		temp.add(new EIPosition(x-1, y, z+1));
		temp.add(new EIPosition(x-2, y, z));
		temp.add(new EIPosition(x-2, y, z-1));
		temp.add(new EIPosition(x-2, y, z+1));
		temp.add(new EIPosition(x+1, y, z-1));
		temp.add(new EIPosition(x+1, y, z+1));
		temp.add(new EIPosition(x+2, y, z));
		temp.add(new EIPosition(x+2, y, z-1));
		temp.add(new EIPosition(x+2, y, z+1));
		temp.add(new EIPosition(x, y, z-1));
		temp.add(new EIPosition(x, y, z+1));
		
		return temp;
	}
	
	private void printBlocks(ArrayList<Block> temp) {
		if(!testBlocks) {
			for(int i = 0; i < temp.size(); i++) {
				System.out.println("Unlocalizaed Name: " + temp.get(i).getUnlocalizedName());
			}
			
			testBlocks = true;
		}
	}
	
	private boolean checkForBasicBlock(ArrayList<Block> temp) {
		boolean b = true;
		
		for(int i = 2; i < temp.size(); i++) {
			//if(!EIBlocks.isVoidStone(temp.get(i))){
			
			if(!EIBlocks.isBlock(this.basicBlock, temp.get(i))) {
				//if(!EIBlocks.isVoidStoneItemOutput(temp.get(i))) {
				if(!EIBlocks.isBlock(this.basicOutputBlock, temp.get(i))) {
					b = false;
					break;
				}
			}
				//}
			//}
		}
		
		return b;
	}
	
	private boolean checkForBasicOutputBlock(ArrayList<Block> temp) {
		boolean b = false;
		
		for(int i = 2; i < temp.size(); i++) {
				
			//if(EIBlocks.isVoidStoneItemOutput(temp.get(i))) {
			if(EIBlocks.isBlock(this.basicOutputBlock, temp.get(i))) {
				b = true;
				break;
			}
			//}
		}
		
		return b;
	}
	
	private boolean checkForOneOutputBlock(ArrayList<Block> temp) {
		int num = 0;
		
		for(int i = 2; i < temp.size(); i++) {
			//if(EIBlocks.isVoidStoneItemOutput(temp.get(i))) {
			if(EIBlocks.isBlock(this.basicOutputBlock, temp.get(i))) {
				num += 1;
			}
			//}
		}
		
		return num == 1;
	}
	
	private void setOutputLocationBlock(ArrayList<EIPosition> p, ArrayList<Block> b) {
		for(int i = 2; i < p.size(); i++) {
			//if(EIBlocks.isVoidStoneItemOutput(b.get(i))) {
			if(EIBlocks.isBlock(this.basicOutputBlock, b.get(i))) {
				this.outputBlock = b.get(i);
				this.outputBlockPos = p.get(i);
				break;
			}
			//}
		}
	}
	
	protected boolean isMultiBlockComplete(World world, int x, int y, int z) {
		ArrayList<EIPosition> posList = this.createPositionList(x, y, z);
		ArrayList<Block> blockList = this.createBlockList(world, posList);
		
		boolean b = true;
		
		//printBlocks(blockList);
		
		if(!EIBlocks.isBlock(this.leftBlock, blockList.get(0))) {
			b = false;
		}
		
		if(!EIBlocks.isBlock(this.rightBlock, blockList.get(1))) {
			b = false;
		}
		
		if(b) {
			b = checkForBasicBlock(blockList);
		}
		
		if(b) {
			b = checkForBasicOutputBlock(blockList);
		}
		
		if(b) {
			b = checkForOneOutputBlock(blockList);
		}
		
		if(b) {
			this.setOutputLocationBlock(posList, blockList);
		}
		
		return b;
	}

	public void setBasicBlock(Block basicBlock) {
		this.basicBlock = basicBlock;
	}

	public void setBasicOutputBlock(Block basicOutputBlock) {
		this.basicOutputBlock = basicOutputBlock;
	}

	protected void setLeftBlock(Block leftBlock) {
		this.leftBlock = leftBlock;
	}
	
	protected void setRightBlock(Block rightBlock) {
		this.rightBlock = rightBlock;
	}

	protected void setGenerated(Block generated) {
		this.setGenerated(Item.getItemFromBlock(generated));
	}

	protected void setGenerated(Item generated) {
		this.generated = generated;
	}
}