package me.parsa.menulobby.Discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Chat extends ListenerAdapter {
    private final JavaPlugin plugin;

    private boolean is_enabled;

    public Chat(JavaPlugin plugin, boolean is_enabled) {
        this.plugin = plugin;
        this.is_enabled = is_enabled;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (is_enabled) {


            if (e.getAuthor().isBot()) return;

            // Log all message details to debug
            plugin.getLogger().info("[Debug] Author: " + e.getAuthor().getName());
            plugin.getLogger().info("[Debug] ContentDisplay: " + e.getMessage().getContentDisplay());
            plugin.getLogger().info("[Debug] ContentRaw: " + e.getMessage().getContentRaw());

            String content = e.getMessage().getContentDisplay();

            if (content.isEmpty()) {
                content = e.getMessage().getContentRaw(); // Fallback if ContentDisplay is empty
            }

            String message = e.getAuthor().getName() + ": " + content;
            plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "[Discord] "  + ChatColor.GREEN + message);
        }

    }


}
