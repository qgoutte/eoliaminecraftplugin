package fr.kyristepiu.eoliaminecraftplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            ItemStack dirt = new ItemStack(Material.DIRT);
            dirt.setAmount(64);
            player.getInventory().addItem(dirt);
            player.sendMessage(ChatColor.YELLOW+ "Tiens de la dirt !");
            return true;
        }
        else {
            return false;
        }

    }
}
