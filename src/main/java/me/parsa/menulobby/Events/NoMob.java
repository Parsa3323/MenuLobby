package me.parsa.menulobby.Events;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;

public class NoMob implements Listener {

    private final World targetWorld;

    public NoMob(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        // Check if the entity is in the target world
        Entity entity = event.getEntity();
        if (entity.getWorld().equals(targetWorld)) {
            // Cancel the spawn if the entity is not a player or NPC
            if (!(entity instanceof Player) && !isNPC(entity)) {
                event.setCancelled(true);
                System.out.println("Non-NPC mob spawn cancelled in world: " + targetWorld.getName());
            }
        }
    }

    // A method to check if the entity is an NPC (optional)
    private boolean isNPC(Entity entity) {
        // You can check for NPCs here. For example, if using a plugin like Citizens:
        // return CitizensAPI.getNPCRegistry().isNPC(entity);
        // Or for other plugins, check if they provide an NPC check method
        // If you're not using Citizens or similar, return false for now.
        return false;
    }
}
