package me.parsa.menulobby.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StatsMenuUtils {

    public static void createMenu(Player p, Player target) {
        Inventory stats = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Stats");

        ItemStack head_1 = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
        ItemMeta head_meta = head_1.getItemMeta();
        String playerkills = PlaceholderAPI.setPlaceholders(target, "%bw1058_stats_kills%");
        head_meta.setDisplayName(ChatColor.GREEN + "Kills" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + playerkills);
        head_1.setItemMeta(head_meta);
        stats.setItem(4, head_1);

        String playerprog = PlaceholderAPI.setPlaceholders(target, "%bw1058_player_progress%");
        ItemStack head_2 = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
        ItemMeta head_2_meta = head_2.getItemMeta();
        head_2_meta.setDisplayName(ChatColor.GREEN + "progress" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + playerprog);
        head_2.setItemMeta(head_2_meta);
        stats.setItem(24, head_2);


        String beddestroyed = PlaceholderAPI.setPlaceholders(target, "%bw1058_stats_bedsdestroyed%");
        ItemStack head_3 = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
        ItemMeta head_3_meta = head_3.getItemMeta();
        head_3_meta.setDisplayName(ChatColor.GREEN + "bed-destroyed" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + beddestroyed);
        head_3.setItemMeta(head_3_meta);
        stats.setItem(20, head_3);


        String finalkills = PlaceholderAPI.setPlaceholders(target, "%bw1058_stats_finalkills%");
        ItemStack head_4 = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
        ItemMeta head_4_meta = head_4.getItemMeta();
        head_4_meta.setDisplayName(ChatColor.GREEN + "finalkills" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + finalkills);
        head_4.setItemMeta(head_4_meta);
        stats.setItem(40, head_4);

        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
        p.openInventory(stats);

    }


}
