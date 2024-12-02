package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.BanMenuUtils;
import me.parsa.menulobby.utils.KickMenuUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class KickInventoryListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("Kick List")) {

            if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                if (whoToBan != null && !whoToBan.equals(p)) {
                    whoToBan.kickPlayer(ChatColor.RED + "You ave been kicked by " + p.getName());
                } else if (whoToBan.equals(p)) {
                    whoToBan.sendMessage(ChatColor.RED + "You Can't Ban your self");

                } else {
                    p.sendMessage("Cannot Ban");
                }


            }
            e.setCancelled(true);
        }


    }

}
