package me.nicetryl.reports.listeners;

import me.nicetryl.reports.menu.ReportMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.Objects;

public class ReportListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        InventoryHolder holder = Objects.requireNonNull(e.getClickedInventory()).getHolder();
        if(holder instanceof ReportMenu) {
                e.setCancelled(true);

            if (Objects.requireNonNull(e.getCurrentItem()).getType() == Material.STICK) {
                e.getInventory().setItem(e.getSlot(), null);
                e.getWhoClicked().sendMessage(ChatColor.GOLD + "Report removed");
            }
        }
    }
}
