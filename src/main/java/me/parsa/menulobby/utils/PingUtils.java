package me.parsa.menulobby.utils;

import org.bukkit.entity.Player;

public class PingUtils {

    public static int getPing(Player player) {
        try {
            // Use reflection to access the ping value
            Object handle = player.getClass().getMethod("getHandle").invoke(player);
            return (int) handle.getClass().getField("ping").get(handle);
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return -1 if something goes wrong
        }
    }
}
