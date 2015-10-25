package com.derf.ei.multiblock.furnace;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.derf.ei.block.EIBlocks;
import com.derf.ei.util.EIPosition;

public class EIMultiBlockFurnaceVoidStone extends EIMultiBlockFurnace {

	private boolean testPositions = false;
	private boolean testBlocks = false;
	
	private EIPosition inputPos = null;
	private Block inputBlock = null;
	
	private EIPosition outputPos = null;
	private Block outputBlock = null;
	
	@Override
	public void update(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		super.update(world, x, y, z);
		
		if(isMultiBlockComplete(world, x, y, z)) {
			//this.updateInventory(world);
			
			updateInventory(world);
		}
	}

	private void updateInventory(World world) {
		// TODO Auto-generated method stub
		int ix = inputPos.getX();
		int iy = inputPos.getY();
		int iz = inputPos.getZ();
		
		int ox = outputPos.getX();
		int oy = outputPos.getY();
		int oz = outputPos.getZ();
		
		IInventory inputInv = getInventory(world, ix, iy, iz);
		IInventory outputInv = getInventory(world, ox, oy, oz);
		
		
	}
	
	private ArrayList<EIPosition> getSidesPositionList(int x, int y, int z) {
		ArrayList<EIPosition> list = new ArrayList<EIPosition>();
		
		list.add(new EIPosition(x-1, y, z));
		list.add(new EIPosition(x+1, y, z));
		list.add(new EIPosition(x, y-1, z));
		list.add(new EIPosition(x, y+1, z));
		list.add(new EIPosition(x, y, z-1));
		list.add(new EIPosition(x, y, z+1));
		
		return list;
	}
	
