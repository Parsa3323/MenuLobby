package me.parsa.menulobby.api.Event;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerTeleportLobbyEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    Player player;

    Location lobbyLocation;

    public PlayerTeleportLobbyEvent(Player player, Location lobbyLocation) {
        this.lobbyLocation = lobbyLocation;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;

    }

}
