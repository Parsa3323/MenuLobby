package me.parsa.menulobby.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveEvent implements Listener {
    @EventHandler
    public void playerQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        e.getPlayer().getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "MenuLobby -> " + ChatColor.AQUA + "" + e.getPlayer().getName() + " is leaving the server, goodbye");

    }

}
