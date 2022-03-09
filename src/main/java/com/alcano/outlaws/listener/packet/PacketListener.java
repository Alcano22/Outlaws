package com.alcano.outlaws.listener.packet;

import com.alcano.outlaws.Outlaws;
import com.alcano.outlaws.entity.NPC;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;

public class PacketListener {

    public void start() {
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();

        manager.addPacketListener(new PacketAdapter(Outlaws.getInstance(), PacketType.Play.Client.USE_ENTITY) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                PacketContainer packet = event.getPacket();

                int entityId = packet.getIntegers().read(0);
                EnumWrappers.Hand hand = packet.getEnumEntityUseActions().read(0).getHand();
                EnumWrappers.EntityUseAction action = packet.getEnumEntityUseActions().read(0).getAction();

                NPC npc = NPC.getById(entityId);
                if (npc == null) return;

                npc.onInteract(event.getPlayer(), hand, action);
            }
        });
    }

}
