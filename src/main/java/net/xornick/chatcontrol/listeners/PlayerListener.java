package net.xornick.chatcontrol.listeners;

import net.xornick.chatcontrol.ChatControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private ChatControl plugin = ChatControl.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (plugin.blockInteractionUntilPlayerMove) {
            plugin.moved.add(event.getPlayer().getUniqueId());
        }
    }
}
