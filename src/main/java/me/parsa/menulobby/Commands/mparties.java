package me.parsa.menulobby.Commands;

import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.utils.PartyMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mparties implements CommandExecutor {

    private MenuLobby ml;

    public mparties(MenuLobby ml) {
        this.ml = ml;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mparties")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (ml.getServer().getPluginManager().getPlugin("Parties") != null) {
                    // DONT FORGET TO PUT
                    PartyMenuUtils.openPartyMenu(ml, player);
                } else {
                    player.sendMessage(ChatColor.RED + "No Party Plugin Found");
                }

            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
