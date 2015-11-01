package com.derf.ei.multiblock.itemvoid;

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

public class EIMultiBlockItemVoid extends EIMultiBlock {
	private final static float INTERVAL = 20.0f / 1000.0f;
	
	private boolean testBlocks = false;
	
	private boolean findOutput = false;
	
	private Block basicBlock = null;
	
	private Block basicInputBlock = null;
	
	private Block leftBlock = null;
	
	private Block rightBlock = null;
	
	private Block inputBlock = null;
	
	private EIPosition inputBlockPos = null;
	
	private float currentTime = 0.0f;
	
	private float maxTime;
	
	private int quantity;
	
	@Override
	public void update(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		super.update(world, x, y, z);
		
		if(isMultiBlockComplete(world, x, y, z)) {
			
			if(this.currentTime <= 0.0f) {
				this.updateInventory(world);
				this.currentTime = this.maxTime;
			} else {
				this.currentTime -= INTERVAL;
			}
		}
	}
	
	protected void updateInventory(World world) {
		int x = this.inputBlockPos.getX();
		int y = this.inputBlockPos.getY();
		int z = this.inputBlockPos.getZ();
		
		// Check 6 faces
		Block top = world.getBlock(x, y+1, z);
		
		if(top instanceof BlockContainer) {
			TileEntity entity = world.getTileEntity(x, y+1, z);
			
			if(entity instanceof IInventory) {
				IInventory inv = (IInventory)entity;
				
				int size = inv.getSizeInventory();
				
				for(int i = 0; i < size; i++) {
					if(inv.getStackInSlot(i) != null) {
						inv.decrStackSize(i, this.quantity);
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
				if(!EIBlocks.isBlock(this.basicInputBlock, temp.get(i))) {
					b = false;
					break;
				}
			}
				//}
			//}
		}
		
		return b;
	}
	
	private boolean checkForBasicInputBlock(ArrayList<Block> temp) {
		boolean b = false;
		
		for(int i = 2; i < temp.size(); i++) {
				
			//if(EIBlocks.isVoidStoneItemOutput(temp.get(i))) {
			if(EIBlocks.isBlock(this.basicInputBlock, temp.get(i))) {
				b = true;
				break;
			}
			//}
		}
		
		return b;
	}
	
	private boolean checkForOneInputBlock(ArrayList<Block> temp) {
		int num = 0;
		
		for(int i = 2; i < temp.size(); i++) {
			//if(EIBlocks.isVoidStoneItemOutput(temp.get(i))) {
			if(EIBlocks.isBlock(this.basicInputBlock, temp.get(i))) {
				num += 1;
			}
			//}
		}
		
		return num == 1;
	}
	
	private void setInputLocationBlock(ArrayList<EIPosition> p, ArrayList<Block> b) {
		for(int i = 2; i < p.size(); i++) {
			//if(EIBlocks.isVoidStoneItemOutput(b.get(i))) {
			if(EIBlocks.isBlock(this.basicInputBlock, b.get(i))) {
				this.inputBlock = b.get(i);
				this.inputBlockPos = p.get(i);
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
			b = checkForBasicInputBlock(blockList);
		}
		
		if(b) {
			b = checkForOneInputBlock(blockList);
		}
		
		if(b) {
			this.setInputLocationBlock(posList, blockList);
		}
		
		return b;
	}

	protected void setBasicBlock(Block basicBlock) {
		this.basicBlock = basicBlock;
	}

	protected void setBasicInputBlock(Block basicOutputBlock) {
		this.basicInputBlock = basicOutputBlock;
	}

	protected void setLeftBlock(Block leftBlock) {
		this.leftBlock = leftBlock;
	}
	
	protected void setRightBlock(Block rightBlock) {
		this.rightBlock = rightBlock;
	}

	public void setMaxTime(float maxTime) {
		this.maxTime = maxTime;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}