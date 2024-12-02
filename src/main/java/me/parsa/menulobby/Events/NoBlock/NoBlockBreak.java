package me.parsa.menulobby.Events.NoBlock;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class NoBlockBreak implements Listener {
    private final World targetWorld;

    private String no_block_message;

    private boolean is_enabled;

    public NoBlockBreak(Plugin pl, String no_block_message, boolean is_enabled) {
        this.no_block_message = no_block_message;
        this.is_enabled = is_enabled;
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().equals(targetWorld)) {
            if (is_enabled) {
                if (p.hasPermission("menulobby.breakblocks")) {
                    e.setCancelled(false);
                } else {
                    p.sendMessage(no_block_message);
                    e.setCancelled(true);
                }
            }
        }

    }

}
