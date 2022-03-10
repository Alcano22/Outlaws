package com.alcano.outlaws.listener;

import com.alcano.outlaws.inventory.Items;
import com.alcano.outlaws.inventory.PlayerBackpack;
import com.alcano.outlaws.util.Subtitle;
import org.bukkit.Sound;
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

            if (!Items.ITEM_DETAIL_MAP.keySet().stream().toList().contains(item.getType())) return;

            e.setCancelled(true);

            if(!PlayerBackpack.get(p).add(item)) {
                Subtitle.show(p, "§cBackpack is full!");
                return;
            }

            p.playSound(e.getItem().getLocation(), Sound.ENTITY_ITEM_PICKUP, 1f, .75f);
            e.getItem().remove();
        }
    }

}
