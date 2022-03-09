package com.alcano.outlaws.util;

import com.alcano.outlaws.entity.NPCSkin;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.util.UUID;

public class GameProfileUtils {

    public static GameProfile createWithSkin(UUID uuid, String name, NPCSkin skin) {
        GameProfile profile = new GameProfile(uuid, name);

        profile.getProperties().put("textures", new Property("textures", skin.texture, skin.signature));

        return profile;
    }

    public static GameProfile createWithSkin(String name, NPCSkin skin) {
        return createWithSkin(UUID.randomUUID(), name, skin);
    }

}
