package me.parsa.menulobby.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    private String on_join;

    boolean isEnabled;

    public ChatEvent(String on_join, boolean isEnabled) {
        this.on_join = on_join;
        this.isEnabled = isEnabled;
    }

    @EventHandler
    public void onMsg(AsyncPlayerChatEvent e) {
        if (isEnabled) {
            if (e.isCancelled()) {
                return;
            }
            String msg = e.getMessage();
            Player p = e.getPlayer();

//        System.out.println("Sent");

            e.setCancelled(true);

            String made_msg = PlaceholderAPI.setPlaceholders(p, on_join);
//        System.out.println("Someone sent message " + on_join + msg);

            Bukkit.broadcastMessage(made_msg);
        }

    }

}
