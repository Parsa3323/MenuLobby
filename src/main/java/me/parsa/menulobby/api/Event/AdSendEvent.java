package me.parsa.menulobby.api.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class AdSendEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    String adMessage;

    String adTitle;

    boolean Titles;

    List<Player> players;

    public AdSendEvent(String adMessage, String adTitle, List<Player> players) {
        this.adMessage = adMessage;
        this.adTitle = adTitle;
        this.players = players;
    }

    public boolean isTitles() {
        return Titles;
    }

    public String getAdMessage() {
        return adMessage;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public List<Player> getPlayers() {
        return players;
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
