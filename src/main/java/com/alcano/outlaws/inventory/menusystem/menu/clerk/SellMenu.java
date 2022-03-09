package com.alcano.outlaws.inventory.menusystem.menu.clerk;

import com.alcano.outlaws.entity.Clerk;
import com.alcano.outlaws.inventory.Items;
import com.alcano.outlaws.inventory.PlayerBackpack;
import com.alcano.outlaws.inventory.menusystem.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SellMenu extends ClerkMenu {

    private final PlayerBackpack backpack = PlayerBackpack.get(this.utility.owner);

    public SellMenu(PlayerMenuUtility utility, Clerk clerk) {
        super(utility, clerk);
    }

    @Override
    public int getSlots() {
        return 3 * 9;
    }

    @Override
    public String getTitle() {
        return "§eSell";
    }

    @Override
    public void setMenuItems() {
        for (int i = 9; i < 18; i++) {
            this.inventory.setItem(i, new ItemStack(Material.AIR));
        }

        this.setBackpackContents();
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        ItemStack item = e.getCurrentItem();

        this.backpack.remove(item);
        this.backpack.money += Items.ITEM_WORTH_MAP.get(item.getType());

        this.utility.owner.closeInventory();
        this.open();
    }

    private void setBackpackContents() {
        for (int i = 0; i < this.backpack.getOccupiedSlots(); i++) {
            this.inventory.setItem(i + 9, this.backpack.getItems().get(i));
        }
    }
}
