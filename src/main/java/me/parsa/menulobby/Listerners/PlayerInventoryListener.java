package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.PlayerMenuUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerInventoryListener implements Listener {


    private Map<UUID, Long> playerLastInteractionTime = new HashMap<>();
    private Map<UUID, String> waitingForName = new HashMap<>();

    private String toxic;
    private String cheat;
    private String cross;

    public PlayerInventoryListener(String toxic, String cross, String cheat) {
        this.cheat = cheat;
        this.cross = cross;
        this.toxic = toxic;
    }

    @EventHandler
    public void onInv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("player menu")) {
            if (e.getCurrentItem().getType() == Material.ANVIL) {
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(22).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                PlayerMenuUtils.openWarnMenu(p, target);
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(22).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "Server Said", null, null);
                target.kickPlayer("Banned");
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                p.sendMessage(ChatColor.GREEN + "Banned " + name);

            } else if (e.getCurrentItem().getType() == Material.REDSTONE) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(22).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                target.kickPlayer(ChatColor.RED + "You have been kicked by " + p.getName());
                p.sendMessage(ChatColor.GREEN + "success");


            } else if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(22).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                p.teleport(target.getLocation());
                p.sendMessage(ChatColor.GREEN + "Teleported to " + target.getName());

            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase("warn")) {
            if (e.getCurrentItem().getType() == Material.BOW) {
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                target.sendMessage(ChatColor.GOLD + "========== Warn! =========");
                target.sendMessage(ChatColor.AQUA + "" + cheat);
                target.sendMessage(ChatColor.GREEN + "Warned by: " + p.getName());
                target.sendMessage(ChatColor.GOLD + "===========================");
            } else if (e.getCurrentItem().getType() == Material.REDSTONE) {
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
//                target.sendMessage(cross);
                target.sendMessage(ChatColor.GOLD + "========== Warn! =========");
                target.sendMessage(ChatColor.AQUA + "" + cross);
                target.sendMessage(ChatColor.GREEN + "Warned by: " + p.getName());
                target.sendMessage(ChatColor.GOLD + "===========================");
            } else if (e.getCurrentItem().getType() == Material.ENDER_STONE) {
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                target.sendMessage(ChatColor.GOLD + "========== Warn! =========");
                target.sendMessage(ChatColor.AQUA + "" + toxic);
                target.sendMessage(ChatColor.GREEN + "Warned by: " + p.getName());
                target.sendMessage(ChatColor.GOLD + "===========================");
            }

        }
    }


}
