package me.parsa.menulobby.utils;

import me.parsa.menulobby.MenuLobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SettingsMenuUtils {

    public static void openSettings(Player player, MenuLobby ml) {

        Inventory settings = Bukkit.createInventory(player, 45, "Settings");

        ItemStack ban = new ItemStack(Material.REDSTONE,1);
        ItemMeta ban_meta = ban.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();
        lore.add("   ");
        lore.add("   ");
        lore.add(ChatColor.YELLOW + "Click to Open");
        ban_meta.setDisplayName(ChatColor.DARK_RED + "BanMenu");
        ban_meta.setLore(lore);
        ban.setItemMeta(ban_meta);

        settings.setItem(4, ban);

        ItemStack kick = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(ChatColor.GOLD + "Kick Players");
        kick_meta.setLore(lore);
        kick.setItemMeta(kick_meta);
        settings.setItem(24, kick);

        ItemStack unban = new ItemStack(Material.BARRIER, 1);
        ItemMeta unban_meta = unban.getItemMeta();
        unban_meta.setDisplayName(ChatColor.GOLD+"Unban");
        unban_meta.setLore(lore);
        unban.setItemMeta(unban_meta);
        settings.setItem(20, unban);

        ItemStack tp = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta tp_meta = tp.getItemMeta();
        tp_meta.setLore(lore);
        tp_meta.setDisplayName(ChatColor.AQUA + "Teleport");
        tp.setItemMeta(tp_meta);
        settings.setItem(40, tp);

        if (ml.getServer().getPluginManager().getPlugin("Parties") != null) {
            ItemStack part = new ItemStack(Material.ENDER_STONE, 1);
            ItemMeta part_meta = part.getItemMeta();
            part_meta.setLore(lore);
            part_meta.setDisplayName(ChatColor.BLUE + "Parties");
            part.setItemMeta(part_meta);
            settings.setItem(43, part);
        } else {
            ItemStack part = new ItemStack(Material.STAINED_GLASS_PANE, 1);
            ItemMeta part_meta = part.getItemMeta();
            part_meta.setDisplayName(ChatColor.GRAY + "Download parties plugin to use");
            part.setItemMeta(part_meta);
            settings.setItem(43, part);
        }





        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
        player.openInventory(settings);




    }
}
