package com.lern.Tab;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class WcTab implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wc")) {
			if(args.length > 0) {
				List<String> arguments = new ArrayList<>();
				arguments.add("wand");
				return arguments;
			}
			
		}
		return null;
	}

}
