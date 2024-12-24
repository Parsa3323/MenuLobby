package me.parsa.menulobby.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    private final Plugin plugin;
    private final int resourceId;

    public UpdateChecker(Plugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void checkForUpdates() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                // URL to check the latest version
                URL url = new URL("https://api.spigotmc.org/simple/0.2/index.php?action=getResource&id=" + resourceId);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JsonObject json = new JsonParser().parse(response.toString()).getAsJsonObject();

                String latestVersion = json.get("current_version").getAsString();

                // Compare versions
                String currentVersion = plugin.getDescription().getVersion();
                if (!currentVersion.equalsIgnoreCase(latestVersion)) {
                    plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[UpdateChecker] " +
                            ChatColor.GREEN + "A new version of the plugin is available: " +
                            ChatColor.AQUA + latestVersion);
                    plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[UpdateChecker] " +
                            ChatColor.BLUE + "Download it at: " +
                            ChatColor.UNDERLINE + "https://www.spigotmc.org/resources/" + resourceId);
                } else {
                    plugin.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[UpdateChecker] " +
                            ChatColor.GREEN + "The plugin is up to date!");
                }
            } catch (Exception e) {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[UpdateChecker] " +
                        ChatColor.DARK_RED + "Could not check for updates: " + e.getMessage());
            }
        });
    }
}
