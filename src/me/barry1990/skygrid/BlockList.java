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
	static private Material[] common_materiallist = null;
	static private Material[] rare_materiallist = null;
	static private Material[] materiallist = null;
	
	public static Material getRandomMaterial(Random random) {
		
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
		
		
		return BlockList.materiallist[random.nextInt(BlockList.materiallist.length)];
	}
	
	public static short getRandomStoneType(Random random) {
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
