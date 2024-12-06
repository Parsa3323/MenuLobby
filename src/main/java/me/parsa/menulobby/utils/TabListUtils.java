package me.parsa.menulobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class TabListUtils {

    public void createScoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective( "DS", "dummy");
        objective.setDisplayName(ChatColor.AQUA + "Player Info");
        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST); // Display on the side

        objective.getScore(p.getName()).setScore(0);

        p.setScoreboard(scoreboard);
    }

}
