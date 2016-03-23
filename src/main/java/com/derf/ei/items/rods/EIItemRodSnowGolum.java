package com.derf.ei.items.rods;

import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EIItemRodSnowGolum extends EIItemRod {

	public EIItemRodSnowGolum(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack,
			EntityPlayer player, World world,
			BlockPos pos, EnumHand hand,
			EnumFacing facing, float fx,
			float fy, float fz) {
		
		if(!world.isRemote) {
			if(facing.getName().compareTo("up") == 0) {
				//world.spawnEntityInWorld(new EntitySnowman(world));
				EntitySnowman entity = new EntitySnowman(world);
				
				entity.setPosition(pos.getX(), pos.getY()+1, pos.getZ());
				
				world.spawnEntityInWorld(entity);
			}
		}
		
		return EnumActionResult.SUCCESS;
	}
	
}