	private IInventory getInventory(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		ArrayList<EIPosition> sides = this.getSidesPositionList(x, y, z);
		ArrayList<Block> blocks = this.createBlockList(world, sides);
		IInventory inventory = null;
		
		
		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i) instanceof BlockContainer) {
				TileEntity te = world.getTileEntity(sides.get(i).getX(), sides.get(i).getY(), sides.get(i).getZ());
				if(te instanceof IInventory) {
					inventory = (IInventory)te;
					break;
				}
			}
		}
		
		return inventory;
	}

	private ArrayList<EIPosition> createPositionList(int x, int y, int z) {
		ArrayList<EIPosition> temp = new ArrayList<EIPosition>();
		
		temp.add(new EIPosition(x, y+2, z)); // Fire Dust Block
		temp.add(new EIPosition(x, y+1, z)); // Air Block (No Block in middle)
		// First Level
		temp.add(new EIPosition(x-1, y, z));
		temp.add(new EIPosition(x+1, y, z));
		temp.add(new EIPosition(x, y, z-1));
		temp.add(new EIPosition(x, y, z+1));
		temp.add(new EIPosition(x-1, y, z-1));
		temp.add(new EIPosition(x+1, y, z-1));
		temp.add(new EIPosition(x+1, y, z+1));
		temp.add(new EIPosition(x-1, y, z+1));
		// Second Level
		temp.add(new EIPosition(x-1, y+1, z));
		temp.add(new EIPosition(x+1, y+1, z));
		temp.add(new EIPosition(x, y+1, z-1));
		temp.add(new EIPosition(x, y+1, z+1));
		temp.add(new EIPosition(x-1, y+1, z-1));
		temp.add(new EIPosition(x+1, y+1, z-1));
		temp.add(new EIPosition(x+1, y+1, z+1));
		temp.add(new EIPosition(x-1, y+1, z+1));
		// Third Level
		temp.add(new EIPosition(x-1, y+2, z));
		temp.add(new EIPosition(x+1, y+2, z));
		temp.add(new EIPosition(x, y+2, z-1));
		temp.add(new EIPosition(x, y+2, z+1));
		temp.add(new EIPosition(x-1, y+2, z-1));
		temp.add(new EIPosition(x+1, y+2, z-1));
		temp.add(new EIPosition(x+1, y+2, z+1));
		temp.add(new EIPosition(x-1, y+2, z+1));
		
		return temp;
	}
	
	private ArrayList<Block> createBlockList(World world, ArrayList<EIPosition> position) {
		
		ArrayList<Block> temp = new ArrayList<Block>();
		
		for(int i = 0; i < position.size(); i++) {
			temp.add(world.getBlock(position.get(i).getX(), position.get(i).getY(), position.get(i).getZ()));
		}
		
		return temp;
	}
	
	private void printBlocks(ArrayList<Block> temp) {
		if(!testBlocks) {
			System.out.println("Blocks");
			for(int i = 0; i < temp.size(); i++) {
				System.out.println("Unlocalizaed Name: " + temp.get(i).getUnlocalizedName());
			}
			
			testBlocks = true;
		}
	}
	
	private void printPositions(ArrayList<EIPosition> temp) {
		if(!testPositions) {
			System.out.println("Positions");
			for(int i = 0; i < temp.size(); i++) {
				System.out.println("Position [ "+temp.get(i).getX()+", "+temp.get(i).getY()+", "+temp.get(i).getZ()+"]");
			}
			
			testPositions = true;
		}
	}
		
	private boolean checkForBasicBlocks(ArrayList<Block> blockList) {
		// TODO Auto-generated method stub
		boolean b = true;
		
		for(int i = 2; i < blockList.size(); i++) {
			if(!EIBlocks.isVoidStone(blockList.get(i))) {
			   if(!EIBlocks.isVoidStoneItemInput(blockList.get(i))) {
				   if(!EIBlocks.isVoidStoneItemOutput(blockList.get(i))) {
					   b = false;
					   break;
				   }
			   }
			}
		}
		
		return b;
	}
	
	private boolean checkForBasicOutputBlock(ArrayList<Block> blockList) {
		boolean b = false;
		
		for(int i = 2; i < blockList.size(); i++) {
				
			if(EIBlocks.isVoidStoneItemOutput(blockList.get(i))) {
				b = true;
				break;
			}
		}
		
		return b;
	}

	private boolean checkForBasicInputBlock(ArrayList<Block> blockList) {
		boolean b = false;
		
		for(int i = 2; i < blockList.size(); i++) {
				
			if(EIBlocks.isVoidStoneItemInput(blockList.get(i))) {
				b = true;
				break;
			}
		}
		
		return b;
	}
	
	private boolean checkForOneInputBlock(ArrayList<Block> temp) {
		int num = 0;
		
		for(int i = 2; i < temp.size(); i++) {
			if(EIBlocks.isVoidStoneItemInput(temp.get(i))) {
				num += 1;
			}
		}
		
		return num == 1;
	}
	
	private boolean checkForOneOutputBlock(ArrayList<Block> temp) {
		int num = 0;
		
		for(int i = 2; i < temp.size(); i++) {
			if(EIBlocks.isVoidStoneItemOutput(temp.get(i))) {
				num += 1;
			}
		}
		
		return num == 1;
	}
	
	private void setPositionBlocks(ArrayList<EIPosition> p, ArrayList<Block> b) {
		/*for(int i = 2; i < p.size(); i++) {
			//if(EIBlocks.isVoidStoneItemOutput(b.get(i))) {
			if(EIBlocks.isBlock(this.basicOutputBlock, b.get(i))) {
				this.outputBlock = b.get(i);
				this.outputBlockPos = p.get(i);
				break;
			}
			//}
		}*/
		
		// Set Inputs
		for(int i = 2; i < p.size(); i++) {
			if(EIBlocks.isVoidStoneItemInput(b.get(i))) {
				this.inputBlock = b.get(i);
				this.inputPos = p.get(i);
				break;
			}
		}
		// Set Outputs
		for(int i = 2; i < p.size(); i++) {
			if(EIBlocks.isVoidStoneItemOutput(b.get(i))) {
				this.outputBlock = b.get(i);
				this.outputPos = p.get(i);
				break;
			}
		}
	}
	
	private boolean isMultiBlockComplete(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		boolean b = true;
		ArrayList<EIPosition> posList = this.createPositionList(x, y, z);
		ArrayList<Block> blockList = this.createBlockList(world, posList);
		
		this.printPositions(posList);
		this.printBlocks(blockList);
		
		if(!EIBlocks.isFireBlock(blockList.get(0))) {
			b = false;
		}
		
		if(!EIBlocks.isBlock(Blocks.air, blockList.get(1))) {
			b = false;
		}
		
		if(b) {
			b = checkForBasicBlocks(blockList);
		}
		
		if(b) {
			b = checkForBasicInputBlock(blockList);
		}
		
		if(b) {
			b = checkForBasicOutputBlock(blockList);
		}
		
		if(b) {
			b = this.checkForOneInputBlock(blockList);
		}
		
		if(b) {
			b = this.checkForOneOutputBlock(blockList);
		}
		
		if(b) {
			setPositionBlocks(posList, blockList);
		}
		
		return b;
	}
	
}
