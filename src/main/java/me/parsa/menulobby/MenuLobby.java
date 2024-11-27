package me.parsa.menulobby;


import me.parsa.menulobby.Commands.mFly;
import me.parsa.menulobby.Commands.mMembers;
import me.parsa.menulobby.Commands.test;
import me.parsa.menulobby.Events.*;
import me.parsa.menulobby.Listerners.BanInventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

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

        File file2 = new File(getDataFolder(), "messages.yml");

        // Check if the config file exists, if not, copy the default one from resources
        if (!file2.exists()) {
            saveResource("messages.yml", false);  // 'false' means don't override if it already exists
        }

        // Now load the config
        FileConfiguration messages = getConfig();

        System.out.println("Succses");

        //For the Damages
        boolean isBoss = messages.getBoolean("messages.hits.enabled");
        String noDperm = messages.getString("messages.hits.no-perm");



        getServer().getPluginManager().registerEvents(new NoMob(this), this);
        getServer().getPluginManager().registerEvents(new NoRain(), this);
        getCommand("testkill").setExecutor(new test());
        getCommand("mfly").setExecutor(new mFly());
        getCommand("mmembers").setExecutor(new mMembers());
        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(this, IDK), this);
        getServer().getPluginManager().registerEvents(new NoHunger(), this);
        getServer().getPluginManager().registerEvents(new NoHit(this), this);
        getServer().getPluginManager().registerEvents(new NoDamage(this, noDperm,isBoss), this);
//        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("MenuLobby Disabled");
    }
    public void createScoreboard(Player player) {
        // Get the Scoreboard Manager
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        // Create the Objective
        Objective objective = scoreboard.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR); // Display on the side

        // Add scores (lines)
        objective.getScore(ChatColor.GREEN + "Line 1").setScore(3); // Higher score is displayed on top
        objective.getScore(ChatColor.AQUA + "Line 2").setScore(2);
        objective.getScore(ChatColor.RED + "Line 3").setScore(1);

        // Assign the scoreboard to the player
        player.setScoreboard(scoreboard);
    }
}
