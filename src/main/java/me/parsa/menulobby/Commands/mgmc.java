package me.parsa.menulobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mgmc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mgmc")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                GameMode gameMode = GameMode.CREATIVE;
                if (args.length == 0) {
                    if (player.hasPermission("menulobby.gm")) {
                        player.setGameMode(gameMode);
                        player.sendMessage(ChatColor.GREEN + "Successfully changed your gamemode to creative");
                    } else {
                        player.sendMessage(ChatColor.RED + "You Don't Have Permission");
                    }

                } else if (args.length == 1) {
                    if (player.hasPermission("menulobby.gm")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        target.sendMessage(player.getName() + ChatColor.GREEN +  " has changed your gamemode to creative" );
                        player.sendMessage(ChatColor.GREEN + "Successfully changed " + target.getName() + "'s gamemode to creative");
                        target.setGameMode(gameMode);
                    } else {
                        player.sendMessage(ChatColor.RED + "You Don't Have Permission");
                    }

                }


            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
