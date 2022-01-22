package com.lern;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.lern.Event.ItemFrameHide;
import com.lern.Event.OnPlayerJoin;
import com.lern.Items.ModeChange;
import com.lern.more.Coordinate;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getLogger().info(ChatColor.GREEN + "===============[Plugin]===============");
		getServer().getLogger().info(ChatColor.GREEN + "- Lern Plugin Is Enable!");
		getServer().getLogger().info(ChatColor.GREEN + "- Version: " + Bukkit.getVersion());
		getServer().getLogger().info(ChatColor.GREEN + "======================================");
		getServer().getPluginManager().registerEvents(new ItemFrameHide(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
		
		getCommand("wand").setExecutor(new ModeChange());
		new Coordinate().coordiante(this);
	}
}
