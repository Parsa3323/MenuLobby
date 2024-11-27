package me.parsa.menulobby.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class NoDamage implements Listener {

    String no_perm;

    boolean isEnabled;

    public NoDamage(Plugin pl, String No_perm, boolean is_Enabled) {
        this.no_perm = No_perm;
        this.isEnabled = is_Enabled;

    }

    @EventHandler
    public void onPlayerDamagedSomeone(EntityDamageByEntityEvent e) {
        if (isEnabled) {
            Entity entity = e.getEntity();
            if (entity instanceof Player) {
                e.setCancelled(true);

                if (e.getDamager() instanceof Player) {
                    Player p = (Player) e.getDamager();
                    p.sendMessage(ChatColor.RED + no_perm);

                }
            }
        }
    }

}
