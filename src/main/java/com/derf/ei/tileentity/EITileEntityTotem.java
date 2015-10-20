package com.derf.ei.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.derf.ei.block.EIBlocks;

public abstract class EITileEntityTotem extends TileEntity {
	//private Block[] blocks = new Block[10];
	public static final float TIME_DELTA = 20.0f / 1000.0f;
	
	private TotumBlock[] tbs = new TotumBlock[8];
	
	float test = 0.0f;
	
	class TotumBlock {
		private int x;
		private int y;
		private int z;
		private float currentTime = -1.0f;
			
		public TotumBlock(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public int getZ() {
			return z;
		}
		
		
		public float getCurrentTime() {
			return currentTime;
		}


		public void setCurrentTime(float currentTime) {
			if(this.currentTime <= 0.0f) {
				this.currentTime = currentTime;
			}
		}
		
		public boolean decrementTime() {
			this.currentTime -= TIME_DELTA;
			boolean ret = false;
			
			//System.out.println("Time is: " + this.currentTime);
			
			if(this.currentTime <= 0.0f) {
				ret = true;
			}
			
			return ret;
		}
		
		public boolean isIronBlock() {
			Block block = worldObj.getBlock(x, y, z);
			return block.getUnlocalizedName().equals("tile.blockIron");
		}

		public void readFromNTB(NBTTagList list, int i) {
			// TODO Auto-generated method stub
			NBTTagCompound temp = list.getCompoundTagAt(i);
			
			this.x = temp.getInteger("x");
			this.y = temp.getInteger("y");
			this.z = temp.getInteger("z");
			this.currentTime = temp.getFloat("current_time");
		}

		public void writeToNTB(NBTTagList list) {
			// TODO Auto-generated method stub
			NBTTagCompound temp = new NBTTagCompound();
			temp.setInteger("x", this.getX());
			temp.setInteger("y", this.getY());
			temp.setInteger("z", this.getZ());
			temp.setFloat("current_time", this.getCurrentTime());
			list.appendTag(temp);
		}
	}
	
	@Override
	public void updateEntity() {
		// TODO Auto-generated method stub
		super.updateEntity();
		this.checkMultiBlock();
		this.updateOreBlocks();
		
	}
	
	protected void checkMultiBlock() {
		boolean isMultiBlock = true;
		Block[] blocks = new Block[10];
		
		blocks[0] = worldObj.getBlock(this.xCoord, this.yCoord-1, this.zCoord);
		blocks[1] = worldObj.getBlock(this.xCoord, this.yCoord-2, this.zCoord);
		blocks[2] = worldObj.getBlock(this.xCoord-1, this.yCoord-2, this.zCoord);
		blocks[3] = worldObj.getBlock(this.xCoord+1, this.yCoord-2, this.zCoord);
		blocks[4] = worldObj.getBlock(this.xCoord, this.yCoord-2, this.zCoord-1);
		blocks[5] = worldObj.getBlock(this.xCoord, this.yCoord-2, this.zCoord+1);
		blocks[6] = worldObj.getBlock(this.xCoord-1, this.yCoord-2, this.zCoord-1);
		blocks[7] = worldObj.getBlock(this.xCoord+1, this.yCoord-2, this.zCoord-1);
		blocks[8] = worldObj.getBlock(this.xCoord+1, this.yCoord-2, this.zCoord+1);
		blocks[9] = worldObj.getBlock(this.xCoord-1, this.yCoord-2, this.zCoord+1);
		
		for(int i = 0; i < blocks.length; i++) {
			
			if(!isVoidStoneTotem(blocks[i])) {
				isMultiBlock = false;
				break;
			}
		}
		
		
		if(!isMultiBlock) {
			changeBack(xCoord, yCoord, zCoord);
		} else {
			changeTo(xCoord, yCoord, zCoord);
		}
	}
	


	protected boolean isVoidStoneTotem(Block block) {
		return block.getUnlocalizedName().equals("tile.totum") || block.getUnlocalizedName().equals("tile.void_stone");
	}
	
	protected boolean isTotem(Block block) {
		return block.getUnlocalizedName().equals("tile.totum");
	}
	
