package me.parsa.menulobby.Commands;

import me.parsa.menulobby.MenuLobby;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;;

public class m implements CommandExecutor {

    private final MenuLobby ml;
    public m(MenuLobby ml) {
        this.ml = ml;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("m")) {
            if (sender.hasPermission("menulobby.admin")) {
                ml.showHelp(sender);
//                sender.sendMessage( ChatColor.GOLD + "Commands: ");
//                sender.sendMessage(ChatColor.GREEN + "Prefix: M");
//                sender.sendMessage(ChatColor.AQUA + "mfly : enable or disable fly mode");
//                sender.sendMessage(ChatColor.AQUA + "mmembers: Opens a gui menu for banning or managing memebrs");
            } else {
                sender.sendMessage(ChatColor.AQUA + "MenuLobby Running v" + ml.getDescription().getVersion());
            }
            return true;
        }
        return false;
    }
}
