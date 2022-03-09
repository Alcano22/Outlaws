package com.alcano.outlaws.world;

import com.alcano.outlaws.entity.Clerk;
import org.bukkit.Location;

public class Shop extends Region {

    private final Clerk clerk;

    public Shop(Location bottomCorner, Location topCorner, Clerk clerk) {
        super(bottomCorner, topCorner);

        this.clerk = clerk;
    }

    public Clerk getClerk() {
        return clerk;
    }
}
