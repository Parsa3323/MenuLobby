package me.parsa.menulobby.Events;

import me.parsa.menulobby.Holidays.Holidays;
import me.parsa.menulobby.Holidays.Snow;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

public class NoRain implements Listener {

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    private final World targetWorld;

    public NoRain(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void OnRain(WeatherChangeEvent e) {

        Holidays.SpecialEvent currentEvent = Holidays.getCurrentEvent();

        if (e.getWorld().equals(spawn_world)) {
            if (e.toWeatherState()) {
                switch (currentEvent) {
                    case CHRISTMAS:
                        Snow.startSnowing(e.getWorld());
                    case HALLOWEEN:
                        System.out.println("Soon");
                    default:
                        e.setCancelled(true);
                }
            }
        }
    }
}
