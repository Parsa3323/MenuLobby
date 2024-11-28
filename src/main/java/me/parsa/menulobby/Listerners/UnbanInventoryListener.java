package me.parsa.menulobby.Listerners;

import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class UnbanInventoryListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        // Ensure the event involves a player
        if (!(e.getWhoClicked() instanceof Player)) return;

        Player p = (Player) e.getWhoClicked();

        // Check if the inventory title matches
        if (!e.getView().getTitle().equalsIgnoreCase("Select Unban")) return;

        // Prevent NullPointerException on empty slots
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() != Material.SKULL_ITEM || !clickedItem.hasItemMeta()) return;

        // Get the clicked player's name from the item
        String playerName = ChatColor.stripColor(clickedItem.getItemMeta().getDisplayName());
        if (playerName == null || playerName.isEmpty()) return;

        // Unban the player by name
        p.getServer().getBanList(BanList.Type.NAME).pardon(playerName);
        p.sendMessage(ChatColor.GREEN + "Successfully unbanned " + playerName + "!");
        p.closeInventory(); // Optional: Close the inventory after unbanning
    }
}
