package com.alcano.outlaws.listener;

import com.alcano.outlaws.inventory.Items;
import com.alcano.outlaws.inventory.PlayerBackpack;
import com.alcano.outlaws.util.Subtitle;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerPickupItemListener implements Listener {

    @EventHandler
    public void onPickup(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player p) {
            ItemStack item = e.getItem().getItemStack();

            if (!Items.ITEM_WORTH_MAP.keySet().stream().toList().contains(item.getType())) return;

            e.setCancelled(true);

            item.setAmount(1);

            if(!PlayerBackpack.get(p).add(item)) {
                Subtitle.show(p, "§cBackpack is full!");
                return;
            }

            e.getItem().remove();
        }
    }

}
