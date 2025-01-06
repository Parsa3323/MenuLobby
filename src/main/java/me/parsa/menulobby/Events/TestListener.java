package me.parsa.menulobby.Events;


import me.parsa.menulobby.api.Event.PlayerPanelOpenEvent;
import me.parsa.menulobby.api.Event.WebhookSendEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;



public class TestListener implements Listener {

    @EventHandler
    public void onWebhook(WebhookSendEvent e) {
        String player_name = e.getName();

        e.setCancelled(true);
        System.out.println("Webhook sent to: " + player_name + " has been canceled ");
    }

    @EventHandler
    public void onPanelOpen(PlayerPanelOpenEvent e) {
        Player target = e.getTarget();

        Player player = e.getPlayer();

        e.setCancelled(true);
        System.out.println("Panel open event from " + player.getName() + " to " + target.getName() + " has been canceled");
    }

}
