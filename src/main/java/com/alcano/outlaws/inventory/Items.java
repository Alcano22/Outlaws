package com.alcano.outlaws.inventory;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public final class Items {

    public static final Map<Material, ItemDetails> ITEM_DETAIL_MAP = new HashMap<>();

    static {
        ITEM_DETAIL_MAP.put(Material.GOLD_NUGGET, new ItemDetails("Gold Nugget", 10f, ItemDetails.Rarity.AVERAGE));
        ITEM_DETAIL_MAP.put(Material.RAW_GOLD, new ItemDetails("Big Gold Nugget", 30f, ItemDetails.Rarity.AVERAGE));
        ITEM_DETAIL_MAP.put(Material.EMERALD, new ItemDetails("Emerald", 65f, ItemDetails.Rarity.AVERAGE));
        ITEM_DETAIL_MAP.put(Material.DIAMOND, new ItemDetails("Diamond", 95f, ItemDetails.Rarity.AVERAGE));
    }

    private Items() {}

}
