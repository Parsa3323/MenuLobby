package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SupportInventoryListener implements Listener {

    private String discord;

    private String website;

    private String store;

    public SupportInventoryListener(String discord, String website, String store) {
        this.discord = discord;
        this.website = website;
        this.store = store;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("Support")) {

            if (e.getCurrentItem().getType() == Material.CARROT_ITEM) {
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
                p.sendMessage(ChatColor.GREEN  + "§lDiscord " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + discord);

            } else if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
                p.sendMessage(ChatColor.GREEN  + "§lWebsite " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + website);

            } else if (e.getCurrentItem().getType() == Material.FLOWER_POT_ITEM) {
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
                p.sendMessage(ChatColor.GREEN  + "§lStore " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + store);

            }

            e.setCancelled(true);
        }


    }

}
