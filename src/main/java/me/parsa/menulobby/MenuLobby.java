package me.parsa.menulobby;


import me.parsa.menulobby.Commands.test;
import me.parsa.menulobby.Events.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
//ds


public final class MenuLobby extends JavaPlugin implements Listener, CommandExecutor {

    private BossBar bossBar;

    @Override
    public void onEnable() {

        File configFile = new File(getDataFolder(), "config.yml");

        // Check if the config file exists, if not, copy the default one from resources
        if (!configFile.exists()) {
            saveResource("config.yml", false);  // 'false' means don't override if it already exists
        }

        // Now load the config
        FileConfiguration config = getConfig();

        System.out.println("Succses");

        boolean IDK =  config.getBoolean("Welcome-Messages");

        getServer().getPluginManager().registerEvents(new NoMob(this), this);
        getServer().getPluginManager().registerEvents(new NoRain(), this);
        getCommand("testkill").setExecutor(new test());
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(this, IDK), this);
        getServer().getPluginManager().registerEvents(new NoHunger(), this);
//        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
