package me.parsa.menulobby.Commands;

import me.parsa.menulobby.utils.SupportMenuUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msupport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("msupport")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                SupportMenuUtils.openSupport(player);
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
