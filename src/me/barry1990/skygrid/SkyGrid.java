package me.barry1990.skygrid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyGrid extends JavaPlugin {

	//public static Queue<ComplexBlock> blockQueue;
	public static HashMap<String,Queue<ComplexBlock>> blockQueue;
	
	@Override
	public void onEnable() {
	
		// TODO Auto-generated method stub
		
		getServer().getPluginManager().registerEvents(new SkyGridWorldListener(), this);
		//SkyGrid.blockQueue = new LinkedList<ComplexBlock>();
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
		this.getLogger().info("getDefaultWorldGenerator celled");
		return new SkyGridGenerator();
	}
	
	
	private class SkyGridWorldListener implements Listener {
		@EventHandler
		public void onWorldInit(WorldInitEvent event) {
			getLogger().info("Attaching SkyGridPopulator to world \"" + event.getWorld().getName() + "\"");
			event.getWorld().getPopulators().add(new SkyGridBlockPopulator());			
		}
	}
	
	
}
