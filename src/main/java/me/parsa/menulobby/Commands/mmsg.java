package me.parsa.menulobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mmsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mmsg")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 2) {
                    String name = args[0];
                    String message = args[1];
                    Player target = Bukkit.getPlayer(name);
                    if (!player.equals(target)) {
                        player.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + " " + player.getName() + " ➤ " + target.getName() + ChatColor.DARK_GRAY + ": " + message);
                        target.sendMessage(ChatColor.YELLOW + " " + player.getName() + " ➤ " + target.getName() + ChatColor.DARK_GRAY + ": " + message);
                        target.playSound(player.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                        player.sendMessage(ChatColor.YELLOW + " " + player.getName() + " ➤ " + target.getName() + ChatColor.DARK_GRAY + ": " + message);
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1 , 1);
                    } else {
                        player.sendMessage(ChatColor.RED + "You can't dm yourself");
                    }
                } else if (args.length < 2) {
                    player.sendMessage(ChatColor.AQUA + "Usage: " + ChatColor.GOLD + "/mmsg <Player> <Message>");
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
