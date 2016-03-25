package com.derf.ei.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class EIVec3i {
	private int x;
	private int y;
	private int z;
	
	public EIVec3i() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public EIVec3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public EIVec3i(Vec3i v) {
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}
	
	public EIVec3i(BlockPos v) {
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	
	// Operations performed on 3D vectors
	public static EIVec3i add(EIVec3i u, EIVec3i v) {
		return new EIVec3i(
				u.getX() + v.getX(), 
				u.getY() + v.getY(), 
				u.getZ() + v.getZ());
	}
	
	public static EIVec3i sub(EIVec3i u, EIVec3i v) {
		return new EIVec3i(
				u.getX() - v.getX(), 
				u.getY() - v.getY(), 
				u.getZ() - v.getZ());
	}
	
	public static EIVec3i mul(EIVec3i u, int v) {
		return new EIVec3i(
				u.getX() * v, 
				u.getY() * v, 
				u.getZ() * v);
	}
	
	public static EIVec3i div(EIVec3i u, int v) {
		return new EIVec3i(
				u.getX() / v, 
				u.getY() / v, 
				u.getZ() / v);
	}
	
	public static EIVec3i negate(EIVec3i u) {
		return new EIVec3i(
				-u.getX(),
				-u.getY(),
				-u.getZ());
	}
	
	public static BlockPos createBlockPos(EIVec3i u) {
		return new BlockPos(u.getX(), u.getY(), u.getZ());
	}
	
	public static Vec3i createVec3i(EIVec3i u) {
		return new Vec3i(u.getX(), u.getY(), u.getZ());
	}
}
