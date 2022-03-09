package com.alcano.outlaws.command;

import com.alcano.outlaws.entity.Clerk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClerkCommand extends BasicCommand {

    public ClerkCommand() {
        super("/clerk");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length != 0) {
                this.sendUsage(p);
                return false;
            }

            Clerk clerk = new Clerk(p.getLocation());
        } else
            this.sendOnlyPlayer(sender);
        return false;
    }
}
