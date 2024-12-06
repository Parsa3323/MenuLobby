package me.parsa.menulobby.Events;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.Plugin;

public class NoHunger implements Listener {

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    private final World targetWorld;

    public NoHunger(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void onFoodCHange(FoodLevelChangeEvent e) {
        if (e.getEntity().getWorld().equals(spawn_world)) {
            // doesn't allow to get hunger
            if (e.getEntity() instanceof org.bukkit.entity.Player) {
                e.setCancelled(true);
            }
        }
    }
}
