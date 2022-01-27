package com.lern.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;


public class ReCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("r")) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "reload confirm");
			sender.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Reload Complete!!");
		}
		return true;
	}

}