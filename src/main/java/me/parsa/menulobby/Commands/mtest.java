package me.parsa.menulobby.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mtest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mtest")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                String made_msg = PlaceholderAPI.setPlaceholders(player, "%MenuLobby_username%");
                player.sendMessage(made_msg);
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
