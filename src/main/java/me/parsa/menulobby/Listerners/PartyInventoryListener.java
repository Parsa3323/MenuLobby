package me.parsa.menulobby.Listerners;

import com.alessiodp.parties.api.Parties;
import com.alessiodp.parties.api.interfaces.PartiesAPI;
import com.alessiodp.parties.api.interfaces.Party;
import com.alessiodp.parties.api.interfaces.PartyPlayer;
import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PartyInventoryListener implements Listener {

    private MenuLobby ml;

    public PartyInventoryListener(MenuLobby ml) {
        this.ml = ml;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (ml.getServer().getPluginManager().getPlugin("Parties") != null) {
            Player p = (Player) e.getWhoClicked();

            if (e.getView().getTitle().equalsIgnoreCase("Parties List")) {

                if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                    PartiesAPI api = Parties.getApi();

                    Player whoToDisband = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                    PartyPlayer pp = api.getPartyPlayer(whoToDisband.getUniqueId());

                    if (pp.isInParty()) {
                        Party party = api.getParty(pp.getPartyId());
                        p.sendMessage(ChatColor.GREEN + "Successfully removed the party refresh the page to see");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1 , 1);
                        party.delete();
                    } else if (!pp.isInParty()) {
                        p.sendMessage(ChatColor.RED + "This person is not in the party");

                    }

                }
                e.setCancelled(true);

            }
        }


    }

}
