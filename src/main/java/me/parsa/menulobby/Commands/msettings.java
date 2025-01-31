package me.parsa.menulobby.Commands;

import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.utils.SettingsMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msettings implements CommandExecutor {

    private MenuLobby ml;
    public msettings(MenuLobby ml) {
        this.ml = ml;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("msettings")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("menulobby.admin")) {
                    SettingsMenuUtils.openSettings(player, ml);
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission To do that");
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
