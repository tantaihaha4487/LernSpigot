package com.lern.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModeChange implements Listener, CommandExecutor{
	//command
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		        if(!(sender instanceof Player)) {
		            sender.sendMessage(ChatColor.RED  + "You aren't Player");
		        }
		        if(label.equalsIgnoreCase("modewand")) {
		            Player p = (Player) sender;
		            p.getInventory().addItem(ModeChange.createmodewand());
		            return true;       
		        }
		        return false;
		    }

	//Event
	  @EventHandler
	    public void onRightClick (PlayerInteractEvent event) {
		  if(event.getItem() == null) return;
		  Player p = event.getPlayer();
	        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	            if (event.getItem().getItemMeta().getDisplayName().equals("§5Chage Mode Stick")) {
	            	if(p.getGameMode() == GameMode.CREATIVE) {
	            		p.setGameMode(GameMode.SURVIVAL);
	            		p.sendMessage(ChatColor.GREEN + "Change to Survival");
	            	}
	            		else {
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage(ChatColor.GREEN + "Change to Creative");
						}
	            }
	        }
		  
	    }
	//item
	public static ItemStack createmodewand() {
	     ItemStack item = new ItemStack(Material.STICK);
         ItemMeta meta = item.getItemMeta();
 
         meta.setDisplayName("§5Chage Mode Stick");
         List<String> lore = new ArrayList<>();
         lore.add("§bRight Cick For Change Game Mode");
         lore.add("§bCreative => Survival");
         lore.add("§b Or");
         lore.add("§bSurvival => Creative");
         
         meta.setLore(lore);
         meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
         meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
         
         item.setItemMeta(meta);
         
         ItemStack modewand = (ItemStack) item;
		
		return modewand;
	}
}
