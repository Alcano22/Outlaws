package com.alcano.outlaws.listener;

import com.alcano.outlaws.inventory.menusystem.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        InventoryHolder holder = e.getClickedInventory().getHolder();
        if (holder == null) return;
        if (holder instanceof Menu menu) {
            e.setCancelled(true);

            if (e.getCurrentItem() == null) return;

            menu.onClick(e);
        }
    }

    @EventHandler
    public void onMenuClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        InventoryHolder holder = e.getInventory().getHolder();

        if (holder == null) return;

        if (holder instanceof Menu menu) menu.onClose(e);
    }

}
