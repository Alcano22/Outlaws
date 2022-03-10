package com.alcano.outlaws.entity;

import com.alcano.outlaws.Outlaws;
import com.alcano.outlaws.util.GameProfileUtils;
import com.alcano.outlaws.util.IUpdatable;
import com.comphenix.protocol.wrappers.EnumWrappers;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.npc.Npc;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;

public abstract class NPC extends ServerPlayer implements IUpdatable {

    public static final List<NPC> NPCS = new ArrayList<>();

    protected NPC(Location loc, String name, NPCSkin skin) {
        super(((CraftWorld) loc.getWorld()).getHandle().getServer(), ((CraftWorld) loc.getWorld()).getHandle(), GameProfileUtils.createWithSkin(name, skin));

        this.setPos(loc.getX(), loc.getY(), loc.getZ());

        Outlaws.getInstance().getUpdater().add(this);

        for (Player p : Bukkit.getOnlinePlayers()) {
            ServerPlayer sp = ((CraftPlayer) p).getHandle();

            ServerGamePacketListenerImpl connection = sp.connection;
            connection.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.ADD_PLAYER, this));
            connection.send(new ClientboundAddPlayerPacket(this));
        }

        NPCS.add(this);
    }

    public static NPC getById(int id) {
        for (NPC npc : NPCS) {
            if (id == npc.getId()) return npc;
        }

        return null;
    }

    public abstract void onInteract(Player p, EnumWrappers.Hand hand, EnumWrappers.EntityUseAction action);

    public void addToClient(Player p) {
        ServerPlayer sp = ((CraftPlayer) p).getHandle();

        ServerGamePacketListenerImpl connection = sp.connection;
        connection.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.ADD_PLAYER, this));
        connection.send(new ClientboundAddPlayerPacket(this));
    }

    public void removeFromClient(Player p) {
        ServerPlayer sp = ((CraftPlayer) p).getHandle();

        ServerGamePacketListenerImpl connection = sp.connection;
        connection.send(new ClientboundPlayerInfoPacket(ClientboundPlayerInfoPacket.Action.REMOVE_PLAYER, this));
    }
}
