package com.lern.Tab;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class statasTab implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> argument = new ArrayList<>();
		argument.add("add");
		argument.add("remove");
		return argument;
	}
	

}
