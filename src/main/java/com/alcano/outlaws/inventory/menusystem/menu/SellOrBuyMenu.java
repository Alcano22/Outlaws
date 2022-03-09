package com.alcano.outlaws.inventory.menusystem.menu;

import com.alcano.outlaws.inventory.ItemBuilder;
import com.alcano.outlaws.inventory.menusystem.Menu;
import com.alcano.outlaws.inventory.menusystem.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SellOrBuyMenu extends Menu {

    public SellOrBuyMenu(PlayerMenuUtility utility) {
        super(utility);
    }

    @Override
    public int getSlots() {
        return 3 * 9;
    }

    @Override
    public String getTitle() {
        return "§eSell or buy?";
    }

    @Override
    public void setMenuItems() {
        ItemStack buy = new ItemBuilder(Material.CARROT_ON_A_STICK).name("§eBuy").customModelData(3).build();
        ItemStack sell = new ItemBuilder(Material.RAW_GOLD).name("§eSell").build();

        this.inventory.setItem(12, buy);
        this.inventory.setItem(14, sell);
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        switch (e.getCurrentItem().getType()) {
            case CARROT_ON_A_STICK:
                e.getWhoClicked().closeInventory();
                break;
            case RAW_GOLD:
                e.getWhoClicked().closeInventory();
                break;
        }
    }
}
