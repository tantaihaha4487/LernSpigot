package com.lern;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getLogger().info(ChatColor.GREEN + "");
	}
}
