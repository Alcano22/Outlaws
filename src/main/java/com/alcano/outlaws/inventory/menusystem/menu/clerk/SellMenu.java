package com.alcano.outlaws.inventory.menusystem.menu.clerk;

import com.alcano.outlaws.entity.Clerk;
import com.alcano.outlaws.inventory.Items;
import com.alcano.outlaws.inventory.PlayerBackpack;
import com.alcano.outlaws.inventory.menusystem.PlayerMenuUtility;
import com.alcano.outlaws.sound.Sounds;
import com.alcano.outlaws.util.Random;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class SellMenu extends ClerkMenu {

    private final PlayerBackpack backpack = PlayerBackpack.get(this.utility.owner);

    private boolean hasSold;
    private Material lastSold;

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

        if (!Items.ITEM_DETAIL_MAP.keySet().stream().toList().contains(item.getType())) return;

        this.backpack.remove(item);
        this.backpack.money += Items.ITEM_DETAIL_MAP.get(item.getType()).worth;

        if (lastSold == item.getType()) {
            this.utility.owner.playSound(this.clerk.getBukkitEntity().getLocation(), Sounds.ENTITY_GUNSMITH_BUY_ITEM_AGAIN, 1f, Random.range(.9f, 1.1f));
        } else
            this.utility.owner.playSound(this.clerk.getBukkitEntity().getLocation(), Items.ITEM_DETAIL_MAP.get(item.getType()).rarity.sellSound, 1f, Random.range(.9f, 1.1f));
        this.lastSold = item.getType();

        this.utility.owner.closeInventory();
        this.hasSold = true;
        this.open();

        System.out.println("");
    }

    @Override
    public void onClose(InventoryCloseEvent e) {

    }

    private void setBackpackContents() {
        for (int i = 0; i < this.backpack.getOccupiedSlots(); i++) {
            this.inventory.setItem(i + 9, this.backpack.getItems().get(i));
        }
    }

    public boolean hasSold() {
        return hasSold;
    }
}
