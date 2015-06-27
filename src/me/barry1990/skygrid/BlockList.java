package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.Material;


public class BlockList {

	//list of blocks used for the grid
	static private Material[] common_materiallist = null;
	static private Material[] rare_materiallist = null;
	static private Material[] materiallist = null;
	static private short[] materialListID = null;
	
	public static short getRandomMaterial(Random random) {
		
		// init the list
		if (BlockList.materiallist == null) {
			BlockList.materiallist = new Material[] { 
					
					Material.GRASS,  // Grass, Flowers
					Material.DIRT, // Saplings
					Material.SOIL, //Wheat, Cartots, Potatos
					Material.SAND, // Cactue, Dead budh
					Material.NETHERRACK, // Fire
					Material.SOUL_SAND, // Netherwards
					Material.MYCEL, // Mushrooms
					
					
					
					Material.DISPENSER,
					Material.CHEST,
					Material.MOB_SPAWNER,
					Material.DROPPER,
					Material.HOPPER,
					Material.FURNACE,
					
					Material.COBBLESTONE,
					Material.STONE,
					Material.ICE,
					Material.CLAY,
					
					Material.RED_SANDSTONE,					
					Material.SNOW_BLOCK,	
					Material.NETHER_BRICK,
					Material.BRICK,
					Material.ENDER_STONE,
					Material.STAINED_CLAY,
					Material.STAINED_GLASS,
					Material.PRISMARINE,
					Material.SEA_LANTERN,
					
					Material.LOG, // Cacao on Junglewood
					Material.LEAVES,
					Material.LOG_2,
					Material.LEAVES_2,
					
					//Material.WATER,
					//Material.LAVA,

					Material.LAPIS_ORE,
					Material.GOLD_ORE,
					Material.IRON_ORE,
					Material.QUARTZ_ORE,
					Material.DIAMOND_ORE,
					Material.COAL_BLOCK,
					Material.COAL_ORE,
					Material.SLIME_BLOCK,
					Material.EMERALD_ORE,
					Material.GLOWSTONE,
					Material.REDSTONE_ORE,
					
					Material.HAY_BLOCK,
					Material.SPONGE,
					Material.GLASS,
					Material.SANDSTONE,
					Material.NOTE_BLOCK,
					Material.WOOL,
					Material.TNT,
					Material.MOSSY_COBBLESTONE,
					Material.OBSIDIAN,
					Material.BOOKSHELF,
					Material.WORKBENCH,
					Material.JUKEBOX,
					Material.PUMPKIN,
					Material.JACK_O_LANTERN,
					Material.CAKE_BLOCK, // mal sehen ob es geht
					Material.MONSTER_EGG,
					Material.IRON_BARDING,
					Material.THIN_GLASS,
					Material.MELON_BLOCK,
					Material.ENDER_CHEST,
					Material.WEB					
					};
		}
		
		int materialListID_c = materiallist.length;
		
		if (materialListID == null) {
			materialListID = new short[materialListID_c];
			for (int i = 0; i< materialListID_c; i++) {
				materialListID[i] = (short) materiallist[i].getId();
			}
		}		
		
		return BlockList.materialListID[random.nextInt(materialListID_c)];
	}
	
}
