package com.derf.ei.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EIBlockVoidiumStone extends Block implements EIIMetaBlockName {

	public enum VoidiumStoneType implements IStringSerializable {
		REGULAR(0, "regular"),
		INPUT(1, "input"),
		OUTPUT(2, "output"),
		BIDIRECTIONAL(3, "bidirectional"),
		FIRE(4, "fire"),
		WATER(5, "water"),
		EARTH(6, "earth"),
		WIND(7, "wind"),
		VOID(8, "void");
		
		private int id;
		private String name;
		
		private VoidiumStoneType(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}
		
		public int getID() {
			return id;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.getName();
		}
		
		public static VoidiumStoneType getTypeFromID(int id) {
			VoidiumStoneType type = null;
			
			switch(id) {
			case 0:
				type = REGULAR;
				break;
			case 1:
				type = INPUT;
				break;
			case 2:
				type = OUTPUT;
				break;
			case 3:
				type = BIDIRECTIONAL;
				break;
			case 4:
				type = FIRE;
				break;
			case 5:
				type = WATER;
				break;
			case 6:
				type = EARTH;
				break;
			case 7:
				type = WIND;
				break;
			case 8:
				type = VOID;
				break;
			}
			return type;
		}
		
		public static String getNameFromID(int id) {
			String name = null;
			
			switch(id) {
			case 0:
				name = REGULAR.getName();
				break;
			case 1:
				name = INPUT.getName();
				break;
			case 2:
				name = OUTPUT.getName();
				break;
			case 3:
				name = BIDIRECTIONAL.getName();
				break;
			case 4:
				name = FIRE.getName();
				break;
			case 5:
				name = WATER.getName();
				break;
			case 6:
				name = EARTH.getName();
				break;
			case 7:
				name = WIND.getName();
				break;
			case 8:
				name = VOID.getName();
				break;
			}
			
			return name;
		}
	}
	
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EIBlockVoidiumStone.VoidiumStoneType.class);
	
	
	public EIBlockVoidiumStone(String name, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setHardness(1.0f);
		this.setResistance(2.0f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, VoidiumStoneType.REGULAR));
	}

	@Override
	public int damageDropped(IBlockState state) {
		// TODO Auto-generated method stub
		
		VoidiumStoneType type = state.getValue(TYPE);
		
		int id = type.getID();
		
		if(type == VoidiumStoneType.REGULAR || type == VoidiumStoneType.INPUT || type == VoidiumStoneType.OUTPUT || type == VoidiumStoneType.BIDIRECTIONAL) {
			id = VoidiumStoneType.REGULAR.getID();
		}
		
		return id;
	}
	
	@Override
	public int quantityDropped(IBlockState p_quantityDropped_1_,
			int p_quantityDropped_2_, Random p_quantityDropped_3_) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		// TODO Auto-generated method stub
		return getDefaultState().withProperty(TYPE, VoidiumStoneType.getTypeFromID(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		// TODO Auto-generated method stub
		VoidiumStoneType type = (VoidiumStoneType)state.getValue(TYPE);
		
		return type.getID();
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		// TODO Auto-generated method stub
		list.add(new ItemStack(item, 1, 0)); // Regular
		list.add(new ItemStack(item, 1, 4)); // Fire
		list.add(new ItemStack(item, 1, 5)); // Water
		list.add(new ItemStack(item, 1, 6)); // Earth
		list.add(new ItemStack(item, 1, 7)); // Wind
		list.add(new ItemStack(item, 1, 8)); // Void
		
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		// TODO Auto-generated method stub
		return VoidiumStoneType.getNameFromID(stack.getItemDamage());
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target,
			World world, BlockPos pos, EntityPlayer player) {
		// TODO Auto-generated method stub
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	
}
