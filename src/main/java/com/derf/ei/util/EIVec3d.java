package com.derf.ei.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextComponentString;

public class EIVec3d {
	private double x;
	private double y;
	private double z;
	
	public EIVec3d() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	
	public EIVec3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public EIVec3d(Vec3d v) {
		this.x = v.xCoord;
		this.y = v.yCoord;
		this.z = v.zCoord;
	}
	
	public EIVec3d(BlockPos pos) {
		// TODO Auto-generated constructor stub
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
	}

	public EIVec3d(Vec3i v) {
		// TODO Auto-generated constructor stub
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	// Operations performed on 3D vectors
	public static EIVec3d add(EIVec3d u, EIVec3d v) {
		return new EIVec3d(
				u.getX() + v.getX(), 
				u.getY() + v.getY(), 
				u.getZ() + v.getZ());
	}
	
	public static EIVec3d sub(EIVec3d u, EIVec3d v) {
		return new EIVec3d(
				u.getX() - v.getX(), 
				u.getY() - v.getY(), 
				u.getZ() - v.getZ());
	}
	
	public static EIVec3d mul(EIVec3d u, double v) {
		return new EIVec3d(
				u.getX() * v, 
				u.getY() * v, 
				u.getZ() * v);
	}
	
	public static EIVec3d div(EIVec3d u, double v) {
		return new EIVec3d(
				u.getX() / v, 
				u.getY() / v, 
				u.getZ() / v);
	}
	
	public static EIVec3d negate(EIVec3d u) {
		return new EIVec3d(
				-u.getX(),
				-u.getY(),
				-u.getZ());
	}
	
	public static double length(EIVec3d v) {
		return (double) Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY() + v.getZ() * v.getZ());
	}
	
	public static EIVec3d unit(EIVec3d v) {
		double len = length(v);
		return div(v, len);
	}
	
	public static double dot(EIVec3d u, EIVec3d v) {
		return u.getX() * v.getX() + u.getY() * v.getY() + u.getZ() * v.getZ();
	}
	
	public static EIVec3d cross(EIVec3d u, EIVec3d v) {
		return new EIVec3d(
				u.getY() * v.getZ() - u.getZ() * v.getY(),
				u.getZ() * v.getX() - u.getX() * v.getZ(),
				u.getX() * v.getY() - u.getY() * v.getX());
	}
	
	public static Vec3d createVec3d(EIVec3d v) {
		return new Vec3d(v.getX(), v.getY(), v.getZ());
	}
	
	public void chatPrint(EntityPlayer player) {
		player.addChatMessage(new TextComponentString("Vec3["+x+","+y+","+z+"]"));
	}
	
}
