package me.parsa.menulobby;



import me.parsa.menulobby.Commands.*;
import me.parsa.menulobby.Events.*;
import me.parsa.menulobby.Events.NoBlock.NoAnvilOpen;
import me.parsa.menulobby.Events.NoBlock.NoBlockBreak;
import me.parsa.menulobby.Events.NoBlock.NoChestOpen;
import me.parsa.menulobby.Listerners.*;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Map;
//ds


public final class MenuLobby extends JavaPlugin implements Listener, CommandExecutor {


    private BukkitAudiences adventure;

    public @NotNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

//    private JDA jda;
//
//    private TextChannel discordChannel;
//sd
    @Override
    public void onEnable() {

        this.adventure = BukkitAudiences.create(this);



        File configFile = new File(getDataFolder(), "config.yml");

        // Check if the config file exists, if not, copy the default one from resources
        if (!configFile.exists()) {
            saveResource("config.yml", false);  // 'false' means don't override if it already exists
        }


        // Now load the config
        FileConfiguration config = getConfig();



        System.out.println("Succses");

        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "        .__   ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "  _____ |  |   ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + " /     \\|  |   ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "|  Y Y  \\  |__ ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "|__|_|  /____/ ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "      \\/       ");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "MenuLobby v" + getDescription().getVersion());
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Running on Bukkit - CraftBukkit");
        getServer().getConsoleSender().sendMessage(""); // Blank line for spacing

        if (getServer().getPluginManager().getPlugin("Parties") != null) {
            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " Found parties plugin initializing");
        } else if (getServer().getPluginManager().getPlugin("Parties") == null) {
            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " We recommend downloading parties plugin for better menulobby work");

        }if (getServer().getPluginManager().getPlugin("bedwars1058") != null) {

            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " Found bedwars1058 plugin initializing");

        }if (getServer().getPluginManager().getPlugin("NoBlocks") != null) {

            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " No need to download the NoBlocks plugin anymore! (you can delete it if you want)");

        }

        // Configs for ScoreBoard
        boolean isE = config.getBoolean("ScoreBoard.enabled");
        String server_ip = config.getString("ScoreBoard.server-ip");

        boolean IDK =  config.getBoolean("Welcome-Messages");
        //-----
        String score_title = config.getString("ScoreBoard.menu-title");
        boolean is_score = config.getBoolean("ScoreBoard.enabled");

        //------
        boolean is_achievements = config.getBoolean("achievements");

        //-----
        String discord = config.getString("support.discord");
        String website = config.getString("support.website");
        String store = config.getString("support.store");

        String bedwars_title = config.getString("ScoreBoard.bedwars-title");

        //----
        boolean is_title = config.getBoolean("Welcome-Titles");

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
        //----------------------------------------------------------------------------------------------------------------DISCORD
