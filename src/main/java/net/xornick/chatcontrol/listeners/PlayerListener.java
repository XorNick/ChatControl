package net.xornick.chatcontrol.listeners;

import net.xornick.chatcontrol.ChatControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

    private ChatControl plugin = ChatControl.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (plugin.blockInteractionUntilPlayerMove) {
            plugin.moved.add(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!plugin.blockInteractionUntilPlayerMove) {
            return;
        }
        if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
            return;
        }
        plugin.moved.remove(event.getPlayer().getUniqueId());
    }
}
