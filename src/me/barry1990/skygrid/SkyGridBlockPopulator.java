package me.barry1990.skygrid;

import java.util.Queue;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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
				if (cb.material == Material.CHEST){
					Chest chest = (Chest)block.getState();
					Inventory inv = chest.getInventory();
					setRandomInventoryContent(inv,random);
					
				}
				 //block.setData(DyeColor.MAGENTA.getWoolData());
				 //if (block.getState() instanceof Wool) {
					 	
		               //((Wool) block.getState()).setColor(DyeColor.MAGENTA);
		              
		          // }
						
			}
			// delete queue
			SkyGrid.blockQueue.remove(key);
		}
		
		
		
		
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
		
		//SkyGrid.getSkyGridPlugin().getLogger().info("YEAH BABY!");
		
	}
	
	public static DyeColor getRandomDyeColor(Random random) {
        int x = random.nextInt(Material.class.getEnumConstants().length);
        return DyeColor.class.getEnumConstants()[x];
    }
	
	public static void setRandomInventoryContent(Inventory inv, Random random){

		ItemStack[] items = new ItemStack[inv.getSize()];
		
		for (int i=0; i<inv.getSize(); i++){
			
			items[i] = ItemList.getRandomItemstack(random);
			if (random.nextFloat() < 0.1)
				break;
		}
		
		inv.setContents(items);
	}
}
