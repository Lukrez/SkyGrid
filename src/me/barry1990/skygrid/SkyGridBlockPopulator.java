package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.material.Wool;


public class SkyGridBlockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {

		// TODO Auto-generated method stub
		
		/* fill Chests */
		
	}
	
	public static DyeColor getRandomDyeColor(Random random) {
        int x = random.nextInt(Material.class.getEnumConstants().length);
        return DyeColor.class.getEnumConstants()[x];
    }

}
