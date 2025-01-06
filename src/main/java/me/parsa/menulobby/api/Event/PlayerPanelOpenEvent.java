package me.parsa.menulobby.api.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;



public class PlayerPanelOpenEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    Player target;

    Player player;


    public PlayerPanelOpenEvent(Player target, Player player) {
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

    public Player getTarget() {
        return target;
    }

    public Player getPlayer() {
        return player;
    }

}
