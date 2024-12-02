package me.parsa.menulobby.Events;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.Plugin;

public class NoBlockDrop implements Listener {

    private final World targetWorld;

    public NoBlockDrop(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void ondDrop(PlayerDropItemEvent e) {

        Player p = e.getPlayer();
        if (p.getWorld().equals(targetWorld)) {
            if (p.hasPermission("menulobby.admin")) {
                e.setCancelled(false);
            }
            e.setCancelled(true);
        }
    }
}
