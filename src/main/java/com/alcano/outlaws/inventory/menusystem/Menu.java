package com.alcano.outlaws.inventory.menusystem;

import com.alcano.outlaws.inventory.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class Menu implements InventoryHolder {

    protected static final ItemStack PLACEHOLDER = new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).name(" ").build();

    protected Inventory inventory;
    protected PlayerMenuUtility utility;

    public Menu(PlayerMenuUtility utility) {
        this.utility = utility;
    }

    public abstract int getSlots();
    public abstract String getTitle();
    public abstract void setMenuItems();
    public abstract void onClick(InventoryClickEvent e);
    public abstract void onClose(InventoryCloseEvent e);

    public void open() {
        this.inventory = Bukkit.createInventory(this, this.getSlots(), this.getTitle());

        for (int i = 0; i < this.getSlots(); i++) {
            this.inventory.setItem(i, PLACEHOLDER);
        }
        this.setMenuItems();

        this.utility.owner.openInventory(this.inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
