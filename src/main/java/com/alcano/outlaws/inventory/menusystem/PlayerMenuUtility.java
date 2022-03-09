package com.alcano.outlaws.inventory.menusystem;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerMenuUtility {

    private static final Map<UUID, PlayerMenuUtility> PLAYER_MENU_UTILITY_MAP = new HashMap<>();

    public Player owner;

    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        if (PLAYER_MENU_UTILITY_MAP.containsKey(p.getUniqueId())) {
            return PLAYER_MENU_UTILITY_MAP.get(p);
        } else {
            PlayerMenuUtility utility = new PlayerMenuUtility(p);
            PLAYER_MENU_UTILITY_MAP.put(p.getUniqueId(), utility);

            return utility;
        }
    }

}
