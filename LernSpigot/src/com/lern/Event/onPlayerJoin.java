package com.lern.Event;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.lern.Main;
import com.lern.commands.HidePlayer;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class onPlayerJoin implements Listener{
	private Main plugin;
	
	public onPlayerJoin(Main plugin) {
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String msg = "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Welcome " + ChatColor.AQUA + 
				p.getName() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + " to TantaiHaha Server"; 
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg));
		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
		for(int i = 0; i < HidePlayer.invisible_list.size(); i++) {
			p.hidePlayer(plugin, HidePlayer.invisible_list.get(i));
			
		}
		
		
	}
}
