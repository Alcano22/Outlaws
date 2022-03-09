package com.alcano.outlaws.event;

import com.alcano.outlaws.world.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RegionEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Region region;
    private final Player player;
    private final Action action;

    public RegionEvent(Region region, Player player, Action action) {
        this.region = region;
        this.player = player;
        this.action = action;
    }

    public Region getRegion() {
        return region;
    }

    public Player getPlayer() {
        return player;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public enum Action {
        ENTER,
        LEAVE
    }
}
