package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemList {

		//list of materials used for inventories
		static private Material[] materiallist0 = null;
		static private Material[] materiallist1 = null;
		static private Material[] materiallist2 = null;
		static private Material[] materiallist3 = null;
		static private Material[] materiallist4 = null;

		
		public static ItemStack getRandomItemstack(Random random) {
			if (ItemList.materiallist0 == null) {
				ItemList.materiallist0 = new Material[] { 
						
						Material.WOOD,
						Material.STONE,
						Material.TORCH,
						Material.STICK,
						Material.LOG,
						Material.LOG_2,
						Material.SAND,
						Material.DIRT,
						Material.GRAVEL,
						Material.ARROW,
						Material.COBBLESTONE,
						Material.SANDSTONE,	
				};
				
			}
			if (ItemList.materiallist1 == null) {
				ItemList.materiallist1 = new Material[] { 
						Material.PAPER,
						Material.LEATHER,
						Material.BREAD,
						Material.COOKIE,
						Material.BAKED_POTATO,
						Material.SNOW_BALL,
						Material.WHEAT,
						Material.SAPLING,
						Material.STRING,
						Material.CLAY_BALL,
				};
			}
			if (ItemList.materiallist2 == null) {
				ItemList.materiallist2 = new Material[] { 
						Material.WOOD_PICKAXE,
						Material.STONE_AXE,
						Material.STONE_SWORD,
						Material.STONE_PICKAXE,	
						Material.BED,
						Material.BOW,
						Material.BUCKET,
						Material.LEATHER_BOOTS,
						Material.LEATHER_CHESTPLATE,
						Material.LEATHER_HELMET,
						Material.LEATHER_LEGGINGS,
						Material.IRON_PICKAXE,
						Material.INK_SACK,
						Material.COAL,
				};
			}
			if (ItemList.materiallist3 == null) {
				ItemList.materiallist3 = new Material[] { 
						Material.VINE,
						Material.POTATO,
						Material.WATER_BUCKET,
						Material.LAVA_BUCKET,
						Material.MILK_BUCKET,
						Material.IRON_INGOT,
						Material.GOLD_INGOT,
						Material.SULPHUR,
						Material.WOOL,
						Material.BONE,
						Material.SEEDS,
						Material.OBSIDIAN,
						Material.CACTUS,
						Material.CARROT,
						Material.SUGAR_CANE,
						
				};
			}
			if (ItemList.materiallist4 == null) {
				ItemList.materiallist4 = new Material[] { 
						Material.RECORD_3,
						Material.RECORD_4,
						Material.RECORD_5,
						Material.RECORD_6,
						Material.RECORD_7,
						Material.RECORD_8,
						Material.RECORD_9,
						Material.RECORD_10,
						Material.RECORD_11,
						Material.RECORD_12,
						Material.DIAMOND,
						Material.EMERALD,
						Material.ENDER_PEARL,
						Material.EXP_BOTTLE,
						Material.SADDLE,
						Material.NAME_TAG,
						Material.GOLDEN_APPLE,
						Material.GHAST_TEAR,
				};
			}
			
			// select a random materiallist
			int randomList = random.nextInt(1000);
			Material[] chosenList = null;
			int maxAmount;
			double prob;
			if (randomList < 50){
				chosenList = ItemList.materiallist4;
				maxAmount = 3;
				prob = 0.25;
			} else if (randomList < 200){
				chosenList = ItemList.materiallist3;
				maxAmount = 4;
				prob = 0.5;
			} else if (randomList < 400){
				chosenList = ItemList.materiallist2;
				maxAmount = 15;
				prob = 0.75;
			} else if (randomList < 600){
				chosenList = ItemList.materiallist1;
				maxAmount = 20;
				prob = 0.9;
			} else {
				chosenList = ItemList.materiallist0;
				maxAmount = 32;
				prob = 0.9;
			}
			Material randomMaterial = chosenList[random.nextInt(chosenList.length)];
			ItemStack item = new ItemStack(randomMaterial,1);
			if (item.getMaxStackSize() < maxAmount){
				maxAmount = item.getMaxStackSize();
			}
			int amount = 0;
			for (int i=0; i < maxAmount; i++){
				amount += 1;
				if (random.nextFloat() > prob)
					break;
			}
			item.setAmount(amount);
			return item;
		}
}
