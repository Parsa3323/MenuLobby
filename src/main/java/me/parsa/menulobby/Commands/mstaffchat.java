package me.parsa.menulobby.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.parsa.menulobby.MenuLobby;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class mstaffchat {

    Plugin pl;

    MenuLobby ml;


    public mstaffchat(Plugin pl, MenuLobby ml) {
        this.ml = ml;
        this.pl = ml;
    }

    private ArrayList<Player> list_of_staff = new ArrayList<>();

//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if (command.getName().equalsIgnoreCase("mstaffchat")) {
//            if (sender instanceof Player) {
//                Player player = (Player) sender;
//                if (player.hasPermission("menulobby.admin")) {
//                    if (list_of_staff.contains(player)) {
//                        list_of_staff.remove(player);
//                        player.sendMessage(ChatColor.GREEN  + "§lServer " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + "Staff chat disabled");
//                        System.out.println("List of players in staff chat: " + list_of_staff);
//                    } else if (!list_of_staff.contains(player)) {
//                        list_of_staff.add(player);
//                        player.sendMessage(ChatColor.GREEN  + "§lServer " + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + "Staff chat enabled");
//                        System.out.println("List of players in staff chat: " + list_of_staff);
//                        boolean l = list_of_staff.contains(player);
//                        System.out.println(l);
//                    } else {
//                        player.sendMessage(ChatColor.RED + "You don't have permission to do that");
//                    }
//                    player.getServer().getPluginManager().registerEvents(new org.bukkit.event.Listener() {
//                        @org.bukkit.event.EventHandler
//                        public void onPlayerChat(org.bukkit.event.player.AsyncPlayerChatEvent event) {
//                            Player eventPlayer = event.getPlayer();
//                            // Only allow staff chat messages from players in the list_of_staff
//                            if (list_of_staff.contains(eventPlayer)) {
//                                event.setCancelled(true); // Cancel normal broadcast of chat message
//                                String staffMessage = ChatColor.GREEN + "Staff Chat" + ChatColor.DARK_GRAY + " » " + ChatColor.YELLOW + eventPlayer.getName() + ": " + ChatColor.WHITE + event.getMessage();
//
//                                // Send the staff message to all players in the staff list
//                                for (Player staffMember : list_of_staff) {
//                                    staffMember.sendMessage(staffMessage);
//                                }
//                                return;
//                            }
//                        }
//                    },pl /* your plugin instance or this */);
//                }
//
//            } else {
//                sender.sendMessage("This command can only be used by players!");
//            }
//            return true;
//        }
//        return false;
//    }
//    public boolean isStaffChatEnabled(Player player) {
//        boolean list = list_of_staff.contains(player);
//        System.out.println(list);
//        return list;
//    }

//    public void sendToStaffChat(Player sender, String message) {
//        String staffMessage = ChatColor.GREEN + "Staff Chat" + ChatColor.DARK_GRAY + " » "+ ChatColor.YELLOW + sender.getName() + ": " + ChatColor.WHITE + message;
//        for (Player staffMember : list_of_staff) {
//            staffMember.sendMessage(staffMessage);
//        }
//    }
}
