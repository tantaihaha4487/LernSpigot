package com.lern.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocatePlayer implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		BossBar bar = Bukkit.createBossBar("--", BarColor.WHITE, BarStyle.SOLID, BarFlag.DARKEN_SKY);
		
		if(cmd.getName().equalsIgnoreCase("locateplayer")) {
				if(args[0].equalsIgnoreCase("setbar")) {
					bar.addPlayer(p);
					
				}
				if(args[0].equalsIgnoreCase("removebar")) {
					bar.removePlayer(p);
					
				}
				if(args[0].equals("sendLocation")) {
					int px = p.getLocation().getBlockX();
					int py = p.getLocation().getBlockY();
					int pz = p.getLocation().getBlockZ();
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);
					
					List<Player> onlinePlayers = (List<Player>) Bukkit.getServer().getOnlinePlayers();
					List<Player> AllPlayer = onlinePlayers;
					for(int i = 0; i < AllPlayer.size(); i++) {
						String name = AllPlayer.get(i).getName();
						Player target = Bukkit.getPlayer(name);
						target.sendMessage(ChatColor.AQUA + p.getName() + ChatColor.GOLD + " [" + EnviName(p) + "] " + ChatColor.GREEN
						+ "X: " + px + " Y: " + py + " Z: " + pz );
						
					}
					
				}
		}
		return true;
	}
	private static String EnviName(Player p) {
		String world = null;
		switch(p.getWorld().getEnvironment()) {
		case NORMAL:
			world = "Normal";
			break;
		case NETHER:
			world = "Nether";
			break;
		case THE_END:
			world = "The End";
			break;
		
		}
		return world;
	}
}
