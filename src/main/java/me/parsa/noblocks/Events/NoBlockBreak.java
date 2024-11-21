package me.parsa.noblocks.Events;

import me.parsa.noblocks.Noblocks;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.configuration.file.FileConfiguration;

import javax.xml.bind.Unmarshaller;

public class NoBlockBreak implements Listener {

    private String break_error;

    private boolean anvil_bol;

    private boolean is_not_open;

    private boolean isNotBreakable;

    private String open_error_ender;

    private Noblocks plugin;

    private String someValue;

    public NoBlockBreak(Noblocks plugin, String someValue, boolean anvil_bol, boolean is_not_breakable, String break_error, boolean is_not_open, String open_error_ender) {
        this.plugin = plugin;
        this.someValue = someValue;
        this.anvil_bol = anvil_bol;
        this.isNotBreakable = is_not_breakable;
        this.open_error_ender = open_error_ender;
        this.is_not_open = is_not_open;
        this.break_error = break_error;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if (isNotBreakable) {
            Player p = e.getPlayer();

            p.sendMessage(break_error);

            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onEnderOpen(InventoryOpenEvent e) {
        if (e.getInventory().getType() == InventoryType.ENDER_CHEST) {
            if (is_not_open) {
                e.getPlayer().sendMessage(open_error_ender);

                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onAnvilOpen(InventoryOpenEvent e){
        if (e.getInventory().getType() == InventoryType.ANVIL) {
            if (anvil_bol){
                e.getPlayer().sendMessage(someValue);

                e.setCancelled(true);
            }
        }

    }
}

