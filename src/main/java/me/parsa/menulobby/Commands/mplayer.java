package me.parsa.menulobby.Commands;

import me.parsa.menulobby.utils.PlayerMenuUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mplayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mplayer")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                PlayerMenuUtils.openPlayer(player, player);
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }

}
