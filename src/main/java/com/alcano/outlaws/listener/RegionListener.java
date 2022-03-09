package com.alcano.outlaws.listener;

import com.alcano.outlaws.event.RegionEvent;
import com.alcano.outlaws.sound.Sounds;
import com.alcano.outlaws.util.Random;
import com.alcano.outlaws.world.Region;
import com.alcano.outlaws.world.Shop;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RegionListener implements Listener {

    @EventHandler
    public void onEnter(RegionEvent e) {
        Player p = e.getPlayer();
        Region region = e.getRegion();

        if (region instanceof Shop shop) {
            p.playSound(shop.getClerk().getBukkitEntity().getLocation(),
                    (e.getAction() == RegionEvent.Action.ENTER) ? Sounds.ENTITY_GUNSMITH_GREET_MALE : Sounds.ENTITY_GUNSMITH_FAREWELL, 1.0f, Random.range(.9f, 1.1f));
        }
    }

}
