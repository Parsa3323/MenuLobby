package me.parsa.menulobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mbroadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mbroadcast")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("menulobby.admin")) {
                    if (args.length == 1) {
                        String message_to_send = args[0];
                        player.getServer().broadcastMessage(ChatColor.RED + "§l Server" + ChatColor.DARK_GRAY + " ➤ " + ChatColor.RED + message_to_send);
                        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.NOTE_PLING, 1 , 1);
                        }
                    } else {
                        player.sendMessage(ChatColor.AQUA + "Usage ➤ " + ChatColor.GOLD + "/mbroadcast <Message> ");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Sorry you don't have permission");
                }

            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
