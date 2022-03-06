package com.lern.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lern.Main;
import com.lern.utils.sendMessage;

import net.md_5.bungee.api.ChatColor;


public class ReCommand implements CommandExecutor{
	
	private Main plugin;
	
	public ReCommand(Main plugin) {
		this.plugin = plugin;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("r")) {
			plugin.getServer().reload();
			sender.sendMessage(ChatColor.GREEN + "Reload Complete!");
		}
		return true;
	}

}