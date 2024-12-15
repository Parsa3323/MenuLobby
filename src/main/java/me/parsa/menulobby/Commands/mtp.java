package me.parsa.menulobby.Commands;

import me.parsa.menulobby.utils.TpMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mtp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mtp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 2) {
                    if (player.hasPermission("menulobby.admin")) {
                        String p_1 = args[0];
                        String p_2 = args[1];

                        Player player_to_tp = Bukkit.getPlayer(p_1);
                        Player player_2 = Bukkit.getPlayer(p_2);

                        player_to_tp.teleport(player_2.getLocation());
                        player.playSound(player.getLocation(), Sound.DOOR_OPEN, 1 , 1);
                        if (player != player_to_tp) {
                            player.sendMessage(ChatColor.GREEN + "You teleported " + player_to_tp.getName() + " to " + player_2.getName());
                        } else {
                            player.sendMessage(ChatColor.GREEN + "Teleported you to " + player_2.getName());
                        }

                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have permission");
                    }


                } else if (args.length == 1) {
                    player.sendMessage(ChatColor.YELLOW + "Usage" + ChatColor.DARK_GRAY + " ➤ " + ChatColor.YELLOW + "/tp|mtp <user> <user> / /tp");
                } else if (args.length == 0) {
                    TpMenuUtils.openTpMenu(player);
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }

}
