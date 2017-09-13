package net.xornick.chatcontrol.listeners;

import net.xornick.chatcontrol.ChatControl;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private ChatControl plugin = ChatControl.getInstance();

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("chatcontrol.admin")) {
            return;
        }
        if (plugin.isChatLocked) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("CHAT_LOCKED_ERROR")));
            event.setCancelled(true);
            return;
        }

    }
}
