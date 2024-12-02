package me.parsa.menulobby.Commands;

import net.kyori.adventure.bossbar.BossBar;
import me.parsa.menulobby.MenuLobby;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Countdown implements CommandExecutor {

    private final MenuLobby menuLobby;

    public Countdown(MenuLobby menuLobby) {
        this.menuLobby = menuLobby;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mtest2")) {
            Audience audience = this.menuLobby.adventure().sender(sender);

            BossBar countdownBar = BossBar.bossBar(Component.text("CountDown").color(NamedTextColor.WHITE), 0.5f, BossBar.Color.PINK, BossBar.Overlay.NOTCHED_10);
            audience.showBossBar(countdownBar);
            sender.sendMessage("yo");

            return true;
        }
        return false;
    }
}
