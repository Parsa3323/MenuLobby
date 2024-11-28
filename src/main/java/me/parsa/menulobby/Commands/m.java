package me.parsa.menulobby.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class m implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("m")) {
            if (sender.hasPermission("menulobby.admin")) {
                sender.sendMessage( ChatColor.GOLD + "Commands: ");
                sender.sendMessage(ChatColor.GREEN + "Prefix: M");
                sender.sendMessage(ChatColor.AQUA + "mfly : enable or disable fly mode");
                sender.sendMessage(ChatColor.AQUA + "mmembers: Opens a gui menu for banning or managing memebrs");
            } else {
                sender.sendMessage(ChatColor.AQUA + "MenuLobby Running");
            }
            return true;
        }
        return false;
    }
}
