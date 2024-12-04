package me.parsa.menulobby.Events;

import me.parsa.menulobby.MenuLobby;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class TagListener implements Listener {

    private MenuLobby pl;

    public TagListener(MenuLobby pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            String playerName = onlinePlayer.getName();

            if (message.equalsIgnoreCase(playerName) || message.contains(playerName)) {
                pl.adventure().player(onlinePlayer).sendActionBar(Component.text("You Got Tagged By " + p.getName()).color(NamedTextColor.GREEN));
            }
        }
    }

}
