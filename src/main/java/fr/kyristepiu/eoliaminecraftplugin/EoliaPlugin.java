package fr.kyristepiu.eoliaminecraftplugin;

import fr.kyristepiu.eoliaminecraftplugin.commands.TestCommand;
import fr.kyristepiu.eoliaminecraftplugin.listeners.VaultEventsListener;
import fr.kyristepiu.eoliaminecraftplugin.listeners.EventsListener;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class EoliaPlugin extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy economy = null;
    private static Permission permissions = null;
    private static Chat chat = null;

    @Override
    public void onEnable(){

        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        setupPermissions();
        setupChat();

        getServer().getPluginManager().registerEvents(new EventsListener(), this);
        getServer().getPluginManager().registerEvents(new VaultEventsListener(), this);

        this.getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        permissions = rsp.getProvider();
        return permissions != null;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static Permission getPermissions() {
        return permissions;
    }

    public static Chat getChat() {
        return chat;
    }
}
