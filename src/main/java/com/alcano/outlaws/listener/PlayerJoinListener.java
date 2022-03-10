package com.alcano.outlaws.listener;

import com.alcano.outlaws.entity.NPC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        for (NPC npc : NPC.NPCS) {
            npc.addToClient(e.getPlayer());
        }
    }

}
