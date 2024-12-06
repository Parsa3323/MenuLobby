package me.parsa.menulobby.Holidays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Snow {

    public static void startSnowing(World p) {
        Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

        World spawn_world = spawnLocation.getWorld();
        if (p.equals(spawn_world)) {
            p.setStorm(true);
            p.setWeatherDuration(999999);
        }
    }

}
