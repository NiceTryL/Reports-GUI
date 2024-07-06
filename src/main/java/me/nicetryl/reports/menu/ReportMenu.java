package me.nicetryl.reports.menu;

import me.nicetryl.reports.Report;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ReportMenu implements InventoryHolder {

    private final List<Report> activeReports;
    private final Inventory inventory;

    public ReportMenu() {
        this.activeReports = new ArrayList<>();
        this.inventory = Bukkit.createInventory(this, 9 * 5, (ChatColor.BLUE + "" + ChatColor.ITALIC + ChatColor.BOLD + "Reports"));
        createMenu();

    }
    public void createMenu() {
        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        inventory.setItem(9, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inventory.setItem(17, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inventory.setItem(18, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inventory.setItem(26, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inventory.setItem(27, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inventory.setItem(35, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        inventory.setItem(36, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            for (int i = 36; i < 45; i++) {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
    }
    public ItemStack createReportItem(Report reportItem) {
        ItemStack reportInfoItem = new ItemStack(Material.STICK);
        ItemMeta reportMeta = reportInfoItem.getItemMeta();
        if(reportMeta != null) {
            reportMeta.setDisplayName(ChatColor.GOLD + "Reported by: " + reportItem.getReporterNameSt());
            List<String> itemLore = new ArrayList<>();
            itemLore.add(ChatColor.BOLD + "" + ChatColor.YELLOW + "Name: " + ChatColor.WHITE + reportItem.getReportNameSt());
            itemLore.add(ChatColor.BOLD + "" + ChatColor.YELLOW + "Reason: " + ChatColor.WHITE + reportItem.getReportReason());
            itemLore.add(ChatColor.BOLD + "" + ChatColor.YELLOW + "UUID: " + ChatColor.WHITE + reportItem.getReportUUID());
            itemLore.add(ChatColor.DARK_RED + "Click to Delete");
            reportMeta.setLore(itemLore);
            reportInfoItem.setItemMeta(reportMeta);
        }
        return reportInfoItem;
    }

    public void addReport(Report reportInfo) {
        ItemStack reportItem = createReportItem(reportInfo);
        this.inventory.addItem(reportItem);
        this.activeReports.add(reportInfo);
    }
    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
