package me.parsa.menulobby.Events;

import me.parsa.menulobby.Discord.WebHookSender;
import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.utils.OnJoinAdminUtils;
import me.parsa.menulobby.utils.TabListUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;


public class OnPlayerJoin implements Listener {

    boolean msgE;

    private String score_title;

    private boolean is_achievements;

    private final MenuLobby pl;

    private String server_ip;

    private boolean is_title;

    private boolean is_score;

    private String bedwars;

    private String webhook_url;

    private boolean is_enabled_web;

    private Location spawnLocation = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();

    private World spawn_world = spawnLocation.getWorld();

    private JavaPlugin plugin;

    private String store;
    private String discord;
    private String website;
    private String server_name;

    public OnPlayerJoin(MenuLobby pl, boolean msgE, String server_ip, String score_title, boolean is_achievements, boolean is_score, boolean is_title, String bedwars, String webhook_url, boolean is_enabled_web, JavaPlugin plugin, String server_name, String store, String website, String discord) {
        this.msgE = msgE;
        this.pl = pl;
        this.bedwars = bedwars;
        this.is_title = is_title;
        this.store = store;
        this.discord = discord;
        this.server_name = server_name;
        this.website = website;
        this.is_score = is_score;
        this.is_achievements = is_achievements;
        this.score_title = score_title;
        this.is_enabled_web = is_enabled_web;
        this.server_ip = server_ip;
        this.webhook_url = webhook_url;
        this.plugin = plugin;
    }
//    private BossBarUtils bossBarUtils;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
//        Audience playerAudience = this.pl.adventure().player(e.getPlayer());
//
//        bossBarUtils.showMyBossBar(playerAudience);


        ArrayList<Player> playerArrayList10 = new ArrayList<>();
        ArrayList<Player> playerArrayList30 = new ArrayList<>();

        Player p = e.getPlayer();


//        TabListUtils tabUtils = new TabListUtils();
//        tabUtils.createScoreboard(p);

        if (is_score) {

            pl.createScoreboard(p, server_ip, score_title, bedwars);
        }
        if (msgE) {
            p.sendMessage(ChatColor.GRAY + "-----------------------------------");
            p.sendMessage(" ");
            p.sendMessage("Welcome to " + server_name);
            p.sendMessage(" ");
            p.sendMessage(ChatColor.GRAY + "■ " + ChatColor.WHITE + "Discord: " + ChatColor.DARK_GREEN + discord);
            p.sendMessage(ChatColor.GRAY + "■ " + ChatColor.WHITE + "Website: " + ChatColor.DARK_GREEN + website);
            p.sendMessage(ChatColor.GRAY + "■ " + ChatColor.WHITE + "Store: " + ChatColor.DARK_GREEN + store);
            p.sendMessage(" ");
            p.sendMessage(ChatColor.GRAY + "-----------------------------------");
        }
        e.setJoinMessage(null);
        if (is_achievements) {
            if (!p.hasPlayedBefore()) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1 , 1);
                p.sendMessage(ChatColor.GOLD + "=== Achievement Unlocked ===");
                p.sendMessage(ChatColor.AQUA + "Welcome to the server!");
                p.sendMessage(ChatColor.GREEN + "Achievement: First Join");
                p.sendMessage(ChatColor.GOLD + "===========================");
            }
        }
        if (p.hasPermission("menulobby.admin")) {
            new BukkitRunnable() {
                @Override
                public void run() {

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (p.hasPermission("menulobby.admin")) {
                                OnJoinAdminUtils.giveAdmin(p);
                            }
                        }
                    }.runTaskLater(plugin, 40L);

                }
            }.runTaskLater(plugin, 20L);
        }
        if (is_title) {
            p.sendTitle(ChatColor.GREEN + "Welcome" + " " + p.getName(), ChatColor.AQUA + "Enjoy Your Time");
        }
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
        pl.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + p.getName() + " Joined The server say hi");
        int playTimeTicks = p.getStatistic(org.bukkit.Statistic.PLAY_ONE_TICK);
        int playTimeMinutes = playTimeTicks / (20 * 60); // Convert ticks to minutes
        if (is_achievements) {
            if (playTimeMinutes > 600) { // 600 minutes = 10 hours
                if (!playerArrayList10.contains(p)) {
                    playerArrayList10.add(p);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1 , 1);
                    p.sendMessage(ChatColor.GOLD + "=== Achievement Unlocked ===");
                    p.sendMessage(ChatColor.AQUA + "You've played over 10 hours!");
                    p.sendMessage(ChatColor.GREEN + "Achievement: Time Well Spent");
                    p.sendMessage(ChatColor.GOLD + "===========================");
                }
            } else if (playTimeMinutes > 30) {
                if (playerArrayList30.contains(p)) {
                    playerArrayList30.add(p);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1 , 1);
                    p.sendMessage(ChatColor.GOLD + "=== Achievement Unlocked ===");
                    p.sendMessage(ChatColor.AQUA + "You've played over 30 minutes!");
                    p.sendMessage(ChatColor.GREEN + "Achievement: Time Not Well Spent");
                    p.sendMessage(ChatColor.GOLD + "===========================");
                }
            }
        }
//        if (is_enabled_web) {
//            WebHookSender.sendWebhookMessage(e.getPlayer().getName() + " Joined the server ", webhook_url);
//        }
        //System.out.printf(p.getName() + "Joined The server");
    }
}
