package fr.kyristepiu.eoliaminecraftplugin;

import fr.kyristepiu.eoliaminecraftplugin.commands.TestCommand;
import fr.kyristepiu.eoliaminecraftplugin.listeners.EventsListener;
import org.bukkit.plugin.java.JavaPlugin;

public class EoliaPlugin extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("EoliaPlugin wake up");
        getServer().getPluginManager().registerEvents(new EventsListener(), this);
        this.getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable(){
        getLogger().info("EoliaPlugin Shutdown");
    }
}
