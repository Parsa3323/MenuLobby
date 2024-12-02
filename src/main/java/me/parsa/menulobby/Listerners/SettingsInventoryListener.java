package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.utils.*;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingsInventoryListener implements Listener {

    private MenuLobby ml;

    public SettingsInventoryListener(MenuLobby ml) {
        this.ml = ml;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("Settings")) {
//sd
            if (e.getCurrentItem().getType() == Material.REDSTONE) {

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                BanMenuUtils.openBanMenu(p);

            } else if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                KickMenuUtils.openBanMenu(p);

            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                UnbanMenuUtils.openBanMenu(p);

            } else if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                TpMenuUtils.openTpMenu(p);
            } else if (e.getCurrentItem().getType() == Material.ENDER_STONE) {
                PartyMenuUtils.openPartyMenu(ml, p);
            }
            e.setCancelled(true);

        }




    }
}
