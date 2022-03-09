package com.alcano.outlaws.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class BasicCommand implements CommandExecutor {

    protected final String usage;

    protected BasicCommand(String usage) {
        this.usage = usage;
    }

    protected void sendUsage(CommandSender sender) {
        sender.sendMessage("§cUsage: " + this.usage);
    }

    public void sendOnlyPlayer(CommandSender sender) {
        sender.sendMessage("This command can only used by players");
    }

    public String getUsage() {
        return usage;
    }
}
