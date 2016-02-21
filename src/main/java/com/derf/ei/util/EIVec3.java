package com.derf.ei.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;

public class EIVec3 {
	private double x;
	private double y;
	private double z;
	
	public EIVec3() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	
	public EIVec3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public EIVec3(Vec3 v) {
		this.x = v.xCoord;
		this.y = v.yCoord;
		this.z = v.zCoord;
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
	public static EIVec3 add(EIVec3 u, EIVec3 v) {
		return new EIVec3(
				u.getX() + v.getX(), 
				u.getY() + v.getY(), 
				u.getZ() + v.getZ());
	}
	
	public static EIVec3 sub(EIVec3 u, EIVec3 v) {
		return new EIVec3(
				u.getX() - v.getX(), 
				u.getY() - v.getY(), 
				u.getZ() - v.getZ());
	}
	
	public static EIVec3 mul(EIVec3 u, double v) {
		return new EIVec3(
				u.getX() * v, 
				u.getY() * v, 
				u.getZ() * v);
	}
	
	public static EIVec3 div(EIVec3 u, double v) {
		return new EIVec3(
				u.getX() / v, 
				u.getY() / v, 
				u.getZ() / v);
	}
	
	public static EIVec3 negate(EIVec3 u) {
		return new EIVec3(
				-u.getX(),
				-u.getY(),
				-u.getZ());
	}
	
	public static double length(EIVec3 v) {
		return (double) Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY() + v.getZ() * v.getZ());
	}
	
	public static EIVec3 unit(EIVec3 v) {
		double len = length(v);
		return div(v, len);
	}
	
	public static double dot(EIVec3 u, EIVec3 v) {
		return u.getX() * v.getX() + u.getY() * v.getY() + u.getZ() * v.getZ();
	}
	
	public static EIVec3 cross(EIVec3 u, EIVec3 v) {
		return new EIVec3(
				u.getY() * v.getZ() - u.getZ() * v.getY(),
				u.getZ() * v.getX() - u.getX() * v.getZ(),
				u.getX() * v.getY() - u.getY() * v.getX());
	}
	
	public void chatPrint(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("Vec3["+x+","+y+","+z+"]"));
	}
}
