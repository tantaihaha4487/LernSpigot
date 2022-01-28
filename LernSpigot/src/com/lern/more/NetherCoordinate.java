package com.lern.more;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.lern.Main;
import com.lern.utils.sendMessage;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class NetherCoordinate {
	private Main Plugin;
	public void onLoop(Main plugin) {
		this.Plugin = plugin;
		BukkitScheduler sh = Bukkit.getScheduler();
		sh.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
				for(Player p : players) {
			    	int x = p.getLocation().getBlockX();
  	              	int y = p.getLocation().getBlockY();
  	              	int z = p.getLocation().getBlockZ();
  	              	
  	              	int netherX = x / 8;
  	              	int netherY = y / 8;
  	              	int netherZ = z / 8;

  	              	String Emoji = ChatColor.DARK_PURPLE + "> ";
  	              	
  	            	if (p.getInventory().getItemInMainHand().getType().equals(Material.OBSIDIAN) || 
	  	            		  p.getInventory().getItemInOffHand().getType().equals(Material.OBSIDIAN)) {
  	            		if(p.getWorld().getEnvironment()== Environment.NORMAL) {
  	            			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "Over World " + ChatColor.GOLD +
  	  	            			  ChatColor.BOLD+  "X: " + x + " Z: " + z + " " + Emoji + ChatColor.GREEN + "Nether " +  
  	  	            			  ChatColor.GOLD + ChatColor.BOLD + "X: " + netherX + " Z:" + netherZ));
  	            			
  	            		}
  	            		if(p.getWorld().getEnvironment() == Environment.NETHER) {
  	            			sendMessage.sendActionBar(p,  ChatColor.GREEN + "Nether " +  
    	  	            			  ChatColor.GOLD + ChatColor.BOLD + "X: " + netherX + " Z: " + netherZ + " " + Emoji +
    	  	            			  ChatColor.GREEN + "Over World " + ChatColor.GOLD + ChatColor.BOLD+  "X: " + x + " Z: " + z );
  	            		}
  	            		if(p.getWorld().getEnvironment() == Environment.THE_END) {
  	            			sendMessage.sendActionBar(p, ChatColor.RED + "Can't use in The End!");
  	            		}
	            	}
					
				}
				
				
				
			}
		}, 0, 5L);
	}
}
