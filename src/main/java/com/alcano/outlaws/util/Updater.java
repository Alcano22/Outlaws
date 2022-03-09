package com.alcano.outlaws.util;

import com.alcano.outlaws.Outlaws;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class Updater {

    private final List<IUpdatable> updatables = new ArrayList<>();

    public void run() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Outlaws.getInstance(), () -> {
            for (IUpdatable updatable : this.updatables) {
                updatable.update();
            }
        }, 0, 1);
    }

    public void add(IUpdatable updatable) {
        this.updatables.add(updatable);
    }

    public void remove(IUpdatable updatable) {
        this.updatables.remove(updatable);
    }

}
