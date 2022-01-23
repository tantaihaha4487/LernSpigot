package com.lern;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.lern.Event.ItemFrameHide;
import com.lern.Event.OnPlayerJoin;
import com.lern.Items.ModeChange;
import com.lern.Tab.WcTab;
import com.lern.gui.WorldConfig;
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
		getServer().getPluginManager().registerEvents(new ModeChange(), this);
		getServer().getPluginManager().registerEvents(new WorldConfig(), this);
		
		getCommand("wc").setExecutor(new WorldConfig());
		getCommand("wc").setTabCompleter(new WcTab());
		getCommand("modewand").setExecutor((CommandExecutor) new ModeChange());
		new Coordinate().coordiante(this);
	}
}
