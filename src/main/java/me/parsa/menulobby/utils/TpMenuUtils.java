package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TpMenuUtils {

    public static void openTpMenu(Player player) {
        ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

        Inventory tpgui = Bukkit.createInventory(player, 45, "Tp List");

        for (Player value : list) {
            ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(value.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + value.getHealth());
            lore.add(ChatColor.GOLD + "Xp: " + ChatColor.AQUA + value.getExp());
            lore.add(ChatColor.GOLD + "Location: " + ChatColor.AQUA + value.getLocation());
            lore.add(" ");
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click To Teleport");
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            tpgui.addItem(playerHead);
        }
        if (player.hasPermission("menulobby.tp")) {
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
            player.openInventory(tpgui);
        }
    }
    public static void confirmTp(Player player, Player target) {
        Inventory confirm_menu = Bukkit.createInventory(player, 9, "confirm tp");

        ArrayList<String> lore = new ArrayList<>();
        ItemStack Me = new ItemStack(Material.POTATO_ITEM, 1);
        ItemMeta me_meta = Me.getItemMeta();
        me_meta.setDisplayName(ChatColor.GOLD + "Teleport me to " + target.getName());
        lore.add(" ");
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click To tp");
        me_meta.setLore(lore);
        Me.setItemMeta(me_meta);
        confirm_menu.setItem(0, Me);

        ItemStack him = new ItemStack(Material.CARROT_ITEM, 1);
        ItemMeta him_meta = him.getItemMeta();
        him_meta.setDisplayName(ChatColor.DARK_PURPLE + "Teleport " + target.getName() + " to me");
        him_meta.setLore(lore);
        him.setItemMeta(him_meta);
        confirm_menu.setItem(8, him);

        ItemStack user = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta user_meta = user.getItemMeta();
        user_meta.setDisplayName(player.getName());
        user.setItemMeta(user_meta);
        confirm_menu.setItem(4, user);

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
        player.openInventory(confirm_menu);
    }
}
