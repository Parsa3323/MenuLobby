package me.parsa.menulobby.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.parsa.menulobby.Commands.mstaffchat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatEvent implements Listener {

    private String on_join;

    boolean isEnabled;

    private mstaffchat mstaffchat;

    public ChatEvent(String on_join, boolean isEnabled, mstaffchat mstaffchat) {
        this.on_join = on_join;
        this.mstaffchat = mstaffchat;
        this.isEnabled = isEnabled;
    }

    @EventHandler
    public void onMsg(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();


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
