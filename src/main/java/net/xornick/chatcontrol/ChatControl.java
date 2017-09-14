package net.xornick.chatcontrol;

import net.xornick.chatcontrol.commands.ChatCommand;
import net.xornick.chatcontrol.listeners.ChatListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatControl extends JavaPlugin {

    private static ChatControl instance;

    public boolean isChatLocked = false;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("chatcontrol").setExecutor(new ChatCommand());
        register(new ChatListener());
    }

    private void register(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public static ChatControl getInstance() {
        return instance;
    }
}
