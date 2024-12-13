package me.parsa.menulobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class mFly implements CommandExecutor {

    private ArrayList<Player> list_of_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mfly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    
                    
                    if (player.hasPermission("menulobby.fly")) {
                        if (list_of_players.contains(player)) {
                            list_of_players.remove(player);
                            player.setAllowFlight(false);
                            player.sendMessage(ChatColor.GREEN + "Fly Disabled Success");
                        } else if (!list_of_players.contains(player)) {
                            list_of_players.add(player);
                            player.setAllowFlight(true);
                            player.sendMessage(ChatColor.GREEN + "You have successfully enabled flight mod");
                            
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Sorry you don't have permission");
                    }
    
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (player.hasPermission("menulobby.flyothers")) {
                        if (list_of_players.contains(target)) {
                            list_of_players.remove(target);
                            target.setAllowFlight(false);
                            player.sendMessage(ChatColor.AQUA + "Disabled Fly for" + " " + target.getName());
                            target.sendMessage(player.getName() + ChatColor.GREEN + " " + "Disabled your fly u can't fly now");
                        } else if (!list_of_players.contains(target)) {
                            list_of_players.add(target);
                            target.setAllowFlight(true);
                            player.sendMessage(ChatColor.GREEN + "Enabled fly for" + " " + target.getName());
                            target.sendMessage(player.getName() + " " + ChatColor.GREEN + "Enabled your fly u can fly now");

                        }


                    }
            }
                return true;
                }
        }
        return false;
    }
}
