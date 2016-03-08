package com.derf.ei.items.rods;

import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EIItemRodSnowGolum extends EIItemRod {

	public EIItemRodSnowGolum(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		if(!world.isRemote) {
			if(facing.getName().compareTo("up") == 0) {
				//world.spawnEntityInWorld(new EntitySnowman(world));
				EntitySnowman entity = new EntitySnowman(world);
				
				entity.setPosition(pos.getX(), pos.getY()+1, pos.getZ());
				
				world.spawnEntityInWorld(entity);
			}
		}
		
		return true;
	}
}
