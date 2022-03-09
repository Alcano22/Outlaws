package com.alcano.outlaws.listener;

import com.alcano.outlaws.event.RegionEvent;
import com.alcano.outlaws.world.Region;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location to = e.getTo();

        for (Region region : Region.REGIONS) {
            if (region.hasLocation(to) && !region.hasPlayer(p)) {
                region.addPlayer(p);
                Bukkit.getPluginManager().callEvent(new RegionEvent(region, p, RegionEvent.Action.ENTER));
            }

            if (!region.hasLocation(to) && region.hasPlayer(p)) {
                region.removePlayer(p);
                Bukkit.getPluginManager().callEvent(new RegionEvent(region, p, RegionEvent.Action.LEAVE));
            }
        }
    }

}
