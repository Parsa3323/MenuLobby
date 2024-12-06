package me.parsa.menulobby.Commands;

import me.parsa.menulobby.utils.PingUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mping implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mping")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int Ping = PingUtils.getPing(player);
                player.sendMessage(ChatColor.GREEN  + "§lPing" + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + Ping);
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
