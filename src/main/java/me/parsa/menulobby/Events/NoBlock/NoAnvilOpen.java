package me.parsa.menulobby.Events.NoBlock;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;

public class NoAnvilOpen implements Listener {

    private final World targetWorld;

    private boolean is_enabled;

    private String no_perm;

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    public NoAnvilOpen(Plugin pl, boolean is_enabled, String no_perm) {
        this.is_enabled = is_enabled;
        this.no_perm = no_perm;
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void onAnvileOpen(InventoryOpenEvent e) {
        if (e.getPlayer().getWorld().equals(spawn_world)) {
            if (is_enabled) {
                if (!e.getPlayer().hasPermission("menulobby.anvil")) {
                    if (e.getInventory().getType() == InventoryType.ANVIL) {
                        e.getPlayer().sendMessage(no_perm);
                        e.setCancelled(true);
                    }
                }

            }
        }

    }

}
