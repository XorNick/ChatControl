package net.xornick.chatcontrol.commands;

import net.xornick.chatcontrol.utils.ChatUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("chatcontrol.admin")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
            return true;
        }
        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "/chat [clear, toggle, reload]");
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("toggle")) {
                ChatUtil.toggleChat(player);
            }
        }
        return false;
    }
}
