package me.barry1990.skygrid;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;


public class SkyGridGenerator extends ChunkGenerator {
	
	private SkyGrid plugin;
	
	public SkyGridGenerator(SkyGrid p) {
		this.plugin = p;
	}

	@Override
	public byte[][] generateBlockSections(World world, Random random, int chunkX,
			int chunkZ, BiomeGrid biomes) {
	
		byte[][] result = new byte[world.getMaxHeight() / 16][]; //world height / chunk part height (=16)
		
		/* generate the grid */
		
		for (int y = 0; y < 256; y=y+4) {
		
			for (int z = 0; z < 16; z=z+4) {
							
				for (int x = 0; x < 16; x=x+4) {
					
						this.setBlock(result, x, y, z, (byte) BlockList.getRandomMaterial(random).getId());	
				
				}			
				
			}
			
		}
			
			
		
		
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
