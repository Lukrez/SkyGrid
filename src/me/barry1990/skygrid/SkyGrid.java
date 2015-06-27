package me.barry1990.skygrid;
import java.util.HashMap;
import java.util.Queue;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyGrid extends JavaPlugin {
	
	private static SkyGrid plugin = null;

	public static HashMap<String,Queue<ComplexBlock>> blockQueue;
	
	@Override
	public void onEnable() {
		
		plugin = this;

		SkyGrid.blockQueue = new HashMap<String,Queue<ComplexBlock>>();
		this.getLogger().info("v" + this.getDescription().getVersion() + " enabled.");
	}
	
	@Override
	public void onDisable() {
	
		// TODO Auto-generated method stub
		this.getLogger().info("v" + this.getDescription().getVersion() + " disabled.");
		
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		this.getLogger().info("getDefaultWorldGenerator called");
		return new SkyGridGenerator();
	}
	
	public static SkyGrid getSkyGridPlugin() {
		return plugin;
	}

}
