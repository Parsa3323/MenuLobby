package me.parsa.menulobby.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class NoBlockDrop implements Listener {

    @EventHandler
    public void ondDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("menulobby.admin")) {
            e.setCancelled(false);
        }
        e.setCancelled(true);
    }
}