//        File Discordyml = new File(getDataFolder(), "Discord/discord.yml");
//
//
//        if (!Discordyml.exists()) {
//            saveResource("Discord/discord.yml", false);
//        }
//
//
//        FileConfiguration discordyml = YamlConfiguration.loadConfiguration(Discordyml);
//
//        String TOKEN_DISCORD = discordyml.getString("token");
//        boolean discord_enabled = discordyml.getBoolean("enabled");
//
//        if (discord_enabled) {
//            try {
//                jda = JDABuilder.createDefault(TOKEN_DISCORD).enableIntents(
//                                GatewayIntent.GUILD_MESSAGES,     // For messages in guilds
//                                GatewayIntent.DIRECT_MESSAGES,    // For DMs
//                                GatewayIntent.MESSAGE_CONTENT,    // Enable Message Content Intent
//                                GatewayIntent.GUILD_MEMBERS    // For member updates
//                        )
//                        .setActivity(Activity.playing("Minecraft"))
//                        .build();
//                jda.awaitReady(); // Wait for the bot to be ready
//                boolean is_e = true;
//                jda.addEventListener(new Chat(this, is_e));
//                getLogger().info("Discord bot is running!");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //------------------------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------
        //-------------------------------------------Config Manager For NoBlockBreak

        File blockFile = new File(getDataFolder(), "NoBlockBreak/noblocks.yml");

        // Check if the config file exists, if not, copy the default one from resources
        if (!blockFile.exists()) {
            saveResource("NoBlockBreak/noblocks.yml", false);  // 'false' means don't override if it already exists
        }

        // Load the custom configuration
        FileConfiguration noBlock = YamlConfiguration.loadConfiguration(blockFile);

        // NoBlockss
        boolean is_no_block = noBlock.getBoolean("NoBlocks.enabled");
        boolean is_in_one_word_no_blocks = noBlock.getBoolean("NoBlocks.only-spawn-world");
        String no_perm_no_blocks = noBlock.getString("NoBlocks.no-perm");

        // NoAnvils
        boolean is_no_anvil = noBlock.getBoolean("NoAnvils.enabled");
        String no_perm_no_anvil = noBlock.getString("NoAnvils.no-perm");

        boolean is_boss_bar = config.getBoolean("BossBar.enabled");
        String boss_message = config.getString("BossBar.message");


        String toxic_warn = config.getString("warn.toxic");
        String chaet_warn = config.getString("warn.cheat");
        String cross_warn = config.getString("warn.crossteaming");

        // NoChests
        boolean is_no_chest = noBlock.getBoolean("NoChests.enabled");
        boolean only_spawn_world_no_chests = noBlock.getBoolean("NoChests.only-spawn-world");
        String no_perm_no_chests = noBlock.getString("NoChests.no-perm");

        String webhook_url = config.getString("webhooks.url");
        boolean is_webhook = config.getBoolean("webhooks.enabled");

        System.out.println(is_no_anvil  + " "  + is_no_chest +  " " + is_no_block);

        getServer().getPluginManager().registerEvents(new NoChestOpen(this, is_no_chest, no_perm_no_chests, only_spawn_world_no_chests), this);
        getServer().getPluginManager().registerEvents(new NoAnvilOpen(this, is_no_anvil, no_perm_no_anvil), this);
        getServer().getPluginManager().registerEvents(new NoBlockBreak(this, no_perm_no_blocks, is_no_block, is_in_one_word_no_blocks), this);
        //------------------------------------------/Config Manager For NoBlockBreak

        getServer().getPluginManager().registerEvents(new NoMob(this), this);
        getServer().getPluginManager().registerEvents(new NoRain(this), this);
        getServer().getPluginManager().registerEvents(new UnbanInventoryListener(), this);
        getCommand("mkick").setExecutor(new mkick());
        getCommand("m").setExecutor(new m(this));
        getCommand("mtest2").setExecutor(new Countdown(this));
        getCommand("testkill").setExecutor(new test());
        getCommand("mfly").setExecutor(new mFly());
        getCommand("msettings").setExecutor(new msettings(this));
        getCommand("munban").setExecutor(new munban());
        getCommand("mtest").setExecutor(new mtest());
        getCommand("mreload").setExecutor(new mReload());
        getCommand("mplayer").setExecutor(new mplayer());
        getCommand("mgmc").setExecutor(new mgmc());
        getCommand("mmembers").setExecutor(new mMembers());
        getCommand("mgms").setExecutor(new mgms());
        getCommand("msupport").setExecutor(new msupport());
        getCommand("mmsg").setExecutor(new mmsg());
        getCommand("mtp").setExecutor(new mtp());
        //ds
        getCommand("mparties").setExecutor(new mparties(this));
        getServer().getPluginManager().registerEvents(new TagListener(this), this);
        getServer().getPluginManager().registerEvents(new ShiftInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPreJoin(webhook_url, is_webhook), this);
        getServer().getPluginManager().registerEvents(new AdminPanelEvent(this, this), this);
        getServer().getPluginManager().registerEvents(new PlayerInventoryListener(toxic_warn, cross_warn, chaet_warn), this);
        getServer().getPluginManager().registerEvents(new BossBarHandler(this, is_boss_bar, boss_message), this);
        getServer().getPluginManager().registerEvents(new PartyInventoryListener(this), this);
        getServer().getPluginManager().registerEvents(new TpInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new SupportInventoryListener(discord,website,store), this);
        getServer().getPluginManager().registerEvents(new SettingsInventoryListener(this), this);
        getServer().getPluginManager().registerEvents(new KickInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(this, IDK, server_ip, score_title, is_achievements, is_score, is_title, bedwars_title, webhook_url, is_webhook, this), this);
        getServer().getPluginManager().registerEvents(new NoHunger(this), this);
        getServer().getPluginManager().registerEvents(new NoBlockDrop(this), this);
        getServer().getPluginManager().registerEvents(new NoHit(this), this);
        getServer().getPluginManager().registerEvents(new NoDamage(this, noDperm,isBoss), this);
