package com.alcano.outlaws;

import com.alcano.outlaws.command.ClerkCommand;
import com.alcano.outlaws.command.RegistryGiveCommand;
import com.alcano.outlaws.listener.PlayerMoveListener;
import com.alcano.outlaws.listener.RegionListener;
import com.alcano.outlaws.listener.packet.PacketListener;
import com.alcano.outlaws.util.Updater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Outlaws extends JavaPlugin {

    private static Outlaws instance;

    private Updater updater;

    @Override
    public void onEnable() {
        instance = this;

        PluginManager plm = Bukkit.getPluginManager();
        plm.registerEvents(new PlayerMoveListener(), this);
        plm.registerEvents(new RegionListener(), this);

        this.getCommand("reggive").setExecutor(new RegistryGiveCommand());
        this.getCommand("clerk").setExecutor(new ClerkCommand());

        PacketListener packetListener = new PacketListener();
        packetListener.start();

        this.updater = new Updater();
        this.updater.run();
    }

    public Updater getUpdater() {
        return updater;
    }

    public static Outlaws getInstance() {
        return instance;
    }
}