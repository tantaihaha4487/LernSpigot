package com.lern.Tab;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class LocatePlayerTab implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equals("locateplayer")) {
					if(args[0].length() == 0) {
						List<String> sub2 = new ArrayList<>();
						sub2.add("setbar");
						sub2.add("removebar");
						sub2.add("sendLocation");
						sub2.add("<PlayerName>");
						
						List<Player> PlayerList = (List<Player>) Bukkit.getServer().getOnlinePlayers();
						for(int i = 0; i < PlayerList.size(); i++) {
							String name = PlayerList.get(i).getName();
							sub2.add(name);
							
						}
						
						return sub2;
					}
			}
		return null;
	}
	

}
