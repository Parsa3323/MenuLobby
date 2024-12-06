package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.PlayerMenuUtils;
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
        // Check if the player is sneaking and right-clicking on an entity
        Player player = event.getPlayer();

        if (player.isSneaking() && event.getRightClicked() instanceof Player) {

            // Check if the player is right-clicking another player
            Player targetPlayer = (Player) event.getRightClicked();
            PlayerMenuUtils.openPlayer(targetPlayer, player);
        }
    }

}
