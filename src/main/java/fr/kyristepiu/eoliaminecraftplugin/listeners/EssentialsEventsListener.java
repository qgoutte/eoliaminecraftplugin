package fr.kyristepiu.eoliaminecraftplugin.listeners;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.api.Economy;
import net.ess3.api.IUser;
import net.ess3.api.MaxMoneyException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.math.BigDecimal;

public class EssentialsEventsListener implements Listener {

    public static  Essentials ess;

    @EventHandler
    public void onHarvest (PlayerHarvestBlockEvent event) throws MaxMoneyException {
        //TODO: Add Essentials API to add money to a player with the farmer job
        ess = (Essentials) Essentials.getProvidingPlugin(Essentials.class);
        //TODO: Search the player group (job) to chose the function to launch and to give money to a farmer
        //Get Player in Essential format
        IUser player = ess.getUser(event.getPlayer());
        //Function to give money to a user
        player.giveMoney(new BigDecimal(0.02));
    }

    @EventHandler
    public void onBlockBreak (BlockBreakEvent event) throws MaxMoneyException {
        if (event.getPlayer() != null){
            ess = (Essentials) Essentials.getProvidingPlugin(Essentials.class);
            //TODO: Search the player group (job) to chose the function to launch and to give money as onHarvest event
            //Get Player in Essential format
            IUser player = ess.getUser(event.getPlayer());
            //Function to give money to a user
            player.giveMoney(new BigDecimal(0.01));
        }
    }
}
