package com.alcano.outlaws.command;

import com.alcano.outlaws.registry.init.ItemInit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class RegistryGiveCommand extends BasicCommand {

    public RegistryGiveCommand() {
        super("/reggive [<Player>] [Item]");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (sender instanceof Player p) {
                List<String> ids = ItemInit.ITEMS.getIds();
                if (!ids.contains(args[0])) {
                    p.sendMessage("§cThe item doesn't exist");
                    this.sendIds(p);
                    return false;
                }

                p.getInventory().addItem(ItemInit.ITEMS.get(args[0]).get());
            } else
                this.sendUsage(sender);
        } else if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage("The player doesn't exist");
                return false;
            }

            List<String> ids = ItemInit.ITEMS.getIds();
            if (!ids.contains(args[1])) {
                sender.sendMessage("§cThis item doesn't exist");
                this.sendIds(sender);
                return false;
            }

            target.getInventory().addItem(ItemInit.ITEMS.get(args[1]).get());
        } else
            this.sendUsage(sender);
        return false;
    }

    private void sendIds(CommandSender sender) {
        String msg = "§cFollowing items exist: ";

        List<String> ids = ItemInit.ITEMS.getIds();
        for (int i = 0; i < ids.size(); i++) {
            msg += ids.get(i);

            if (i == ids.size() - 1) continue;

            msg += ", ";
        }

        sender.sendMessage(msg);
    }

}
