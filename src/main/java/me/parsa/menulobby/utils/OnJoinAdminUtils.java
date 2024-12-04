package me.parsa.menulobby.utils;

import me.parsa.menulobby.MenuLobby;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class OnJoinAdminUtils {

    private static MenuLobby ml;

    public OnJoinAdminUtils(MenuLobby ml) {
        this.ml = ml;
    }

    public static void giveAdmin(Player player) {
        ItemStack firework = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
        ItemMeta fireworkMeta = firework.getItemMeta();
        fireworkMeta.setDisplayName(ChatColor.RED + "Admin Panel");
        firework.setItemMeta(fireworkMeta);
        player.getInventory().setItem(3, firework);
    }

}
