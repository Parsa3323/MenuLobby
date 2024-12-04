package me.parsa.menulobby.Events;

import me.parsa.menulobby.Discord.WebHookSender;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerPreJoin implements Listener {

    private String webhook_url;

    private boolean is_enabled_web;

    public PlayerPreJoin(String webhook_url, boolean is_enabled_web) {
        this.is_enabled_web = is_enabled_web;
        this.webhook_url = webhook_url;
    }

    @EventHandler
    public void onPre(AsyncPlayerPreLoginEvent e) {
        if (is_enabled_web) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " This is the new handler for sending webhooks this makes the server less laggy hope you enjoy <3");
            WebHookSender.sendWebhookMessage(e.getName() + " Joined the server ", webhook_url);
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " If you disabled webhooks i made it less laggy you can test hope you enjoy <3");
        }
    }

}
