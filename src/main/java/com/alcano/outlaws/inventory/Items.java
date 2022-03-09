package com.alcano.outlaws.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class Items {

    public static final Map<Material, Float> ITEM_WORTH_MAP = new HashMap<>();

    static {
        ITEM_WORTH_MAP.put(Material.GOLD_NUGGET, 10f);
        ITEM_WORTH_MAP.put(Material.RAW_GOLD, 25f);
        ITEM_WORTH_MAP.put(Material.EMERALD, 75f);
        ITEM_WORTH_MAP.put(Material.DIAMOND, 100f);
    }

    private Items() {}

}
