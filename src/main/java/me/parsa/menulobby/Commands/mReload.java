package me.parsa.menulobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class mReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mreload")) {
            PluginManager pluginManager = Bukkit.getPluginManager();
            Plugin plugin = pluginManager.getPlugin("MenuLobby");
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("menulobby.admin")) {
                    player.sendMessage(ChatColor.AQUA + "Reloading the plugin");
                    pluginManager.disablePlugin(plugin);
                    pluginManager.enablePlugin(plugin);
                    player.sendMessage(ChatColor.GREEN + "Plugin Reloaded Successfully");
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission To do that");
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
