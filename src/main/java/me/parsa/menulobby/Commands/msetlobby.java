package me.parsa.menulobby.Commands;

import me.parsa.menulobby.Config.Spawns;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msetlobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("msetlobby")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("menulobby.admin")) {
                    player.sendMessage(ChatColor.GREEN + "Setting the config");
                    Location location = player.getLocation();
                    try {
                        Spawns.get().set("lobby-spawn", location);
                        player.sendMessage(ChatColor.GREEN + "Location successfully set");
                        Spawns.save();
                    } catch (Exception e) {
                        e.printStackTrace();
                        player.sendMessage(ChatColor.RED + "Failed to set lobby location in config : " + e.getMessage());
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "No Permission");
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
