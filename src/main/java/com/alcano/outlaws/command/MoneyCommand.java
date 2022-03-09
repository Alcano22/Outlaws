package com.alcano.outlaws.command;

import com.alcano.outlaws.inventory.PlayerBackpack;
import com.alcano.outlaws.util.Mathf;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand extends BasicCommand {

    public MoneyCommand() {
        super("/money");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length != 0) {
                this.sendUsage(p);
                return false;
            }

            PlayerBackpack backpack = PlayerBackpack.get(p);
            p.sendMessage("§eYou have $" + Mathf.floatToMoney(backpack.money));
        } else
            this.sendOnlyPlayer(sender);
        return false;
    }
}
