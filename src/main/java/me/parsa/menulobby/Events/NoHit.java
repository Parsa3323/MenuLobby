package me.parsa.menulobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class NoHit implements Listener {

    private final World targetWorld;

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    public NoHit(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        Entity entity = e.getEntity();
        if (entity.getWorld().equals(spawn_world)) {
            if (entity instanceof org.bukkit.entity.Player) {
                e.setCancelled(true);
            }
        }
    }
}
