package me.parsa.menulobby.Events.NoBlock;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class NoChestOpen implements Listener {
    private boolean is_enabled;

    private String no_perm;

    private boolean is_one_world;

    private final World targetWorld;

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    public NoChestOpen(Plugin pl, boolean is_enabled, String no_perm, boolean is_one_world) {
        this.is_enabled = is_enabled;
        this.is_one_world = is_one_world;
        this.no_perm= no_perm;
        this.targetWorld = pl.getServer().getWorld("0");
    }

//    @EventHandler
//    public void onInvOpen(InventoryOpenEvent e) {
//        if (is_enabled) {
//            if (is_one_world) {
//                if (e.getPlayer().getWorld().equals(spawn_world)) {
//                    if (e.getInventory().getType() == InventoryType.CHEST || e.getInventory().getType() == InventoryType.ENDER_CHEST) {
//                        if (e.getPlayer().hasPermission("menulobby.chest")) {
//                            e.setCancelled(false);
//                            System.out.println("Event triggered: " + e.getInventory().getType());
//                        } else {
//                            e.getPlayer().sendMessage(no_perm);
//                            e.setCancelled(true);
//                            System.out.println("Event triggered: " + e.getInventory().getType());
//
//                        }
//                    }
//                }
//            } else {
//                if (e.getInventory().getType() == InventoryType.CHEST || e.getInventory().getType() == InventoryType.ENDER_CHEST) {
//                    if (e.getPlayer().hasPermission("menulobby.chest")) {
//                        e.setCancelled(false);
//                        System.out.println("Event triggered: " + e.getInventory().getType());
//
//                    } else {
//                        e.getPlayer().sendMessage(no_perm);
//                        e.setCancelled(true);
//                        System.out.println("Event triggered: " + e.getInventory().getType());
//
//                    }
//                }
//            }
//
//        }
//    }

    @EventHandler
    public void oninvo(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block clickedBlock = e.getClickedBlock();
            if (clickedBlock != null && (clickedBlock.getType() == Material.CHEST || clickedBlock.getType() == Material.ENDER_CHEST)) {

                BlockState state = clickedBlock.getState();

                if (state instanceof Chest || state.getType() == Material.ENDER_CHEST) {
                    if (is_enabled) {
                        if (is_one_world) {
                            if (e.getPlayer().getWorld().equals(spawn_world)) {
                                if (e.getPlayer().hasPermission("menulobby.chest")) {
                                    e.setCancelled(false);

                                } else {
                                    e.getPlayer().sendMessage(no_perm);
                                    e.setCancelled(true);


                                }
                            }
                        } else {
                            if (e.getPlayer().hasPermission("menulobby.chest")) {
                                e.setCancelled(false);
                            } else {
                                e.getPlayer().sendMessage(no_perm);
                                e.setCancelled(true);
                            }
                        }
                    }
                }
            }

        }


    }

}
