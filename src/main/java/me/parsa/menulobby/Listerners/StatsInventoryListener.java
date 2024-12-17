package me.parsa.menulobby.Listerners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class StatsInventoryListener implements Listener {

    @EventHandler
    public void onInv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "stats")) {
            e.setCancelled(true);
        }
    }
}
