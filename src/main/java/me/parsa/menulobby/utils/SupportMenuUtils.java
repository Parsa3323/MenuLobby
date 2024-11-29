package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class SupportMenuUtils {

    public static void openSupport(Player player) {
        Inventory support = Bukkit.createInventory(player, 45, "Support");


        ArrayList<String> lore = new ArrayList<>();
        lore.add("   ");
        lore.add("   ");
        lore.add(ChatColor.YELLOW + "Click to Open");
        ItemStack discord = new ItemStack(Material.CARROT_ITEM, 1, (short) 3);
        ItemMeta discord_meta = discord.getItemMeta();
        discord_meta.setDisplayName(ChatColor.DARK_PURPLE + "Discord");
        discord_meta.setLore(lore);
        discord.setItemMeta(discord_meta);
        support.setItem(24, discord);

        ItemStack WebSite = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta WebSiteMeta = WebSite.getItemMeta();
        WebSiteMeta.setDisplayName(ChatColor.GOLD + "Website");
        WebSiteMeta.setLore(lore);
        WebSite.setItemMeta(WebSiteMeta);
        support.setItem(22, WebSite);

        ItemStack store = new ItemStack(Material.FLOWER_POT_ITEM, 1, (short) 3);
        ItemMeta store_meta = store.getItemMeta();
        store_meta.setDisplayName(ChatColor.AQUA + "Store");
        store_meta.setLore(lore);
        store.setItemMeta(store_meta);
        support.setItem(20, store);

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
        player.openInventory(support);

    }

}
