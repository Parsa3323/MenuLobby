package me.parsa.menulobby.utils;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Set;

public class UnbanMenuUtils {
    public static void openBanMenu(Player player) {
        // Retrieve all banned entries
        Set<BanEntry> banEntries = Bukkit.getBanList(BanList.Type.NAME).getBanEntries();

        // Create the inventory for the GUI
        Inventory bangui = Bukkit.createInventory(player, 45, "Select Unban");

        // Iterate over the banned entries and create items
        for (BanEntry banEntry : banEntries) {
            String bannedPlayerName = banEntry.getTarget();

            ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(ChatColor.YELLOW + bannedPlayerName); // Use the banned player's name
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Banned Reason: " + ChatColor.RED + banEntry.getReason());
            lore.add(ChatColor.GOLD + "Banned Date: " + ChatColor.AQUA + banEntry.getCreated().toString());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            bangui.addItem(playerHead); // Add the item to the inventory
        }

        // Check permissions and open the GUI for the player
        if (player.hasPermission("menulobby.unban")) {
            player.openInventory(bangui);
        }
    }
}
