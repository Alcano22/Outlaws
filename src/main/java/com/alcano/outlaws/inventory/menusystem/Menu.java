package com.alcano.outlaws.inventory.menusystem;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;
    protected PlayerMenuUtility utility;

    public Menu(PlayerMenuUtility utility) {
        this.utility = utility;
    }

    public abstract int getSlots();
    public abstract String getTitle();
    public abstract void setMenuItems();
    public abstract void onClick(InventoryClickEvent e);

    public void open() {
        this.inventory = Bukkit.createInventory(this, this.getSlots(), this.getTitle());

        this.setMenuItems();

        this.utility.owner.openInventory(this.inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
