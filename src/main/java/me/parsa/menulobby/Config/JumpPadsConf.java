package me.parsa.menulobby.Config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class JumpPadsConf {
    private static File file;

    private static FileConfiguration fileConfiguration;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("MenuLobby").getDataFolder(), "jumppads.yml");


        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fileConfiguration = YamlConfiguration.loadConfiguration(file);


    }

    public static FileConfiguration get() {
        return fileConfiguration;
    }

    public static void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while saving : " + e.getMessage());
        }

    }

    public static void reload(){
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

}
