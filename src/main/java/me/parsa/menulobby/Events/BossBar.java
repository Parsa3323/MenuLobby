package me.parsa.menulobby.Events;


import me.parsa.menulobby.MenuLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BossBar implements Listener {
    private MenuLobby plugin;



    public BossBar(MenuLobby pl) {
        this.plugin = pl;
    }
    @EventHandler
    public void playerJoined(PlayerJoinEvent e){

        Player p = e.getPlayer();

        e.getPlayer().sendTitle(
                "Welcome!",      // Title
                "Enjoy your stay!" // Subtitle// Fade-in duration (ticks// Stay duration (ticks)// Fade-out duration (ticks)
        );
    }
}
