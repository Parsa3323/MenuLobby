package me.parsa.menulobby.Placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChatPapi extends PlaceholderExpansion implements Listener {

    private final Map<UUID, String> playerMessages = new HashMap<>();

    @Override
    public @NotNull String getIdentifier() {
        return "MenuLobby";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Parsa";
    }

    @Override
    public @NotNull String getVersion() {
        return "5.8";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return " ";
        }
        if (params.equalsIgnoreCase("message")) {
            return playerMessages.getOrDefault(player.getUniqueId(), "No message");
        }
        if (params.equalsIgnoreCase("username")) {
            return player.getName();
        }

        return params;
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        // Store the player's message
        playerMessages.put(player.getUniqueId(), message);
    }
}
