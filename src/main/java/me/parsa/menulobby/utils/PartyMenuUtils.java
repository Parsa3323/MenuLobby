package me.parsa.menulobby.utils;

import com.alessiodp.parties.api.Parties;
import com.alessiodp.parties.api.interfaces.PartiesAPI;
import com.alessiodp.parties.api.interfaces.Party;
import com.alessiodp.parties.api.interfaces.PartyPlayer;
import me.parsa.menulobby.MenuLobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class PartyMenuUtils {

    private MenuLobby ml;

    public static void openPartyMenu(MenuLobby ml, Player player) {
        if (ml.getServer().getPluginManager().getPlugin("Parties") != null) {
            ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

            Inventory bangui = Bukkit.createInventory(player, 45, "Parties List");

            for (Player value : list) {
                //------------------------
                PartiesAPI api = Parties.getApi();
                String party_description = null;
                String party_inform = null;
                PartyPlayer partyPlayer = api.getPartyPlayer(value.getUniqueId());
                if (partyPlayer.isInParty()) {
                    Party party = api.getParty(partyPlayer.getPartyId());
                    if (party != null) {
                        party_description = party.getDescription();
                        UUID d = party.getLeader();
                        Player party_leader = Bukkit.getPlayer(d);
                        Set<UUID> set = party.getMembers();
                        int count = 1;
                        ArrayList<String> partyInfoList = new ArrayList<>();


                        if (party_leader != null && party_leader.isOnline()) {
                            partyInfoList.add(ChatColor.GREEN + "Leader: " + party_leader.getName());
                        }


                        for (UUID uuid : set) {
                            Player players = Bukkit.getPlayer(uuid);

                            if (players != null && players.isOnline()) {

                                partyInfoList.add(ChatColor.YELLOW + "➤ " + players.getName() + " " + ChatColor.GREEN + "Online");
                                count++;
                            }
                        }

                        party_inform = " ";


                        ArrayList<String> lore = new ArrayList<>();
                        for (String line : partyInfoList) {
                            lore.add(line);
                        }
                        lore.add(ChatColor.GOLD + "Xp: " + ChatColor.AQUA + value.getExp());
                        lore.add(" ");
                        lore.add(" ");
                        lore.add(ChatColor.YELLOW + "Click to disband");


                        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1);
                        ItemMeta meta = playerHead.getItemMeta();
                        meta.setDisplayName(value.getDisplayName());
                        meta.setLore(lore);
                        playerHead.setItemMeta(meta);
                        bangui.addItem(playerHead);
                    }
                }
                //-----------------------

            }

            if (player.hasPermission("menulobby.admin")) {
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);
                player.openInventory(bangui);
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to do that");
            }
        }
    }
}
