package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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
        lore.add(ChatColor.YELLOW + "Click to Open");

        ItemStack playerh = new ItemStack(Material.SKULL_ITEM, 1, (short) 1);
        ItemMeta playerh_meta = playerh.getItemMeta();
        playerh_meta.setDisplayName(ChatColor.DARK_PURPLE + player.getName());
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
        mmeta.setDisplayName(ChatColor.AQUA + "Warn " + player.getName());
        mmeta.setLore(lore);
        msg.setItemMeta(mmeta);
        menu.setItem(4, msg);

        if (main.hasPermission("menulobby.admin")) {
            main.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
            main.openInventory(menu);
        } else {
            player.sendMessage(ChatColor.RED + "You don't have permission");
        }



    }
    public static void openWarnMenu(Player player, Player target) {
        Inventory confirm = Bukkit.createInventory(player, 9, "warn");

        ArrayList<String> lore = new ArrayList<>();
        lore.add("   ");
        lore.add("   ");
        lore.add(ChatColor.YELLOW + "Click to Open");

        ItemStack cheat = new ItemStack(Material.BOW, 1);
        ItemMeta cheatmeta = cheat.getItemMeta();
        cheatmeta.setDisplayName(ChatColor.RED + "Cheat");
        cheatmeta.setLore(lore);
        cheat.setItemMeta(cheatmeta);
        confirm.setItem(0, cheat);

        ItemStack toxic = new ItemStack(Material.ENDER_STONE, 1);
        ItemMeta toxicmeta = toxic.getItemMeta();
        toxicmeta.setLore(lore);
        toxicmeta.setDisplayName(ChatColor.AQUA + "Toxicity");
        toxic.setItemMeta(toxicmeta);
        confirm.setItem(6, toxic);

        ItemStack cross = new ItemStack(Material.REDSTONE, 1);
        ItemMeta cmeta = cross.getItemMeta();
        cmeta.setDisplayName(ChatColor.RED + "cross-teaming");
        cmeta.setLore(lore);
        cross.setItemMeta(cmeta);
        confirm.setItem(2, cross);

        ItemStack players = new ItemStack(Material.SKULL_ITEM, 1, (short) 1);
        ItemMeta playerMeta = players.getItemMeta();
        playerMeta.setDisplayName(target.getName());
        players.setItemMeta(playerMeta);
        confirm.setItem(4, players);

        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Back");
        backMeta.setLore(lore);
        back.setItemMeta(backMeta);
        confirm.setItem(8, back);

        if (player.hasPermission("menulobby.admin")) {
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
            player.openInventory(confirm);
        } else {
            player.sendMessage(ChatColor.RED + "You don't have permission");
        }

    }

}
