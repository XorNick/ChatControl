package net.xornick.chatcontrol.utils;

import net.xornick.chatcontrol.ChatControl;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {

    private static ChatControl plugin = ChatControl.getInstance();

    public static void toggleChat(Player player) {
        if (!plugin.isChatLocked) {
            plugin.isChatLocked = true;

            for (Player onlinePlayers : plugin.getServer().getOnlinePlayers()) {
                onlinePlayers.sendMessage(ChatColor.GREEN + "Server chat has been disabled by " + ChatColor.YELLOW + player.getName());
            }
            player.sendMessage(ChatColor.GREEN + "Server chat toggled off!");
        }
    }

    public static void clearChat(Player player) {
        for (Player onlinePlayers : plugin.getServer().getOnlinePlayers()) {
            for (int i = 0; i < 75; i++) {
                onlinePlayers.sendMessage(" ");
            }
            onlinePlayers.sendMessage(ChatColor.GREEN + "Server chat cleared by " + ChatColor.YELLOW + player.getName());
        }
        player.sendMessage(ChatColor.GREEN + "Server chat has been cleared!");
    }
}
