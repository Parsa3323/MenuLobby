package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SettingsMenuUtils {

    public static void openSettings(Player player) {

        Inventory settings = Bukkit.createInventory(player, 45, "Settings");

        ItemStack ban = new ItemStack(Material.REDSTONE,1);
        ItemMeta ban_meta = ban.getItemMeta();

        ban_meta.setDisplayName(ChatColor.DARK_RED + "BanMenu");
        ban.setItemMeta(ban_meta);

        settings.setItem(4, ban);

        ItemStack kick = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(ChatColor.GOLD + "Kick Players");
        kick.setItemMeta(kick_meta);
        settings.setItem(24, kick);

        ItemStack unban = new ItemStack(Material.BARRIER, 1);
        ItemMeta unban_meta = unban.getItemMeta();
        unban_meta.setDisplayName(ChatColor.GOLD+"Unban");
        unban.setItemMeta(unban_meta);
        settings.setItem(20, unban);

        player.openInventory(settings);




    }
}