	public void changeBack(int x, int y, int z) {
		Block[] blocks = new Block[10];
		
		blocks[0] = worldObj.getBlock(x, y-1, z);
		blocks[1] = worldObj.getBlock(x, y-2, z);
		blocks[2] = worldObj.getBlock(x-1, y-2, z);
		blocks[3] = worldObj.getBlock(x+1, y-2, z);
		blocks[4] = worldObj.getBlock(x, y-2, z-1);
		blocks[5] = worldObj.getBlock(x, y-2, z+1);
		blocks[6] = worldObj.getBlock(x-1, y-2, z-1);
		blocks[7] = worldObj.getBlock(x+1, y-2, z-1);
		blocks[8] = worldObj.getBlock(x+1, y-2, z+1);
		blocks[9] = worldObj.getBlock(x-1, y-2, z+1);
		
		if(isVoidStoneTotem(blocks[0])) {
			worldObj.setBlock(x, y-1, z, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[1])) {
			worldObj.setBlock(x, y-2, z, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[2])) {
			worldObj.setBlock(x-1, y-2, z, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[3])) {
			worldObj.setBlock(x+1, y-2, z, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[4])) {
			worldObj.setBlock(x, y-2, z-1, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[5])) {
			worldObj.setBlock(x, y-2, z+1, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[6])) {
			worldObj.setBlock(x-1, y-2, z-1, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[7])) {
			worldObj.setBlock(x+1, y-2, z-1, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[8])) {
			worldObj.setBlock(x+1, y-2, z+1, EIBlocks.voidStone);
		}
		
		if(isVoidStoneTotem(blocks[9])) {
			worldObj.setBlock(x-1, y-2, z+1, EIBlocks.voidStone);
		}
	}	
	
	protected void changeTo(int x, int y, int z) {
		Block[] blocks = new Block[10];
		
		blocks[0] = worldObj.getBlock(x, y-1, z);
		blocks[1] = worldObj.getBlock(x, y-2, z);
		blocks[2] = worldObj.getBlock(x-1, y-2, z);
		blocks[3] = worldObj.getBlock(x+1, y-2, z);
		blocks[4] = worldObj.getBlock(x, y-2, z-1);
		blocks[5] = worldObj.getBlock(x, y-2, z+1);
		blocks[6] = worldObj.getBlock(x-1, y-2, z-1);
		blocks[7] = worldObj.getBlock(x+1, y-2, z-1);
		blocks[8] = worldObj.getBlock(x+1, y-2, z+1);
		blocks[9] = worldObj.getBlock(x-1, y-2, z+1);
		
		if(!isTotem(blocks[0])) {
			worldObj.setBlock(x, y-1, z, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[1])) {
			worldObj.setBlock(x, y-2, z,EIBlocks.totum);
		}
		
		if(!isTotem(blocks[2])) {
			worldObj.setBlock(x-1, y-2, z, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[3])) {
			worldObj.setBlock(x+1, y-2, z, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[4])) {
			worldObj.setBlock(x, y-2, z-1, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[5])) {
			worldObj.setBlock(x, y-2, z+1, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[6])) {
			worldObj.setBlock(x-1, y-2, z-1,EIBlocks.totum);
		}
		
		if(!isTotem(blocks[7])) {
			worldObj.setBlock(x+1, y-2, z-1, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[8])) {
			worldObj.setBlock(x+1, y-2, z+1, EIBlocks.totum);
		}
		
		if(!isTotem(blocks[9])) {
			worldObj.setBlock(x-1, y-2, z+1, EIBlocks.totum);
		}
	}
	
	public void scanTBS() {
		
		if(tbs[0] == null) {
			tbs[0] = new TotumBlock(this.xCoord - 1, this.yCoord - 1, this.zCoord);
		}
		
		if(tbs[1] == null) {
			tbs[1] = new TotumBlock(this.xCoord + 1, this.yCoord - 1, this.zCoord);
		}
		
		if(tbs[2] == null) {
			tbs[2] = new TotumBlock(this.xCoord, this.yCoord - 1, this.zCoord - 1);
		}
		
		if(tbs[3] == null) {
			tbs[3] = new TotumBlock(this.xCoord, this.yCoord - 1, this.zCoord + 1);
		}
		
		if(tbs[4] == null) {
			tbs[4] = new TotumBlock(this.xCoord - 1, this.yCoord - 1, this.zCoord - 1);
		}
		
		if(tbs[5] == null) {
			tbs[5] = new TotumBlock(this.xCoord + 1, this.yCoord - 1, this.zCoord - 1);
		}
		
		if(tbs[6] == null) {
			tbs[6] = new TotumBlock(this.xCoord + 1, this.yCoord - 1, this.zCoord + 1);
		}
		
		if(tbs[7] == null) {
			tbs[7] = new TotumBlock(this.xCoord - 1, this.yCoord - 1, this.zCoord + 1);
		}
	}
	
	public void updateBlock(Block iron) {
		for(int i = 0; i < tbs.length; i++) {
			
			if(tbs[i].isIronBlock()) {
				
				tbs[i].setCurrentTime(5.0f);
				
				if(tbs[i].decrementTime()) {
					worldObj.setBlock(tbs[i].getX(), tbs[i].getY(), tbs[i].getZ(), iron);
				}
			} else {
				tbs[i].setCurrentTime(-1.0f);
			}
		}	
	}
	
	/*
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		
		//this.scanTBS();
		
		NBTTagList list = compound.getTagList("totum", tbs.length);
		
		for(int i = 0; i < tbs.length; i++) {
			tbs[i].readFromNTB(list, i);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < tbs.length; i++) {
			tbs[i].writeToNTB(list);
		}
		
		compound.setTag("totum", list);
	}
	*/
	
	protected abstract void updateOreBlocks();
	

}
