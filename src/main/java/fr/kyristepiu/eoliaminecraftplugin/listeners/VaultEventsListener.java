package fr.kyristepiu.eoliaminecraftplugin.listeners;

import fr.kyristepiu.eoliaminecraftplugin.EoliaPlugin;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import java.util.logging.Logger;

public class VaultEventsListener implements Listener {

    private static final Logger log = Logger.getLogger("Minecraft");

    @EventHandler
    public void onHarvest (PlayerHarvestBlockEvent event) {
        Player player = event.getPlayer();
        //TODO : control if the player is farmer
        EconomyResponse economyResponse = EoliaPlugin.getEconomy().depositPlayer(player,0.02);
        if (!economyResponse.transactionSuccess()){
            log.info("An error occured :" + economyResponse.errorMessage);
        }
    }

    @EventHandler
    public void onBlockBreak (BlockBreakEvent event) {
        if (event.getPlayer() != null){
            Player player = event.getPlayer();
            //TODO: Search the player group (job) to chose the function to launch and to give money as onHarvest event

            EconomyResponse economyResponse = EoliaPlugin.getEconomy().depositPlayer(player, 0.01);
            if (!economyResponse.transactionSuccess()){
                log.info("An error occured :" + economyResponse.errorMessage);
            }
        }
    }
}
