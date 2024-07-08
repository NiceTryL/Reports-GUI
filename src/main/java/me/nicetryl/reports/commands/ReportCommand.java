package me.nicetryl.reports.commands;

import me.nicetryl.reports.Report;
import me.nicetryl.reports.menu.ReportMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReportCommand implements CommandExecutor {
    private final ReportMenu reportMenu;

    public ReportCommand(ReportMenu reportMenu) {
        this.reportMenu = reportMenu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
            return true;
        }
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "You have not specified a name or reason. Use /report <name> <reason> to report.");
                return true;
            }
            String playerName = args[0];
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                builder.append(args[i]);
                builder.append(" ");
            }
            String reason = builder.toString().stripTrailing();

            Player target = Bukkit.getServer().getPlayerExact(playerName);
            if (target == sender) {
                 p.sendMessage(ChatColor.RED + "You cannot report yourself. Please provide a different player.");
                return true;
            }
            if (target == null) {
                p.sendMessage(ChatColor.RED + "This user is not online or does not exist.");
            } else {
                UUID targetUUID = target.getUniqueId();
                String reporterName = p.getName();

                Report reportInfo = new Report(reason, targetUUID, playerName, reporterName);
                reportMenu.addReport(reportInfo);

                p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You have reported " + ChatColor.WHITE + playerName
                        + ChatColor.AQUA + ChatColor.BOLD + " for " + ChatColor.WHITE + reason);
            }
        return true;
    }
}
