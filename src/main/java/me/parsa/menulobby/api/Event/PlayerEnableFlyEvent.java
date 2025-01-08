package me.parsa.menulobby.api.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class PlayerEnableFlyEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    Player player;

    Player target;

    public Player getPlayer() {
        return player;
    }

    public Player getTarget() {
        return target;
    }

    public PlayerEnableFlyEvent(Player player, Player target) {
        this.player = player;
        this.target = target;
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
