package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;


public class SkyGridGenerator extends ChunkGenerator {
		
	@Override
	public short[][] generateExtBlockSections(World world, Random random,
			int chunkX, int chunkZ, BiomeGrid biomes) {		
		
		short[][] result = new short[world.getMaxHeight() / 16][]; //world height / chunk part height (=16)
		
		/* generate the grid */
		
		for (int y = 1; y < 256; y=y+4) {
		
			for (int z = 1; z < 16; z=z+4) {
							
				for (int x = 1; x < 16; x=x+4) {
					
						//this.setBlock(result, x, y, z, (byte) BlockList.getRandomMaterial(random).getId());
					/*if ((chunkX == 100) && (chunkZ == 100))
						this.setBlock(result, x, y, z, (byte) y);
					else */
						this.setBlock(result, x, y, z, BlockList.getRandomMaterial(random));
				}			
				
			}
			
		}
		
		return result;
	}
	
	
    void setBlock(short[][] result, int x, int y, int z, short blkid) {
	    // is this chunk part already initialized?
	    if (result[y >> 4] == null) {
		    // Initialize the chunk part
		    result[y >> 4] = new short[4096];
	    }
	    // set the block
	    result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
}
