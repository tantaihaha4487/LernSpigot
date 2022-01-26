package com.lern.more;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.lern.Main;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Coordinate{
	private Main Plugin;
    public static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 180.0f) % 360.0f;
        if (rotation < 0.0) {
            rotation += 360.0;
        }
        if (0.0 <= rotation && rotation < 22.5) {
            return "North";
        }
        if (22.5 <= rotation && rotation < 67.5) {
            return "NorthEast";
        }
        if (67.5 <= rotation && rotation < 112.5) {
            return "East";
        }
        if (112.5 <= rotation && rotation < 157.5) {
            return "SouthEast";
        }
        if (157.5 <= rotation && rotation < 202.5) {
            return "South";
        }
        if (202.5 <= rotation && rotation < 247.5) {
            return "SouthWest";
        }
        if (247.5 <= rotation && rotation < 292.5) {
            return "West";
        }
        if (292.5 <= rotation && rotation < 337.5) {
            return "NorthWeSst";
        }
        if (337.5 <= rotation && rotation < 360.0) {
            return "North";
        }
        return null;
    }
    public void coordiante(Main Plugin) {
    	this.Plugin = Plugin;
    	BukkitScheduler scheduler = Plugin.getServer().getScheduler();
    	scheduler.scheduleSyncRepeatingTask(Plugin, new Runnable() {
			
			@Override
			public void run() {
				 Player[] players = Plugin.getServer().getOnlinePlayers().toArray(new Player[0]);
	                for (Player p : players) {	
	                	int x = p.getLocation().getBlockX();
	  	              	int y = p.getLocation().getBlockY();
	  	              	int z = p.getLocation().getBlockZ();
	  	              	String di = "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "[" +
	  	              			ChatColor.AQUA + ChatColor.BOLD + getCardinalDirection(p)+
	  	            		   ChatColor.DARK_PURPLE + ChatColor.BOLD + "] ";
	  	              	String posX = "" + ChatColor.BOLD + ChatColor.GOLD + "X: " + ChatColor.BOLD + x + " ";
	  	              	String posY = "" + ChatColor.BOLD + ChatColor.GOLD + "Y: " + ChatColor.BOLD + y + " ";
	  	              	String posZ = "" + ChatColor.BOLD + ChatColor.GOLD + "Z: " + ChatColor.BOLD + z + " ";
	  	              	
	  	              	int netherX = x / 8;
	  	              	int netherY = y / 8;
	  	              	int netherZ = z / 8;
	  	              
	  	              	if (p.getInventory().getItemInMainHand().getType().equals(Material.COMPASS) || 
	  	            		  p.getInventory().getItemInOffHand().getType().equals(Material.COMPASS)) {
	  	            	  p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(di + posX + posY + posZ));
	  	              }
	                }
			}
		}, 0, 5L);
    }
}
