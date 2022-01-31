package com.lern.gui;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

public class statasBossBar implements CommandExecutor{
	private Main Plugin;
	public static BossBar bar = Bukkit.createBossBar(ChatColor.AQUA + "Players: ", BarColor.GREEN, BarStyle.SOLID, BarFlag.DARKEN_SKY);
	
	public static void onLopp() {
		int online = Bukkit.getOnlinePlayers().size();
		bar.setTitle(ChatColor.AQUA + "Players: " + ChatColor.GOLD + online);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] argss) {
		Player p = (Player) sender;
		if(cmd.getName().equals("setbar")) {
			bar.addPlayer(p);
		}
		if(cmd.getName().equals("removebar")) {
			bar.removePlayer(p);
		}
			
		
		return true;
	}
	public static void onPlayerOnline(Main Plugin) {
		BukkitScheduler sh = Plugin.getServer().getScheduler();
		sh.scheduleSyncRepeatingTask(Plugin, new Runnable() {
			@Override
			public void run() {
				onLopp();
				 
			}
		}, 0, 5L);
	}

}
