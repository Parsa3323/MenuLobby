package me.parsa.menulobby.Commands;

import me.parsa.menulobby.Config.Spawns;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class lobby implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("lobby")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Object rawSpawnLocation = Spawns.get().get("Spawn-Main");

                if (rawSpawnLocation == null) {
                    System.out.println("[DEBUG] 'Spawn-Main' is missing or null in the configuration!");
                    player.sendMessage("§cSpawn location is not configured correctly. Please inform an admin.");

                }
                Location spawn = null;
                try {
                    spawn = (Location) rawSpawnLocation;
                } catch (ClassCastException ex) {
                    System.out.println("[DEBUG] 'Spawn-Main' is not a valid Location object! Error: " + ex.getMessage());
                    player.sendMessage("§cSpawn location is corrupted in the configuration!");

                }

                World world = spawn.getWorld();
                if (world == null) {
                    System.out.println("[DEBUG] World for 'Spawn-Main' is null or not loaded!");
                    player.sendMessage("§cThe world for the spawn location is not loaded. Please inform an admin.");

                }

                System.out.println("[DEBUG] Teleporting player '" + player.getName() + "' to the spawn location.");

                boolean teleportSuccess = player.teleport(spawn);
                System.out.println("[DEBUG] Teleport success: " + teleportSuccess);
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1 , 1);


            } else {
                sender.sendMessage("This command can only be used by players!");
            }
            return true;
        }
        return false;
    }
}
