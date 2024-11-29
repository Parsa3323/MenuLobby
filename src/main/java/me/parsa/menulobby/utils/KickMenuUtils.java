package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KickMenuUtils {

    public static void openBanMenu(Player player) {
        ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

        Inventory kickgui = Bukkit.createInventory(player, 45, "Kick List");

        for (Player value : list) {
            ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(value.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + value.getHealth());
            lore.add(ChatColor.GOLD + "Xp: " + ChatColor.AQUA + value.getExp());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            kickgui.addItem(playerHead);
        }
        if (player.hasPermission("menulobby.ban")) {
            player.openInventory(kickgui);
        }
    }

}
