package net.xornick.chatcontrol;

import net.xornick.chatcontrol.commands.ChatCommand;
import net.xornick.chatcontrol.listeners.ChatListener;
import net.xornick.chatcontrol.listeners.PlayerListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ChatControl extends JavaPlugin {

    private static ChatControl instance;

    public boolean isChatLocked = false;
    public boolean blockInteractionUntilPlayerMove = getConfig().getBoolean("blockInteractionUntilPlayerMove");

    public final List<UUID> moved = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("chatcontrol").setExecutor(new ChatCommand());
        register(new ChatListener());
        register(new PlayerListener());
    }

    private void register(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public static ChatControl getInstance() {
        return instance;
    }
}
