package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerMenuUtils {
    public static void openPlayer(Player player, Player main) {

        Inventory menu = Bukkit.createInventory(player, 45, "player menu");

        ArrayList<String> lore = new ArrayList<>();
        lore.add("   ");
        lore.add("   ");

        ItemStack playerh = new ItemStack(Material.SKULL_ITEM, 1, (short) 1);
        ItemMeta playerh_meta = playerh.getItemMeta();
        playerh_meta.setDisplayName(ChatColor.DARK_PURPLE + player.getName());
        playerh_meta.setLore(lore);
        playerh.setItemMeta(playerh_meta);
        menu.setItem(22, playerh);

        ItemStack teleport = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta tpmeta = teleport.getItemMeta();
        tpmeta.setLore(lore);
        tpmeta.setDisplayName(ChatColor.BLUE + "Teleport to " + player.getName());
        teleport.setItemMeta(tpmeta);
        menu.setItem(20, teleport);

        ItemStack kick = new ItemStack(Material.REDSTONE, 1);
        ItemMeta kick_meta = kick.getItemMeta();
        kick_meta.setDisplayName(ChatColor.GOLD + "kick " + player.getName());
        kick_meta.setLore(lore);
        kick.setItemMeta(kick_meta);
        menu.setItem(24, kick);

        ItemStack ban = new ItemStack(Material.BARRIER, 1);
        ItemMeta banmeta = ban.getItemMeta();
        banmeta.setLore(lore);
        banmeta.setDisplayName(ChatColor.RED + "Ban " + player.getName());
        ban.setItemMeta(banmeta);
        menu.setItem(40, ban);

        ItemStack msg = new ItemStack(Material.ANVIL, 1);
        ItemMeta mmeta = msg.getItemMeta();
        mmeta.setDisplayName(ChatColor.AQUA + "msg " + player.getName());
        mmeta.setLore(lore);
        msg.setItemMeta(mmeta);
        menu.setItem(4, msg);

        main.openInventory(menu);

    }
    public static void openAnvilGUI(Player player) {

        Inventory anvilInventory = Bukkit.createInventory(null, 9, "Anvil");


        ItemStack placeholderItem = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = placeholderItem.getItemMeta();
        meta.setDisplayName("Rename Me!");
        placeholderItem.setItemMeta(meta);

        anvilInventory.setItem(0, placeholderItem);


        anvilInventory.setItem(1, new ItemStack(Material.NAME_TAG));


        anvilInventory.setItem(2, new ItemStack(Material.IRON_SWORD));


        player.openInventory(anvilInventory);
    }

}
