package me.parsa.menulobby;


import me.parsa.menulobby.Commands.*;
import me.parsa.menulobby.Config.JumpPadsConf;
import me.parsa.menulobby.Config.Spawns;
import me.parsa.menulobby.Events.*;
import me.parsa.menulobby.Events.NoBlock.NoAnvilOpen;
import me.parsa.menulobby.Events.NoBlock.NoBlockBreak;
import me.parsa.menulobby.Events.NoBlock.NoChestOpen;
import me.parsa.menulobby.Listerners.*;
import me.parsa.menulobby.Placeholders.ChatPapi;
import me.parsa.menulobby.advertise.ads;
import me.parsa.menulobby.utils.UpdateChecker;
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
import java.util.List;
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

        if (getServer().getPluginManager().getPlugin("bedwars1058") != null) {
            getConfig().set("chat.message", "§l§7%bw1058_player_level%| §2%MenuLobby_username%§r §7» %MenuLobby_message%");
        }


        File configFile = new File(getDataFolder(), "config.yml");


        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }



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
        getServer().getConsoleSender().sendMessage("");

        System.out.println("SDS");
        int res_id = 121022;
        new UpdateChecker(this, res_id).checkForUpdates();
        System.out.println("SD23S");
        if (getServer().getPluginManager().getPlugin("Parties") != null) {
            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " Found parties plugin initializing");
        } else if (getServer().getPluginManager().getPlugin("Parties") == null) {
            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " We recommend downloading parties plugin for better menulobby work");

        }if (getServer().getPluginManager().getPlugin("bedwars1058") != null) {

            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " Found bedwars1058 plugin initializing");

        }if (getServer().getPluginManager().getPlugin("NoBlocks") != null) {

            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby ->" + ChatColor.AQUA + " No need to download the NoBlocks plugin anymore! (you can delete it if you want)");

        } if (getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "___________                               ");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "\\_   _____/_______ _______   ____ _______ ");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + " |    __)_ \\_  __ \\\\_  __ \\ /  _ \\\\_  __ \\");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + " |        \\ |  | \\/ |  | \\/(  <_> )|  | \\/");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "/_______  / |__|    |__|    \\____/ |__|   ");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "        \\/                                ");
            getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Menu Lobby -> [Error] PlaceholderAPI not found disabling plugin");
            Bukkit.getPluginManager().disablePlugin(this);

            return;
        } else {
            new ChatPapi().register();
        }
//        SIde for setting the spawns up
        Spawns.setup();
        Spawns.get().addDefault("lobby-spawn", "?");
        Spawns.get().options().copyDefaults(true);
        Spawns.save();

        JumpPadsConf.setup();
        JumpPadsConf.get().options().copyDefaults(true);
        JumpPadsConf.save();
//        Stop

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


        if (!file2.exists()) {
            saveResource("messages.yml", false);
        }

        // Now load the config
        FileConfiguration messages = getConfig();

        System.out.println("Succses");

        //For the Damages
        boolean isBoss = messages.getBoolean("messages.hits.enabled");
        String noDperm = messages.getString("messages.hits.no-perm");

        ConsoleCommandSender consoleCommandSender = Bukkit.getConsoleSender();
        getServer().getPluginManager().registerEvents(new TestListener(), this);
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


        if (!blockFile.exists()) {
            saveResource("NoBlockBreak/noblocks.yml", false);
        }


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

        getCommand("mjumppad").setExecutor(new mjumppad());


        // NoChests
        boolean is_no_chest = noBlock.getBoolean("NoChests.enabled");
        boolean only_spawn_world_no_chests = noBlock.getBoolean("NoChests.only-spawn-world");
        String no_perm_no_chests = noBlock.getString("NoChests.no-perm");


        boolean is_debug = getConfig().getBoolean("debug");
        String webhook_url = config.getString("webhooks.url");
        boolean is_webhook = config.getBoolean("webhooks.enabled");

        System.out.println(is_no_anvil  + " "  + is_no_chest +  " " + is_no_block);
        getCommand("msetlobby").setExecutor(new msetlobby());
        getCommand("lobby").setExecutor(new lobby());
        getServer().getPluginManager().registerEvents(new NoChestOpen(this, is_no_chest, no_perm_no_chests, only_spawn_world_no_chests), this);
        getServer().getPluginManager().registerEvents(new NoAnvilOpen(this, is_no_anvil, no_perm_no_anvil), this);
        getServer().getPluginManager().registerEvents(new NoBlockBreak(this, no_perm_no_blocks, is_no_block, is_in_one_word_no_blocks), this);
        //------------------------------------------/Config Manager For NoBlockBreak


