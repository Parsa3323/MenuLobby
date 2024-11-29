package me.parsa.menulobby.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mgms implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mgms")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("menulobby.gms")) {
                    GameMode gameMode = GameMode.SURVIVAL;
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.GREEN + "Successfully changed to survival");
                        player.setGameMode(gameMode);
                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        target.sendMessage(player.getName() + ChatColor.GREEN + " has changed your gamemode to survival");
                        player.sendMessage(ChatColor.GREEN + "Changed " + target.getName() + "'s gamemode to survival");
                        target.setGameMode(gameMode);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to do that");
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
