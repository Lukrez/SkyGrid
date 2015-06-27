package me.barry1990.skygrid;

import java.util.Queue;
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

		// get queue
		String key = chunk.getX()+";"+chunk.getZ();
		Queue<ComplexBlock> queue = SkyGrid.blockQueue.get(key);
		if (queue != null){
			while (!queue.isEmpty()){
				ComplexBlock cb = queue.remove();
				Block block = world.getBlockAt(cb.x, cb.y, cb.z);
				 block.setData(DyeColor.MAGENTA.getWoolData());
				 //if (block.getState() instanceof Wool) {
					 	
		               //((Wool) block.getState()).setColor(DyeColor.MAGENTA);
		              
		          // }
						
			}
			// delete queue
			SkyGrid.blockQueue.remove(key);
		}
		
		
		
		
	}
	
	public static DyeColor getRandomDyeColor(Random random) {
        int x = random.nextInt(Material.class.getEnumConstants().length);
        return DyeColor.class.getEnumConstants()[x];
    }

}
