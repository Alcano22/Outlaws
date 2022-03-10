package com.alcano.outlaws.inventory;

import com.alcano.outlaws.sound.Sounds;
import com.alcano.outlaws.util.IUpdatable;

public class ItemDetails {

    public enum Rarity {
        POOR(Sounds.ENTITY_GUNSMITH_BUY_POOR_ITEM),
        AVERAGE(Sounds.ENTITY_GUNSMITH_BUY_AVERAGE_ITEM),
        QUALITY(Sounds.ENTITY_GUNSMITH_BUY_QUALITY_ITEM),
        UNIQUE(Sounds.ENTITY_GUNSMITH_BUY_UNIQUE_ITEM);

        public final String sellSound;

        Rarity(String sellSound) {
            this.sellSound = sellSound;
        }
    }

    public final String name;
    public final float worth;
    public final Rarity rarity;

    public ItemDetails(String name, float worth, Rarity rarity) {
        this.name = name;
        this.worth = worth;
        this.rarity = rarity;
    }

}
