package me.parsa.menulobby.Events;

import me.parsa.menulobby.MenuLobby;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.inventivetalent.bossbar.BossBarAPI;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class OnPlayerJoin implements Listener {

    boolean msgE;

    private String score_title;

    private boolean is_achievements;

    private final MenuLobby pl;

    private String server_ip;

    public OnPlayerJoin(MenuLobby pl, boolean msgE, String server_ip, String score_title, boolean is_achievements) {
        this.msgE = msgE;
        this.pl = pl;
        this.is_achievements = is_achievements;
        this.score_title = score_title;
        this.server_ip = server_ip;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {


        Player p = e.getPlayer();
        pl.createScoreboard(p, server_ip, score_title);

        p.sendMessage("Welcome");
        if (msgE) {
            e.setJoinMessage(ChatColor.GREEN + "Welcome " + p.getName());
        } else {
            e.setJoinMessage(null);
        }
        if (is_achievements) {
            if (!p.hasPlayedBefore()) {
                p.sendMessage(ChatColor.GOLD + "=== Achievement Unlocked ===");
                p.sendMessage(ChatColor.AQUA + "Welcome to the server!");
                p.sendMessage(ChatColor.GREEN + "Achievement: First Join");
                p.sendMessage(ChatColor.GOLD + "===========================");
            }
        }
        p.sendTitle(ChatColor.GREEN + "Welcome" + " " + p.getName(), ChatColor.AQUA + "Enjoy Your Time");
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
        pl.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + p.getName() + " Joined The server say hi");
        int playTimeTicks = p.getStatistic(org.bukkit.Statistic.PLAY_ONE_TICK);
        int playTimeMinutes = playTimeTicks / (20 * 60); // Convert ticks to minutes
        if (is_achievements) {
            if (playTimeMinutes > 600) { // 600 minutes = 10 hours
                p.sendMessage(ChatColor.GOLD + "=== Achievement Unlocked ===");
                p.sendMessage(ChatColor.AQUA + "You've played over 10 hours!");
                p.sendMessage(ChatColor.GREEN + "Achievement: Time Well Spent");
                p.sendMessage(ChatColor.GOLD + "===========================");
            }
        }
        //System.out.printf(p.getName() + "Joined The server");
    }
}
