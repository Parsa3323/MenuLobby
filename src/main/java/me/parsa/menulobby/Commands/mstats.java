package me.parsa.menulobby.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.parsa.menulobby.utils.StatsMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mstats implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mstats")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getServer().getPluginManager().getPlugin("bedwars1058") != null) {
                    if (args.length == 1) {
                        String arg = args[0];
                        Player target = Bukkit.getPlayer(arg);
                        StatsMenuUtils.createMenu(player, target);
                    } else if (args.length == 0) {
                        StatsMenuUtils.createMenu(player, player);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Error check the console for more");
                    player.getServer().getConsoleSender().sendMessage(ChatColor.RED + player.getName() + " Sended /mstats but bedwars1058 notfound");
                }



            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