//        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "THE CONFIG TEST" + getConfig().getString("webhooks.url"));
//        config for blocked words
        List<String> blocked_custom = config.getStringList("blocked-messages");
        getServer().getPluginManager().registerEvents(new NoBadWord(blocked_custom), this);


        boolean ad_enabled = getConfig().getBoolean("ads.enabled");
        boolean ad_sound_effects = getConfig().getBoolean("ads.sound-effects");
        String ad_sound = getConfig().getString("ads.sound");
        String ads_chat_messages = getConfig().getString("ads.chat-message");
        int ads_shows_every = getConfig().getInt("ads.shows-every");
        boolean ads_titles_enabled = getConfig().getBoolean("ads.titles.enabled");
        String ads_titles_titles = getConfig().getString("ads.titles.title");
        String title_description = getConfig().getString("ads.titles.description");
        ads ads = new ads(this, ad_enabled, ad_sound_effects, ad_sound, ads_chat_messages, ads_shows_every, ads_titles_enabled, ads_titles_titles, title_description);
        ads.Start();

        getServer().getPluginManager().registerEvents(new NoMob(this), this);
        getServer().getPluginManager().registerEvents(new NoRain(this), this);
        getServer().getPluginManager().registerEvents(new UnbanInventoryListener(), this);
        getCommand("mkick").setExecutor(new mkick());
        getCommand("m").setExecutor(new m(this));
//        getCommand("mtest2").setExecutor(new Countdown(this));
//        getCommand("testkill").setExecutor(new test());
        getCommand("mfly").setExecutor(new mFly());
        getCommand("mbroadcast").setExecutor(new mbroadcast());
        getCommand("msettings").setExecutor(new msettings(this));
        getCommand("munban").setExecutor(new munban());
//        getCommand("mtest").setExecutor(new mtest());
        getCommand("mstats").setExecutor(new mstats());
        getCommand("mreload").setExecutor(new mReload());
        getCommand("mplayer").setExecutor(new mplayer());
        getCommand("mgmc").setExecutor(new mgmc());
        getCommand("mmembers").setExecutor(new mMembers());
        getCommand("mgms").setExecutor(new mgms());
        getCommand("msupport").setExecutor(new msupport());
        getCommand("mmsg").setExecutor(new mmsg());
        getCommand("mping").setExecutor(new mping());
//        getCommand("mstaffchat").setExecutor(new mstaffchat(this, this));
        getCommand("mtp").setExecutor(new mtp());
        //ds
        String msg = config.getString("chat.message");
        boolean isE_chat = config.getBoolean("chat.enabled");

        String server_name = getConfig().getString("server-name");
        //-----------
        getCommand("mparties").setExecutor(new mparties(this));
        mstaffchat staffChatCommand = new mstaffchat(this, this);
        getServer().getPluginManager().registerEvents(new ChatEvent(msg, isE_chat, staffChatCommand), this);
        getServer().getPluginManager().registerEvents(new ChatPapi(), this);
        getServer().getPluginManager().registerEvents(new CoolDown(), this);
        getServer().getPluginManager().registerEvents(new StatsInventoryListener(), this);
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
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(this, IDK, server_ip, score_title, is_achievements, is_score, is_title, bedwars_title, webhook_url, is_webhook, this, server_name, store, website, discord), this);
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
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "        .__   ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "  _____ |  |   ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + " /     \\|  |   ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "|  Y Y  \\  |__ ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "|__|_|  /____/ ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "      \\/      (ʘ‿ʘ)╯ ");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "Disabling MenuLobby v" + getDescription().getVersion());
        System.out.println("MenuLobby Disabled");
    }
    public void showHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.AQUA + "MenuLobby Commands" + ChatColor.GOLD + " =====");


        Map<String, Map<String, Object>> commands = this.getDescription().getCommands();


        for (Map.Entry<String, Map<String, Object>> entry : commands.entrySet()) {
            String commandName = entry.getKey();
            String description = (String) entry.getValue().get("description");
            String usage = (String) entry.getValue().get("usage");


            showCommand(sender, commandName, description, usage);
        }

        sender.sendMessage(ChatColor.GOLD + "============================");
    }

    public void showCommand(CommandSender sender, String command, String description, String usage) {
        sender.sendMessage(ChatColor.YELLOW + "/" + command + ChatColor.GRAY + " - " + description);
        sender.sendMessage(ChatColor.GRAY + "Usage: " + ChatColor.WHITE + usage);
        sender.sendMessage("");
    }
    public void createScoreboard(Player player, String server_ip, String score_title, String bedwars) {

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();


        if (getServer().getPluginManager().getPlugin("bedwars1058") != null) {
                score_title = bedwars;
        }
        Objective objective = scoreboard.registerNewObjective( ChatColor.YELLOW + score_title, "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR); // Display on the side

        //--------
        // level display


        // -------



        objective.getScore(ChatColor.YELLOW + "  Welcome to the Lobby! ").setScore(10);
        objective.getScore(" ").setScore(6);
        objective.getScore(ChatColor.AQUA + "  Online Players:  " + Bukkit.getOnlinePlayers().size()).setScore(9);
        objective.getScore(" ").setScore(8);
        objective.getScore(ChatColor.GREEN + "  Available Games:  ").setScore(7);
        objective.getScore(" ").setScore(6);
        objective.getScore(ChatColor.GRAY + " - SkyWars ").setScore(5);
        objective.getScore(" ").setScore(4);
        objective.getScore(ChatColor.GRAY + " - BedWars ").setScore(3);
        objective.getScore(" ").setScore(2);
        objective.getScore(ChatColor.GOLD + server_ip).setScore(1);


        player.setScoreboard(scoreboard);
    }



}
