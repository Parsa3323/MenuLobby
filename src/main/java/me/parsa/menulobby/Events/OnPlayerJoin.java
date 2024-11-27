package me.parsa.menulobby.Events;

import me.parsa.menulobby.MenuLobby;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.inventivetalent.bossbar.BossBarAPI;

import java.util.HashMap;
import java.util.Map;

public class OnPlayerJoin implements Listener {

    boolean msgE;

    private final MenuLobby pl;

    public OnPlayerJoin(MenuLobby pl, boolean msgE) {
        this.msgE = msgE;
        this.pl = pl;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        pl.createScoreboard(p);

        p.sendMessage("Welcome");
        if (msgE) {
            e.setJoinMessage(ChatColor.GREEN + "Welcome" + p.getName());
        } else {
            e.setJoinMessage(null);
        }

        p.sendTitle("Welcome"+ p.getName(), "tewt2");
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
        System.out.printf("Yoooooooooooo");
    }
}
