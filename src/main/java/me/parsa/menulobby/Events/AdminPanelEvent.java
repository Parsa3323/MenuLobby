package me.parsa.menulobby.Events;

import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.utils.SettingsMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminPanelEvent implements Listener {


    private JavaPlugin plugin;

    private MenuLobby ml;

    public AdminPanelEvent(JavaPlugin plugin, MenuLobby ml) {
        this.plugin = plugin;
        this.ml = ml;
    }

    @EventHandler
    public void onPlayerChange(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInHand() == null || p.getInventory().getItemInHand().getType() == Material.AIR) {
            return;
        }

        ItemStack item = p.getInventory().getItemInHand();
        if (item.hasItemMeta() && item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Admin Panel")) {
            SettingsMenuUtils.openSettings(p, ml);
            e.setCancelled(true);
        }

    }

}
