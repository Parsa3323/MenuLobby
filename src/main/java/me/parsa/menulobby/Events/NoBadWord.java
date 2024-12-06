package me.parsa.menulobby.Events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.List;

public class NoBadWord implements Listener {

    private List<String> blockedCustom;

    private final List<String> blockedWords = Arrays.asList("fuck", "bitch", "nigga");

    public NoBadWord(List<String> blockedCustom) {
        this.blockedCustom = blockedCustom;
    }

    List<String> wordsToCheck = (blockedCustom != null && !blockedCustom.isEmpty()) ? blockedCustom : blockedWords;

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        Player p = e.getPlayer();

        for (String word : wordsToCheck) {
            if (msg.contains(word.toLowerCase())) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "You can't type '" + msg + "' ");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1 , 1);
            }
        }

    }

}
