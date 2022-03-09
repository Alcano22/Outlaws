package com.alcano.outlaws.entity;

import com.alcano.outlaws.inventory.menusystem.PlayerMenuUtility;
import com.alcano.outlaws.inventory.menusystem.menu.clerk.OptionMenu;
import com.alcano.outlaws.sound.Sounds;
import com.alcano.outlaws.util.Random;
import com.alcano.outlaws.world.Shop;
import com.comphenix.protocol.wrappers.EnumWrappers;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Clerk extends NPC {

    private final Shop shop;

    public Clerk(Location loc) {
        super(loc, "Clerk", NPCSkin.ofPlayer("66eeb0b8dc0b4af4924f72608966acba"));
        this.shop = new Shop(loc.clone().add(-5, 0, -5), loc.clone().add(5, 2, 5), this);
    }

    @Override
    public void update() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getLocation().distance(this.getBukkitEntity().getLocation()) >= 3.5 && shop.hasPlayer(p)) continue;

            ServerPlayer sp = ((CraftPlayer) p).getHandle();

            Location loc = this.getBukkitEntity().getLocation();
            loc.setDirection(p.getLocation().subtract(loc).toVector());
            float yaw = loc.getYaw();
            float pitch = loc.getPitch();

            ServerGamePacketListenerImpl connection = sp.connection;
            connection.send(new ClientboundRotateHeadPacket(this, (byte) ((yaw % 360) * 256 / 360)));
            connection.send(new ClientboundMoveEntityPacket.Rot(this.getBukkitEntity().getEntityId(), (byte) ((yaw % 360) * 256 / 360), (byte) ((pitch % 360) * 256 / 360), false));
        }
    }

    @Override
    public void onInteract(Player p, EnumWrappers.Hand hand, EnumWrappers.EntityUseAction action) {
        if (hand != EnumWrappers.Hand.MAIN_HAND || action != EnumWrappers.EntityUseAction.INTERACT) return;

        p.playSound(this.getBukkitEntity().getLocation(), Sounds.ENTITY_GUNSMITH_ENTER_OPTION_MENU, 1f, Random.range(.9f, 1.1f));

        OptionMenu menu = new OptionMenu(new PlayerMenuUtility(p), this);
        menu.open();
    }

    public Shop getShop() {
        return shop;
    }
}
