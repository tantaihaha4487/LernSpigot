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
			sender.sendMessage(ChatColor.GOLD + "Waipackage com.lern.commands;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;

import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class ReCommand implements CommandExecutor{

	@Overridet..");	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("r")) {

			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "reload confirm");

			sender.sendMessage(ChatColor.GOLD + ChatColor.BOLD + "Reload Complete!");

		}

		return true;

	}

}
		}
		return true;
	}

}
