package me.parsa.menulobby.Events.NoBlock;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class NoBlockBreak implements Listener {
    private final World targetWorld;

    private String no_block_message;

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    private boolean is_enabled;

    private boolean is_one_world;

    public NoBlockBreak(Plugin pl, String no_block_message, boolean is_enabled, boolean is_one_world) {
        this.no_block_message = no_block_message;
        this.is_enabled = is_enabled;
        this.targetWorld = pl.getServer().getWorld("0");
        this.is_one_world = is_one_world;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (is_one_world) {
            if (p.getWorld().equals(spawn_world)) {
                if (is_enabled) {
                    if (p.hasPermission("menulobby.breakblocks")) {
                        e.setCancelled(false);
                    } else {
                        p.sendMessage(no_block_message);
                        e.setCancelled(true);
                    }
                }
            }
        } else {
            if (is_enabled) {
                if (p.hasPermission("menulobby.breakblocks")) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            }
        }

    }

}
