package com.lern.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class WorldConfig implements CommandExecutor, Listener{
	//Event
	@EventHandler
	public void OncickInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getView().getTitle().equals("World Config")) {
			e.setCancelled(true);
		}
	}
	
	//inventory
	private static Inventory worldconfig() {
		Inventory inv = Bukkit.createInventory(null, 9, "World Config");
		
		ItemStack clock = new ItemStack(Material.CLOCK);
		ItemMeta clocksmeta = clock.getItemMeta();
		clocksmeta.setDisplayName(ChatColor.GREEN + "Time");
		clock.setItemMeta(clocksmeta);
		
		ItemStack grass = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta grassmeta = grass.getItemMeta();
		grassmeta.setDisplayName(ChatColor.GREEN + "");
		grass.setItemMeta(grassmeta);
		
		inv.setItem(2, clock);
		inv.setItem(4, grass);
		
		return inv;
	}
	//command
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String ladel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wc")) {
			Player p = (Player) sender;
			p.openInventory(worldconfig());
		}
		return true;
	}
	
	
}
