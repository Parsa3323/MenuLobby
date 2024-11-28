package me.parsa.menulobby.Commands;

import me.parsa.menulobby.utils.UnbanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class munban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("munban")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {

                    UnbanMenuUtils.openBanMenu(player);
                }

                String name = player.getDisplayName();
                player.getServer().getBanList(BanList.Type.NAME).pardon(name);
            } else {
                sender.sendMessage("This command can only be used by players!");

            }
            return true;
        }
        return false;
    }
}
