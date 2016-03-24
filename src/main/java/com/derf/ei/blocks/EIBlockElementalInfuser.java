package com.derf.ei.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.derf.ei.blocks.tileentity.EITileEntityElementalInfuser;

public class EIBlockElementalInfuser extends BlockContainer {

	protected EIBlockElementalInfuser(String name, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setHardness(1.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(SoundType.STONE);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		// TODO Auto-generated method stub
		return new EITileEntityElementalInfuser();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumBlockRenderType getRenderType(IBlockState p_getRenderType_1_) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack stack, EnumFacing face, float fx, float fy, float fz) {
		// TODO Auto-generated method stub
		
		if(!world.isRemote && player.inventory.getStackInSlot(player.inventory.currentItem) == null && hand == EnumHand.MAIN_HAND) {
			
			System.out.println("player inventory: "+player.inventory.currentItem);
			EITileEntityElementalInfuser core = (EITileEntityElementalInfuser)world.getTileEntity(pos);
			core.currentMode(player);
		}
		
		return super.onBlockActivated(world, pos, state, player, hand, stack, face, fx, fy, fz);
	}
}
