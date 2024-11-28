package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BanMenuUtils {

    public static void openBanMenu(Player player) {
        ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

        Inventory bangui = Bukkit.createInventory(player, 45, "Player List");

        for (Player value : list) {
            ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(value.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + value.getHealth());
            lore.add(ChatColor.GOLD + "Xp: " + ChatColor.AQUA + value.getExp());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            bangui.addItem(playerHead);
        }
        if (player.hasPermission("menulobby.ban")) {
            player.openInventory(bangui);
        }
    }

    public static void openConfigrmBanMenu(Player p, Player whoToBan) {
        Inventory confirmMenu = Bukkit.createInventory(p, 9,  "Ban Con");

        ItemStack ban = new ItemStack(Material.REDSTONE, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.DARK_RED + "Ban");
        ban.setItemMeta(ban_meta);
        confirmMenu.setItem(0, ban);

        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta player_meta = playerHead.getItemMeta();
        player_meta.setDisplayName(whoToBan.getDisplayName());
        playerHead.setItemMeta(player_meta);
        confirmMenu.setItem(4, playerHead);

        ItemStack nope = new ItemStack(Material.BARRIER, 1);
        ItemMeta nope_meta = ban.getItemMeta();
        nope_meta.setDisplayName(ChatColor.DARK_RED + "Nope");
        nope.setItemMeta(nope_meta);
        confirmMenu.setItem(8, nope);

        p.openInventory(confirmMenu);

    }
}
