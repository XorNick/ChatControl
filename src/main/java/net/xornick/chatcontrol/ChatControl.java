package net.xornick.chatcontrol;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatControl extends JavaPlugin {

    private static ChatControl instance;

    public boolean isChatLocked = false;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static ChatControl getInstance() {
        return instance;
    }
}
