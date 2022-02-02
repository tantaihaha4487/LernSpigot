package com.lern;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.lern.Event.DurabilityLowWarn;
import com.lern.Event.GItemFramehide;
import com.lern.Event.ItemFrameHide;
import com.lern.Event.OnPlayerJoin;
import com.lern.Items.ModeChange;
import com.lern.Tab.WcTab;
import com.lern.Tab.statasTab;
import com.lern.commands.ReCommand;
import com.lern.gui.WorldConfig;
import com.lern.gui.statasBossBar;
import com.lern.more.Coordinate;
import com.lern.more.ItemListener;
import com.lern.more.NetherCoordinate;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		/*===============================================[Logger]===============================================*/
		getServer().getLogger().info(ChatColor.GREEN + "===============[Plugin]===============");
		getServer().getLogger().info(ChatColor.GREEN + "- Plugin: Lern Plugin Is Enable!");
		getServer().getLogger().info(ChatColor.GREEN + "- Version: " + Bukkit.getVersion());
		getServer().getLogger().info(ChatColor.GREEN + "- Max Player: " + Bukkit.getMaxPlayers());
		getServer().getLogger().info(ChatColor.GREEN + "- Max View Distance: " + Bukkit.getViewDistance());
		getServer().getLogger().info(ChatColor.GREEN + "======================================");
		/*===============================================[Event]===============================================*/
		getServer().getPluginManager().registerEvents(new ItemFrameHide(), this);
		getServer().getPluginManager().registerEvents(new GItemFramehide(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new ModeChange(), this);
		getServer().getPluginManager().registerEvents(new WorldConfig(), this);
		getServer().getPluginManager().registerEvents(new DurabilityLowWarn(), this);
		/*===============================================[TCMD]===============================================*/
		getCommand("wc").setExecutor(new WorldConfig());
		getCommand("wc").setTabCompleter(new WcTab());
		getCommand("modewand").setExecutor((CommandExecutor) new ModeChange());
		getCommand("r").setExecutor(new ReCommand());
		getCommand("t").setExecutor(new ReCommand());
		getCommand("setbar").setExecutor(new statasBossBar());
		getCommand("removebar").setExecutor(new statasBossBar());
		getCommand("setbar").setTabCompleter(new statasTab());

		/*===============================================[Mores]===============================================*/
		new Coordinate().coordiante(this);
		new NetherCoordinate().onLoop(this);
		new ItemListener(this);
		new statasBossBar();
		statasBossBar.onPlayerOnline(this);
		
		
	}
}
