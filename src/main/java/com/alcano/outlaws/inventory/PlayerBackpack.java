package com.alcano.outlaws.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class PlayerBackpack {

    public static final int DEFAULT_CAPACITY = 9;

    private static final Map<UUID, PlayerBackpack> PLAYER_BACKPACK_MAP = new HashMap<>();

    public final Player player;

    public int capacity;
    public float money;

    private final List<ItemStack> items = new ArrayList<>(0);

    public PlayerBackpack(Player player, int capacity) {
        this.player = player;
        this.capacity = capacity;

        PLAYER_BACKPACK_MAP.put(this.player.getUniqueId(), this);
    }

    public static PlayerBackpack get(Player player) {
        UUID uuid = player.getUniqueId();

        if (PLAYER_BACKPACK_MAP.containsKey(uuid)) {
            return PLAYER_BACKPACK_MAP.get(uuid);
        }

        PlayerBackpack backpack = new PlayerBackpack(player, DEFAULT_CAPACITY);
        PLAYER_BACKPACK_MAP.put(uuid, backpack);

        return backpack;
    }

    public boolean add(ItemStack item) {
        if (this.items.size() >= this.capacity) return false;

        this.items.add(item);
        return true;
    }

    public void remove(ItemStack item) {
        this.items.remove(item);
    }

    public int getOccupiedSlots() {
        return this.items.size();
    }

    public List<ItemStack> getItems() {
        return items;
    }
}
