package com.lern.commands;

import java.util.HashMap;
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
import org.bukkit.scheduler.BukkitScheduler;

import com.lern.Main;


public class LocatePlayer implements CommandExecutor{
	private static BossBar bar = Bukkit.createBossBar("Locate Player", BarColor.WHITE, BarStyle.SOLID, BarFlag.DARKEN_SKY);
	private static HashMap<String, Integer> LoopTask = new HashMap<>(); //0 disable || 1 Enable
	private static HashMap<String, Player> nameTask = new HashMap<>(); 
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		int px = p.getLocation().getBlockX();
		int py = p.getLocation().getBlockY();
		int pz = p.getLocation().getBlockZ();
		LoopTask.put("Run", 0);
		
		
		if(cmd.getName().equalsIgnoreCase("locateplayer")) {
			if(args.length == 0) {
				sendAllPlayer(p, px, py, pz);
				
			}
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("addbar")) {
					try {
						String target = args[1];
						Player t = Bukkit.getPlayer(target);
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);
						bar.addPlayer(p);
						LoopTask.replace("Run", 1);
						nameTask.put("target", t);
					} catch (Exception e) {
						p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Error! Try /locateplayer addbar <PlayerName>");
					}
					
				}
				if(args[0].equalsIgnoreCase("removebar")) {
					bar.removePlayer(p);
					LoopTask.replace("Run", 0);
					nameTask.remove("target");
				}	
			}
		}
		return true;
	}
	public static void onRun(Main plugin) {
		BukkitScheduler sh = plugin.getServer().getScheduler();
			sh.scheduleSyncRepeatingTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					if(LoopTask.get("Run") == 1) {
						Player tName = nameTask.get("target");
						if(LoopTask.get("Run") == 1) {
							onLoop();
					}
				}
			}
		}, 0, 5L);
	}
	
	private static void onLoop() {
		Player target = nameTask.get("target");
		int tx = target.getLocation().getBlockX();
		int ty = target.getLocation().getBlockY();
		int tz = target.getLocation().getBlockZ();
		
		String targetName = target.getName(); 
		
		bar.setTitle(ChatColor.AQUA + targetName + " " + ChatColor.GREEN + EnviName(target) + ChatColor.GOLD + " X: " + tx + " Y: " + " Z: " + tz);
		
		
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
	private static void sendAllPlayer(Player p, int px, int py, int pz) {
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
