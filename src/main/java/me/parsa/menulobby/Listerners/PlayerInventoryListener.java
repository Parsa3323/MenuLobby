package me.parsa.menulobby.Listerners;

import me.parsa.menulobby.utils.PlayerMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

    private Plugin pl;

    private Map<UUID, Long> playerLastInteractionTime = new HashMap<>();
    private Map<UUID, String> waitingForName = new HashMap<>();

    public PlayerInventoryListener(Plugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onInv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("player menu")) {
            if (e.getCurrentItem().getType() == Material.ANVIL) {
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(22).getItemMeta().getDisplayName());
                Player target = Bukkit.getPlayer(name);
                p.sendMessage(ChatColor.GREEN + "Please type the message: ");
                startWaitingForName(p);
            }
            e.setCancelled(true);
        }
    }
    private void startWaitingForName(Player player) {
        // Store the player in a map with the expiration time (10 seconds)
        long expireTime = System.currentTimeMillis() + 10000; // 10 seconds from now
        playerLastInteractionTime.put(player.getUniqueId(), expireTime);

        // Set the flag that this player is waiting for input
        waitingForName.put(player.getUniqueId(), null);

        // Create a delayed task to handle the timeout
        Bukkit.getScheduler().runTaskLater(pl, () -> {
            if (waitingForName.containsKey(player.getUniqueId()) && waitingForName.get(player.getUniqueId()) == null) {
                // Timeout, no response received
                player.sendMessage("You took too long to provide a name for your pet!");
                waitingForName.remove(player.getUniqueId());
            }
        }, 200L); // 200L is 10 seconds (20 ticks per second)
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        if (waitingForName.containsKey(player.getUniqueId())) {
            event.setCancelled(true);

            // Get the player's response
            String message = event.getMessage();

            // Set the pet name or handle it further
            waitingForName.put(player.getUniqueId(), message);

            // Respond to the player
            player.sendMessage("sent: " + message);

            // Remove the player from the waiting list
            waitingForName.remove(player.getUniqueId());
        }

    }

}
