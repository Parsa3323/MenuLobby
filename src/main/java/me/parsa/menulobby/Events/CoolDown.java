package me.parsa.menulobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;
import java.util.UUID;

public class CoolDown implements Listener {
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final int COOLDOWN_TIME = 5;


    @EventHandler
    public void onCommandpre(PlayerCommandPreprocessEvent e) {
        UUID playerUUID = e.getPlayer().getUniqueId();
        long currentTime = System.currentTimeMillis();
        String command = e.getMessage();
        String playerName = e.getPlayer().getName();

        Bukkit.getLogger().info(ChatColor.YELLOW + playerName + " executed command: " + ChatColor.GRAY + command);

        if (cooldowns.containsKey(playerUUID)) {
            long lastused = cooldowns.get(playerUUID);
            long timeElapsed = (currentTime - lastused) / 1000;

            if (timeElapsed < COOLDOWN_TIME) {
                if (!e.getPlayer().hasPermission("menulobby.admin")) {
                    long timeRemaining = COOLDOWN_TIME - timeElapsed;
                    e.getPlayer().sendMessage(ChatColor.RED + "You must wait " + timeRemaining + " seconds before using another command.");
                    e.setCancelled(true);
                    return;
                }
            }
        }
        cooldowns.put(playerUUID, currentTime);
    }
}
