package com.alcano.outlaws.world;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Region {

    public static final List<Region> REGIONS = new ArrayList<>();

    public Location bottomCorner;
    public Location topCorner;

    private final List<UUID> players = new ArrayList<>();

    public Region(Location bottomCorner, Location topCorner) {
        if (bottomCorner.getWorld() != topCorner.getWorld()) {
            try {
                throw new Exception("Region corners are in two different worlds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.bottomCorner = bottomCorner;
        this.topCorner = topCorner;

        REGIONS.add(this);
    }

    public boolean hasLocation(Location loc) {
        return loc.getX() >= bottomCorner.getX() &&
                loc.getY() >= bottomCorner.getY() &&
                loc.getZ() >= bottomCorner.getZ() &&
                loc.getX() <= topCorner.getX() &&
                loc.getY() <= topCorner.getY() &&
                loc.getZ() <= topCorner.getZ();
    }

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
    }

    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player.getUniqueId());
    }

    @Override
    public String toString() {
        return "(" + this.bottomCorner.getX() + " " + this.bottomCorner.getY() + " " + this.bottomCorner.getZ() + ") - (" +
                this.topCorner.getX() + " " + this.topCorner.getY() + " " + this.topCorner.getZ() + ")";
    }
}
