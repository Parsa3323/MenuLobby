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

    private Noblocks plugin;

    private String someValue;

    public NoBlockBreak(Noblocks plugin, String someValue) {
        this.plugin = plugin;
        this.someValue = someValue;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        Player p = e.getPlayer();

        p.sendMessage("§cYou can't break blocks Sorry");

        e.setCancelled(true);


    }
    @EventHandler
    public void onAnvilOpen(InventoryOpenEvent e){
        if (e.getInventory().getType() == InventoryType.ANVIL) {
            e.getPlayer().sendMessage("Sorry anvils are disabled on this server");

            e.setCancelled(true);

        }

    }
}

