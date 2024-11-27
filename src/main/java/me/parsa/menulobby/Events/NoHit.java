package me.parsa.menulobby.Events;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class NoHit implements Listener {

    private final World targetWorld;

    public NoHit(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Entity entity = e.getEntity();

        if (entity instanceof org.bukkit.entity.Player) {
                e.setCancelled(true);
        }

    }
}
