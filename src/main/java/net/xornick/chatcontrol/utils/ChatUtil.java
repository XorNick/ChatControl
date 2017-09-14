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
                onlinePlayers.sendMessage(ChatColor.YELLOW + "Server chat has been disabled by " + ChatColor.GREEN + player.getName());
            }
            player.sendMessage(ChatColor.GREEN + "Server chat toggled off!");
        }
    }
}
