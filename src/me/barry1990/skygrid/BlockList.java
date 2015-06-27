package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.Material;


public class BlockList {
	
	public static final short STONE = (short)Material.STONE.getId();
	
	public static final short GRANITE_STONE = (short)((1 << 12) | STONE);
	public static final short POLISHED_GRANITE_STONE = (short)((2 << 12) | STONE);
	public static final short DIORITE_STONE = (short)((3 << 12) | STONE);
	public static final short POLISHED_DIORITE_STONE = (short)((4 << 12) | STONE);
	public static final short ANDESITE_STONE = (short)((5 << 12) | STONE);
	public static final short POLISHED_ANDESITE_STONE = (short)((6 << 12) | STONE);
	
	
	//list of blocks used for the grid
	static private Material[] materiallist0 = null;
	static private Material[] materiallist1 = null;
	static private Material[] materiallist2 = null;
	static private Material[] materiallist3 = null;
	static private Material[] materiallist4 = null;

	
	public static Material getRandomMaterial(Random random) {
		
		// init the list
		if (BlockList.materiallist0 == null) {
			BlockList.materiallist0 = new Material[] { 
					
					Material.GRASS,  // Grass, Flowers
					Material.DIRT, // Saplings
					Material.SOIL, //Wheat, Cartots, Potatos
					Material.SAND, // Cactus, Dead bush
					Material.NETHERRACK, // Fire
					Material.HAY_BLOCK,
					Material.COBBLESTONE,
					Material.STONE,
					Material.LOG, // Cacao on Junglewood
					Material.LEAVES,
					Material.LOG_2,
					Material.LEAVES_2,
			};
		}
		if (BlockList.materiallist1 == null) {
			BlockList.materiallist1 = new Material[] { 
					// seldom 1
					Material.COAL_BLOCK,
					Material.COAL_ORE,
					Material.GLASS,
					Material.SANDSTONE,
					Material.WOOL,
					Material.BOOKSHELF,
					Material.WORKBENCH,
					Material.PUMPKIN,
					Material.JACK_O_LANTERN,
					Material.CAKE_BLOCK,
					Material.MELON_BLOCK,
					Material.RED_SANDSTONE,					
					Material.SNOW_BLOCK,	
					Material.NETHER_BRICK,
					Material.BRICK,
			};
		}
		if (BlockList.materiallist2 == null) {
			BlockList.materiallist2 = new Material[] { 
					// seldom 2
					Material.CLAY,
					Material.MONSTER_EGG,
					Material.WEB,
					Material.NOTE_BLOCK,
					Material.IRON_ORE,
					Material.QUARTZ_ORE,
					Material.MOSSY_COBBLESTONE,
					Material.IRON_BARDING,
					Material.THIN_GLASS,
					Material.STAINED_CLAY,
					Material.STAINED_GLASS,
					Material.ICE,
					Material.ENDER_STONE,

			};
		}
		if (BlockList.materiallist3 == null) {
			BlockList.materiallist3 = new Material[] { 
					// seldom 3
					Material.GOLD_ORE,
					Material.LAPIS_ORE,
					Material.OBSIDIAN,
					Material.SLIME_BLOCK,
					Material.GLOWSTONE,
					Material.REDSTONE_ORE,
					Material.PRISMARINE,
					Material.SEA_LANTERN,
					Material.DISPENSER,
					Material.CHEST,
					Material.DROPPER,
					Material.HOPPER,
					Material.FURNACE,
					Material.STATIONARY_LAVA,
					Material.STATIONARY_WATER,
			};
		}
		if (BlockList.materiallist4 == null) {
			BlockList.materiallist4 = new Material[] { 
					// seldom 4
					Material.MYCEL, // Mushrooms
					Material.DIAMOND_ORE,
					Material.ENDER_CHEST,
					Material.SPONGE,
					Material.JUKEBOX,
					Material.EMERALD_ORE,
					Material.MOB_SPAWNER,
					Material.TNT,
					Material.SOUL_SAND, // Netherwards
					
					};
		}
		
		// select a random materiallist
		
		int randomList = random.nextInt(1000);
		Material[] chosenList = null;
		
		if (randomList < 50){
			chosenList = BlockList.materiallist4;
		} else if (randomList < 200){
			chosenList = BlockList.materiallist3;
		} else if (randomList < 400){
			chosenList = BlockList.materiallist2;
		} else if (randomList < 600){
			chosenList = BlockList.materiallist1;
		} else {
			chosenList = BlockList.materiallist0;
		}
		
		
		return chosenList[random.nextInt(chosenList.length)];
	}
	
	public short getRandomStoneType(Random random) {
		switch (random.nextInt(7)) {
			case 0 : return GRANITE_STONE; 
			case 1 : return POLISHED_GRANITE_STONE;
			case 2 : return DIORITE_STONE;
			case 3 : return POLISHED_DIORITE_STONE;
			case 4 : return ANDESITE_STONE;
			case 5 : return POLISHED_ANDESITE_STONE;
			case 6 : return STONE;
		}
		//we should never get here
		return STONE;
		
	}
	
}
