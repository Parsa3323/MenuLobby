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
        boolean Anvil_bol = config.getBoolean("anvils.enabled");
        String someValue = config.getString("anvils.No-Anvil");  // Replace with your actual config key
        System.out.println(someValue);

        // Variables for BlockBreak
        boolean is_not_breakable = config.getBoolean("blocks.enabled");
        String break_error = config.getString("blocks.No-Permission");

        //Vars for enderchests
        boolean is_not_open = config.getBoolean("enderchests.enabled");
        String open_error_ender = config.getString("enderchests.no-e-chest");

        System.out.println(Color.GREEN + "Plugin Enabled Succsesfully");
        //trh

        getServer().getPluginManager().registerEvents(new NoBlockBreak(this, someValue, Anvil_bol, is_not_breakable, break_error, is_not_open, open_error_ender), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
