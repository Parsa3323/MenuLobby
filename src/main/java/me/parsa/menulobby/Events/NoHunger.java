package me.parsa.menulobby.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHunger implements Listener {

    @EventHandler
    public void onFoodCHange(FoodLevelChangeEvent e) {
        // doesn't allow to get hunger
        if (e.getEntity() instanceof org.bukkit.entity.Player) {
            e.setCancelled(true);
        }
    }
}
