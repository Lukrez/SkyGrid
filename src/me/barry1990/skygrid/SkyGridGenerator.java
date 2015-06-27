package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;


public class SkyGridGenerator extends ChunkGenerator {

	@Override
	public byte[][] generateBlockSections(World world, Random random, int x,
			int z, BiomeGrid biomes) {
	
		byte[][] result = new byte[world.getMaxHeight() / 16][]; //world height / chunk part height (=16)
		
		
		
		
		return result;
	}
	
	
    void setBlock(byte[][] result, int x, int y, int z, byte blkid) {
	    // is this chunk part already initialized?
	    if (result[y >> 4] == null) {
		    // Initialize the chunk part
		    result[y >> 4] = new byte[4096];
	    }
	    // set the block
	    result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
}
