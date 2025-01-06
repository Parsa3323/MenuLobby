package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.api.Event.PlayerPanelOpenEvent;
import me.parsa.menulobby.utils.PlayerMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShiftInventoryListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();

        if (player.isSneaking() && event.getRightClicked() instanceof Player) {


            Player targetPlayer = (Player) event.getRightClicked();

            PlayerPanelOpenEvent eventCall = new PlayerPanelOpenEvent(targetPlayer, player);
            Bukkit.getServer().getPluginManager().callEvent(eventCall);
            if (!eventCall.isCancelled()) {
                PlayerMenuUtils.openPlayer(targetPlayer, player);
            }
        }
    }

}
