package me.parsa.menulobby.advertise;

import me.parsa.menulobby.MenuLobby;
import me.parsa.menulobby.api.Event.AdSendEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ads {

    private final MenuLobby ml;

    boolean enabled;

    boolean sound_effects;

    String sound;

    String chat_messages;

    int shows_every;

    boolean titles_enabled;

    String title_title;

    String title_description;

    public ads(MenuLobby ml, boolean enabled, boolean sound_effects, String sound, String chat_message, int shows_every, boolean titles_enabled, String title_title, String title_description) {
        this.ml = ml;
        this.enabled = enabled;
        this.sound_effects = sound_effects;
        this.sound = sound;
        this.chat_messages = chat_message;
        this.shows_every = shows_every;
        this.titles_enabled = titles_enabled;
        this.title_title = title_title;
        this.title_description = title_description;
    }


    public void Start() {
        if (enabled) {
            ml.getServer().getScheduler().scheduleSyncRepeatingTask(ml, new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage(chat_messages);

                    Sound soundEffect = null;

                    ArrayList<Player> players =  new ArrayList<Player>(Bukkit.getOnlinePlayers());

                    AdSendEvent events = new AdSendEvent(chat_messages, title_title, players);
                    Bukkit.getPluginManager().callEvent(events);
                    if (!events.isCancelled()) {
                        try {
                            soundEffect = Sound.valueOf(sound.toUpperCase());

                        } catch (IllegalArgumentException e) {
                            System.out.println("[DEBUG] Invalid sound name: " + sound);
                        }

                        if (titles_enabled) {
                            for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                                onlinePlayer.sendTitle(title_title, title_description);
                                if (sound_effects) {
                                    onlinePlayer.playSound(onlinePlayer.getLocation(), soundEffect, 1 , 1);
                                }

                            }
                        }
                    } else if (events.isCancelled()) {
                        System.out.println("[DEBUG] event for ads has been canceled");
                    }

                }

            }, 0L, shows_every);
        }

    }

}
