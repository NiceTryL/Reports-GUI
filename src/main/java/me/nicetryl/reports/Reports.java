package me.nicetryl.reports;

import me.nicetryl.reports.commands.ReportCommand;
import me.nicetryl.reports.commands.ReportMenuCommand;
import me.nicetryl.reports.listeners.ReportListener;

import me.nicetryl.reports.menu.ReportMenu;
import org.bukkit.plugin.java.JavaPlugin;

public final class Reports extends JavaPlugin {

    @Override
    public void onEnable() {
        ReportMenu reportMenu = new ReportMenu();
        getCommand("report").setExecutor(new ReportCommand(reportMenu));
        getCommand("reportmenu").setExecutor(new ReportMenuCommand(reportMenu));
        getServer().getPluginManager().registerEvents(new ReportListener(), this);
    }
}
