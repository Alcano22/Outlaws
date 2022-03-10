package com.alcano.outlaws.inventory.menusystem.menu.clerk;

import com.alcano.outlaws.entity.Clerk;
import com.alcano.outlaws.inventory.ItemBuilder;
import com.alcano.outlaws.inventory.menusystem.PlayerMenuUtility;
import com.alcano.outlaws.sound.Sounds;
import com.alcano.outlaws.util.Random;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class OptionMenu extends ClerkMenu {

    public OptionMenu(PlayerMenuUtility utility, Clerk clerk) {
        super(utility, clerk);
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
        Player p = (Player) e.getWhoClicked();

        switch (e.getCurrentItem().getType()) {
            case CARROT_ON_A_STICK -> {
                e.getWhoClicked().closeInventory();

                p.sendMessage("Open buy menu");
            }
            case RAW_GOLD -> {
                e.getWhoClicked().closeInventory();

                p.playSound(clerk.getBukkitEntity().getLocation(), Sounds.ENTITY_GUNSMITH_ENTER_SELL_MENU, 1f, Random.range(.9f, 1.1f));
                new SellMenu(this.utility, this.clerk).open();
            }
        }
    }

    @Override
    public void onClose(InventoryCloseEvent e) {

    }
}
