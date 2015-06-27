package me.barry1990.skygrid;

import org.bukkit.Material;

public class ComplexBlock {

	public int x;
	public int y;
	public int z;
	public Material material;
	
	public ComplexBlock(Material m, int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.material = m;
	}
	
	public String toString(){
		return x+" "+y+" "+z+" "+material.toString();
	}
}
