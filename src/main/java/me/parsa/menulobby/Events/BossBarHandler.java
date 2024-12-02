package me.parsa.menulobby.Events;

import me.parsa.menulobby.MenuLobby;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BossBarHandler implements Listener {
    private final MenuLobby menuLobby;

    private boolean is_enabled;

    private String message;

    public BossBarHandler(MenuLobby menuLobby, boolean is_enabled, String message) {
        this.menuLobby = menuLobby;
        this.message = message;
        this.is_enabled = is_enabled;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();


        Audience audience = this.menuLobby.adventure().player(player);


        BossBar countdownBar = BossBar.bossBar(Component.text(message).color(NamedTextColor.WHITE), 0.5f, BossBar.Color.PINK, BossBar.Overlay.NOTCHED_10);
        if (is_enabled) {
            audience.showBossBar(countdownBar);
        }


    }

}
