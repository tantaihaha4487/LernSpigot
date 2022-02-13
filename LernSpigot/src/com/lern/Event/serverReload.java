package com.lern.Event;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import com.lern.commands.LocatePlayer;



public class serverReload implements Listener{
	private LocatePlayer lo;
	
	@EventHandler
	private void onReloadse(ServerLoadEvent e) {
		this.lo = lo;
		List<Player> onlinePlayers = (List<Player>) Bukkit.getServer().getOnlinePlayers();
		List<Player> AllPlayer = onlinePlayers;
		for(int i = 0; i < AllPlayer.size(); i++) {
			lo.bar.removePlayer(AllPlayer.get(i));
			
		}	
		

	}

}
