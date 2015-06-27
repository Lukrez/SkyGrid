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
		
		/* generate random wool */		
		for (int y = 0; y < 256; y++) {		
			for (int z = 0; z < 16; z++) {							
				for (int x = 0; x < 16; x++) {
					Block block = world.getBlockAt((chunk.getX() << 4) | x, y, (chunk.getZ() << 4) | z);
					if (block.getState() instanceof Wool) {
						SkyGrid.getSkyGridPlugin().getLogger().info("Wolle gesetzt");
						((Wool) block.getState()).setColor(/*getRandomDyeColor(random)*/DyeColor.YELLOW);						
					}
				}
			}
		}
		
		SkyGrid.getSkyGridPlugin().getLogger().info("YEAH BABY!");
		
	}
	
	public static DyeColor getRandomDyeColor(Random random) {
        int x = random.nextInt(Material.class.getEnumConstants().length);
        return DyeColor.class.getEnumConstants()[x];
    }

}
