package me.parsa.noblocks;

import me.parsa.noblocks.Events.NoBlockBreak;
import org.bukkit.Color;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
//ds
import java.io.File;

public final class Noblocks extends JavaPlugin {

//sd

    @Override
    public void onEnable() {
        File configFile = new File(getDataFolder(), "config.yml");

        // Check if the config file exists, if not, copy the default one from resources
        if (!configFile.exists()) {
            saveResource("config.yml", false);  // 'false' means don't override if it already exists
        }

        // Now load the config
        FileConfiguration config = getConfig();

        // Example usage: Get a value from the config
        String someValue = config.getString("Prefixes.prefix");  // Replace with your actual config key
        System.out.println(someValue);

        System.out.println(Color.GREEN + "Plugin Enabled Succsesfully");
        //trh

        getServer().getPluginManager().registerEvents(new NoBlockBreak(this, someValue), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
