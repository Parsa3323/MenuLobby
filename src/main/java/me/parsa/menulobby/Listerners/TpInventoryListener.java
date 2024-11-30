package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.BanMenuUtils;
import me.parsa.menulobby.utils.TpMenuUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TpInventoryListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("Tp List")) {

            if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {

                Player whoToTp = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                TpMenuUtils.confirmTp(p, whoToTp);

            }

        } else if (e.getView().getTitle().equalsIgnoreCase("confirm tp")) {

            if (e.getCurrentItem().getType() == Material.BARRIER) {
                BanMenuUtils.openBanMenu(p);

            } else if (e.getCurrentItem().getType() == Material.POTATO_ITEM) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                Player ps = Bukkit.getPlayer(name);

                p.teleport(ps.getLocation());
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
                p.sendMessage(ChatColor.GREEN + "Successfully teleported you to " + ps.getName());
                ps.sendMessage(ChatColor.AQUA + p.getName() + " teleported to you");
//                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "Server Said", null, null);
//                p.sendMessage(ChatColor.GREEN + "Banned" + name);


            } else if (e.getCurrentItem().getType() == Material.CARROT_ITEM) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                Player ps = Bukkit.getPlayer(name);

                ps.teleport(p.getLocation());
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
                p.sendMessage(ChatColor.GREEN + "Teleported " + ps.getName() + " to you");
                ps.sendMessage(ChatColor.AQUA + p.getName() + " Teleported you");

            }

        }
        e.setCancelled(true);

    }

}
