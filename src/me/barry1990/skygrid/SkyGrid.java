package me.barry1990.skygrid;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyGrid extends JavaPlugin {
	
	private static SkyGrid plugin = null;

	@Override
	public void onEnable() {
		
		plugin = this;
	
		// TODO Auto-generated method stub
		
		//getServer().getPluginManager().registerEvents(new SkyGridWorldListener(), this);
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
	
	
	/*private class SkyGridWorldListener implements Listener {
		@EventHandler
		public void onWorldInit(WorldInitEvent event) {
			getLogger().info("Attaching SkyGridPopulator to world \"" + event.getWorld().getName() + "\"");
			event.getWorld().getPopulators().add(new SkyGridBlockPopulator());			
		}
	}*/
}
