package me.parsa.menulobby.Events;

import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

public class NoRain implements Listener {

    private final World targetWorld;

    public NoRain(Plugin pl) {
        this.targetWorld = pl.getServer().getWorld("0");
    }

    @EventHandler
    public void OnRain(WeatherChangeEvent e) {
        if (e.getWorld().equals(targetWorld)) {
            if (e.toWeatherState()) {
                e.setCancelled(true);
            }
        }
    }
}
