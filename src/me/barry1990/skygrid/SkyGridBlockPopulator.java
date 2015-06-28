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
				block.setData(cb.materialData.getData());						
			}
			// delete queue
			SkyGrid.blockQueue.remove(key);
		}
		
		SkyGrid.getSkyGridPlugin().getLogger().info("YEAH BABY!");
		
	}
}
