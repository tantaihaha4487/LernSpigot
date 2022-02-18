package com.lern;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.lern.Event.GItemFramehide;
import com.lern.Event.ItemFrameHide;
import com.lern.Event.onPlayerJoin;
import com.lern.Event.serverReload;
import com.lern.Items.ModeChange;
import com.lern.Tab.LocatePlayerTab;
import com.lern.Tab.WcTab;
import com.lern.commands.HidePlayer;
import com.lern.commands.LocatePlayer;
import com.lern.commands.ReCommand;
import com.lern.commands.testCommand;
import com.lern.gui.WorldConfig; 
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
		getServer().getPluginManager().registerEvents(new onPlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(new ModeChange(this), this);
		getServer().getPluginManager().registerEvents(new WorldConfig(), this);
		getServer().getPluginManager().registerEvents(new serverReload(), this);
		//getServer().getPluginManager().registerEvents(new DurabilityLowWarn(), this); //disable is bug
		
		/*===============================================[TCMD]===============================================*/
		getCommand("wc").setExecutor(new WorldConfig());
		getCommand("wc").setTabCompleter(new WcTab());
		getCommand("modewand").setExecutor((CommandExecutor) new ModeChange(this));
		getCommand("r").setExecutor(new ReCommand());
		getCommand("t").setExecutor(new  testCommand());
		getCommand("locateplayer").setExecutor(new LocatePlayer());
		getCommand("locateplayer").setTabCompleter(new LocatePlayerTab());
		//getCommand("hide").setExecutor(new HidePlayer(this)); bug
		/*===============================================[Mores]===============================================*/
		new Coordinate().coordiante(this);
		new NetherCoordinate().onLoop(this);
		new ItemListener(this);
		new LocatePlayer();
		LocatePlayer.onRun(this);
		/*===============================================[Logic]===============================================*/
		LocatePlayer.nameTask.put("target", null);
		
	}
}
