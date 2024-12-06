package me.parsa.menulobby.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class mstaffchat implements CommandExecutor {

    private ArrayList<Player> list_of_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mstaffchat")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("menulobby.admin")) {
                    if (list_of_players.contains(player)) {
                        player.sendMessage(ChatColor.GREEN  + "§lServer " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + "Staff chat disabled");
                        list_of_players.remove(player);
                    } else if (!list_of_players.contains(player)) {
                        player.sendMessage(ChatColor.GREEN  + "§lServer " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + "Staff chat enabled");
                        list_of_players.add(player);
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have permission to do that");
                    }
                }

            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
    public boolean isStaffChatEnabled(Player player) {
        return list_of_players.contains(player);
    }

    public void sendToStaffChat(Player sender, String message) {
        String staffMessage = ChatColor.GREEN + "Staff Chat" + ChatColor.DARK_GRAY + " » "+ ChatColor.YELLOW + sender.getName() + ": " + ChatColor.WHITE + message;
        for (Player staffMember : list_of_players) {
            staffMember.sendMessage(staffMessage);
        }
    }
}
