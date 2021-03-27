package fr.kyristepiu.eoliaminecraftplugin;

import fr.kyristepiu.eoliaminecraftplugin.commands.TestCommand;
import fr.kyristepiu.eoliaminecraftplugin.listeners.EssentialsEventsListener;
import org.bukkit.plugin.java.JavaPlugin;

public class EoliaPlugin extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("EoliaPlugin wake up");
        if (getServer().getPluginManager().isPluginEnabled("Essentials")){
            getServer().getPluginManager().registerEvents(new EssentialsEventsListener(), this);
        }

        this.getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable(){
        getLogger().info("EoliaPlugin Shutdown");
    }
}
