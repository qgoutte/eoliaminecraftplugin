package fr.kyristepiu.eoliaminecraftplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventsListener implements Listener {

    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent event){
        //TODO: Find how to have the name of the item in the good language
        event.getPlayer().sendMessage(ChatColor.DARK_AQUA+ "Ton "+ event.getBrokenItem().getType().name() +" est cassé :(");
    }
}
