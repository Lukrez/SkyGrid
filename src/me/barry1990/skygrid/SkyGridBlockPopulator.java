package me.barry1990.skygrid;

import java.util.List;
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

public class SkyGridBlockPopulator extends BlockPopulator {

	static final int chestsize = 27;
	
	@Override
	public void populate(World world, Random random, Chunk chunk) {

		// get queue
		String key = chunk.getX()+";"+chunk.getZ();
		List<ComplexBlock> list = SkyGrid.blockQueue.get(key);		
		if (list != null){
			for (ComplexBlock cb : list) {
				Block block = world.getBlockAt(cb.x, cb.y, cb.z);
			
				if (cb.material == Material.CHEST){
					Chest chest = (Chest)block.getState();
					Inventory inv = chest.getInventory();
					setRandomInventoryContent(inv,random);
				} else {
					block.setData(cb.materialData.getData());
				}
						
			}
			// delete list
			list.clear();			
			SkyGrid.blockQueue.remove(key);
		}

	}
	
	public static DyeColor getRandomDyeColor(Random random) {
        int x = random.nextInt(Material.class.getEnumConstants().length);
        return DyeColor.class.getEnumConstants()[x];
    }
	
	public static void setRandomInventoryContent(Inventory inv, Random random){
		
		ItemStack[] items = new ItemStack[inv.getSize()];
		int i=0;
		for (; i<inv.getSize(); i++){
			
			items[i] = ItemList.getRandomItemstack(random);
			if (random.nextFloat() > 0.75)
				break;
		}		
		inv.setContents(items);		
	}
}
