package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.Material;


public class BlockList {

	//list of blocks used for the grid
	static private Material[] materiallist = null;
	
	public static Material getRandomMaterial(Random random) {
		
		// init the list
		if (BlockList.materiallist == null) {
			BlockList.materiallist = new Material[] { 
					Material.STONE,
					Material.DIRT
					
					/*
					 * 
					 */
					
					
					};
		}
		
		return BlockList.materiallist[random.nextInt(BlockList.materiallist.length)];
	}
	
}
