package me.nicetryl.reports.commands;

import me.nicetryl.reports.menu.ReportMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportMenuCommand implements CommandExecutor {
    private final ReportMenu reportMenu;

    public ReportMenuCommand(ReportMenu reportMenu) {
        this.reportMenu = reportMenu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }
        player.openInventory(reportMenu.getInventory());
        player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "You have opened the Report Menu!");
        return true;
    }
}
