package com.alcano.outlaws.inventory.menusystem.menu.clerk;

import com.alcano.outlaws.entity.Clerk;
import com.alcano.outlaws.inventory.menusystem.Menu;
import com.alcano.outlaws.inventory.menusystem.PlayerMenuUtility;

public abstract class ClerkMenu extends Menu {

    protected Clerk clerk;

    public ClerkMenu(PlayerMenuUtility utility, Clerk clerk) {
        super(utility);

        this.clerk = clerk;
    }

}
