package me.parsa.menulobby;


import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderAPIPlugin;
import me.clip.placeholderapi.expansion.cloud.CloudExpansion;
import me.clip.placeholderapi.expansion.manager.CloudExpansionManager;
import me.clip.placeholderapi.expansion.manager.LocalExpansionManager;
import me.parsa.menulobby.Commands.*;
import me.parsa.menulobby.Events.*;
import me.parsa.menulobby.Listerners.BanInventoryListener;
import me.parsa.menulobby.Listerners.KickInventoryListener;
import me.parsa.menulobby.Listerners.SettingsInventoryListener;
import me.parsa.menulobby.Listerners.UnbanInventoryListener;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
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

        // Configs for ScoreBoard
        boolean isE = config.getBoolean("ScoreBoard.enabled");
        String server_ip = config.getString("ScoreBoard.server-ip");

        boolean IDK =  config.getBoolean("Welcome-Messages");
        //-----
        String score_title = config.getString("ScoreBoard.menu-title");

        //------
        boolean is_achievements = config.getBoolean("achievements");

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

        ConsoleCommandSender consoleCommandSender = Bukkit.getConsoleSender();

//        String command2 = "papi ecloud download Vault";
//
//        Bukkit.dispatchCommand(consoleCommandSender, command2);
        //----------------------------------------------------------



        //--------------------------------------------------------

        getServer().getPluginManager().registerEvents(new NoMob(this), this);
        getServer().getPluginManager().registerEvents(new NoRain(), this);
        getServer().getPluginManager().registerEvents(new UnbanInventoryListener(), this);
        getCommand("mkick").setExecutor(new mkick());
        getCommand("m").setExecutor(new m());
        getCommand("testkill").setExecutor(new test());
        getCommand("mfly").setExecutor(new mFly());
        getCommand("msettings").setExecutor(new msettings());
        getCommand("munban").setExecutor(new munban());
        getCommand("mtest").setExecutor(new mtest());
        getCommand("mmembers").setExecutor(new mMembers());
        getServer().getPluginManager().registerEvents(new SettingsInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new KickInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(this, IDK, server_ip, score_title, is_achievements), this);
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
    public void createScoreboard(Player player, String server_ip, String score_title) {
        // Get the Scoreboard Manager
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        // Create the Objective
        Objective objective = scoreboard.registerNewObjective(score_title, "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR); // Display on the side

        // Add scores (lines)
        objective.getScore(ChatColor.YELLOW + "Welcome to the Lobby!").setScore(6);// Higher score is displayed on top
        objective.getScore(ChatColor.AQUA + "Online Players: " + Bukkit.getOnlinePlayers().size()).setScore(5);
        objective.getScore(ChatColor.GREEN + "Available Games:").setScore(4);
        objective.getScore(ChatColor.GRAY + " - SkyWars").setScore(3);
        objective.getScore(ChatColor.GRAY + " - BedWars").setScore(2);
        objective.getScore(ChatColor.GOLD + server_ip).setScore(1);

        // Assign the scoreboard to the player
        player.setScoreboard(scoreboard);
    }
}
