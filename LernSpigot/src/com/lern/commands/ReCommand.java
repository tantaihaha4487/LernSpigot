package com.lern.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lern.utils.sendMessage;

import net.md_5.bungee.api.ChatColor;


public class ReCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("r")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "reload confirm");
			sender.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Reload Complete!!");
			
		}
		if(cmd.getName().equals("t")) {
			p.sendMessage("Test => " + p.getUniqueId());
			
		}
		return true;
	}

}