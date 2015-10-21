package com.derf.ei.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class EIItemDebugTool extends EIItem {
	
	public final static int CHECK_UNLOCALIZED_NAME = 0;
	public final static int CHECK_LOCALIZED_NAME = 1;
	public final static int PLAYER_COORDS = 2;
	public final static int TIME_SET_0 = 3;
	public final static int TOGGLE_DOWNFALL = 4;
	public final static int MAX_MODES = 5;
	
	private int mode = CHECK_UNLOCALIZED_NAME;
	
	public EIItemDebugTool(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(
			ItemStack itemStack, 
			EntityPlayer player, 
			World world, 
			int x, 
			int y, 
			int z, 
			int side, 
			float fx, 
			float fy, 
			float fz) {
		
		
		
		if(!world.isRemote) {
			
			if(player.isSneaking()) {
				this.toggleMode();
				this.printMode(player);
			} else {
				if(mode == CHECK_UNLOCALIZED_NAME) {
					Block block;
					block = world.getBlock(x, y, z);
					player.addChatComponentMessage(new ChatComponentText("Unlocalized Name: " + block.getUnlocalizedName()));
					
				} else if(mode == CHECK_LOCALIZED_NAME) {
					Block block;
					block = world.getBlock(x, y, z);
					player.addChatComponentMessage(new ChatComponentText("Localized Name: " + block.getLocalizedName()));
				} else if(mode == PLAYER_COORDS) {
					player.addChatComponentMessage(new ChatComponentText("Player Coords: ["+(int)player.posX+", "+(int)player.posY+", "+(int)player.posZ+",]"));
				} else if(mode == TIME_SET_0) {
					world.setWorldTime(0);
				} else if(mode == TOGGLE_DOWNFALL) {
					WorldInfo wi = world.getWorldInfo();
					wi.setRaining(false);
				}
			}
		}
		
		return true;
	}
	
	private void toggleMode() {
		if(mode < MAX_MODES - 1) {
			mode++;
		} else {
			mode = CHECK_UNLOCALIZED_NAME;
		}
	}
	
	private void printMode(EntityPlayer player) {
		switch(mode) {
		/*
		 * 	public final static int CHECK_UNLOCALIZED_NAME = 0;
			public final static int CHECK_LOCALIZAED_NAME = 1;
			public final static int PLAYER_COORDS = 2;
			public final static int TIME_SET_0 = 3;
			public final static int TOGGLE_DOWNFALL = 4;
		 */
		
		case CHECK_UNLOCALIZED_NAME:
			player.addChatComponentMessage(new ChatComponentText("Unlocalized Mode"));
			break;
		case CHECK_LOCALIZED_NAME:
			player.addChatComponentMessage(new ChatComponentText("Localized Mode"));
			break;
		case PLAYER_COORDS:
			player.addChatComponentMessage(new ChatComponentText("Player Coord Mode"));
			break;
		case TIME_SET_0:
			player.addChatComponentMessage(new ChatComponentText("Time set 0 Mode"));
			break;
		case TOGGLE_DOWNFALL:
			player.addChatComponentMessage(new ChatComponentText("Toggle Downfall Mode"));
			break;
		}
	}
	
	
}