//        getServer().getPluginManager().registerEvents(new joinLoggerE(), this);
//        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if(this.adventure != null) {
            this.adventure.close();
            this.adventure = null;
        }
        System.out.println("MenuLobby Disabled");
    }
    public void showHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.AQUA + "MenuLobby Commands" + ChatColor.GOLD + " =====");

        // Get commands from plugin.yml
        Map<String, Map<String, Object>> commands = this.getDescription().getCommands();

        // Iterate over each command and display its description and usage
        for (Map.Entry<String, Map<String, Object>> entry : commands.entrySet()) {
            String commandName = entry.getKey();
            String description = (String) entry.getValue().get("description");  // Cast to String
            String usage = (String) entry.getValue().get("usage");  // Cast to String

            // Show the command with description and usage
            showCommand(sender, commandName, description, usage);
        }

        sender.sendMessage(ChatColor.GOLD + "============================");
    }

    public void showCommand(CommandSender sender, String command, String description, String usage) {
        sender.sendMessage(ChatColor.YELLOW + "/" + command + ChatColor.GRAY + " - " + description);
        sender.sendMessage(ChatColor.GRAY + "Usage: " + ChatColor.WHITE + usage);
        sender.sendMessage(""); // Adding space between commands for readability
    }
    public void createScoreboard(Player player, String server_ip, String score_title, String bedwars) {
        // Get the Scoreboard Manager
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        // Create the Objective
        if (getServer().getPluginManager().getPlugin("bedwars1058") != null) {
                score_title = bedwars;
        }
        Objective objective = scoreboard.registerNewObjective( ChatColor.YELLOW + score_title, "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR); // Display on the side

        // Add scores (lines)
        objective.getScore(ChatColor.YELLOW + "  Welcome to the Lobby! ").setScore(10);// Higher score is displayed on top
        objective.getScore(" ").setScore(6);
        objective.getScore(ChatColor.AQUA + "  Online Players:  " + Bukkit.getOnlinePlayers().size()).setScore(9);
//        if (getServer().getPluginManager().getPlugin("Parties") != null) {
//            PartiesAPI api = Parties.getApi();
//            String party_description = null;
//            String party_leader = null
//            @NotNull Set<PartyPlayer> party_members = null;
//            PartyPlayer player1 = api.getPartyPlayer(player.getUniqueId());
//            if (player1.isInParty()) {
//                Party party = api.getParty(player1.getPartyId());
//                if (party != null) {
//                    party_members = party.getOnlineMembers();
//
//                    objective.getScore(ChatColor.DARK_PURPLE + "Party:").setScore(2); // Party label
//                    objective.getScore(ChatColor.LIGHT_PURPLE + "  Members: " + ChatColor.AQUA + party_members).setScore(1); // Members count
//                    objective.getScore(ChatColor.LIGHT_PURPLE + "  Leader: " + ChatColor.GOLD + "PlayerName").setScore(0); // Leader name
//                    objective.getScore(" ").setScore(-1);
//                }
//            }
//
//        }

        objective.getScore(" ").setScore(8);
        objective.getScore(ChatColor.GREEN + "  Available Games:  ").setScore(7);
        objective.getScore(" ").setScore(6);
        objective.getScore(ChatColor.GRAY + " - SkyWars ").setScore(5);
        objective.getScore(" ").setScore(4);
        objective.getScore(ChatColor.GRAY + " - BedWars ").setScore(3);
        objective.getScore(" ").setScore(2);
        objective.getScore(ChatColor.GOLD + server_ip).setScore(1);

        // Assign the scoreboard to the player
        player.setScoreboard(scoreboard);
    }



}
