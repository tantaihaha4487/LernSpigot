package com.lern.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.lern.Main;

public class HidePlayer implements CommandExecutor{
	
	private Main plugiin;
	public static List<Player> invisible_list = new ArrayList<>();
	
	public HidePlayer(Main plugin) {
		this.plugiin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		List<Player> onlinePlayers = (List<Player>) Bukkit.getServer().getOnlinePlayers();
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You are't Player");
			 if (invisible_list.contains(p)){
	                for (Player people : Bukkit.getOnlinePlayers()){
	                    people.showPlayer(plugiin, p);
	                }
	                invisible_list.remove(p);
	                p.sendMessage("You are now visible to other players on the server.");
	            }else if(!invisible_list.contains(p)){
	                for (Player people : Bukkit.getOnlinePlayers()){
	                    people.hidePlayer(plugiin, p);
	                }
	                invisible_list.add(p);
	                p.sendMessage("You are now invisible!");
	            }
		}
		return true;
	}

}
