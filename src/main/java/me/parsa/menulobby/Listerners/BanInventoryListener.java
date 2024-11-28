package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanInventoryListener implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("Player List")) {

            if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                BanMenuUtils.openConfigrmBanMenu(p, whoToBan);

            }

        } else if (e.getView().getTitle().equalsIgnoreCase("Ban Con")) {
            System.out.println("opened You Want to ban? ------------------------");

            if (e.getCurrentItem().getType() == Material.BARRIER) {
                BanMenuUtils.openBanMenu(p);

            } else if (e.getCurrentItem().getType() == Material.REDSTONE) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "Server Said", null, null);
                p.sendMessage(ChatColor.GREEN + "Banned" + name);


            }

        }
        e.setCancelled(true);

    }

}
