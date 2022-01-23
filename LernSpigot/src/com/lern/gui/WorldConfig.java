package com.lern.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WorldConfig implements CommandExecutor, Listener{
	//Event
	@EventHandler
	public void OnRightCick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
        if(e.getItem() == null) return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "World Config Wand")) {
            	p.openInventory(worldconfig());
            	}
            }
	}
	
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
		
		inv.setItem(4, clock);
		
		return inv;
	}
	//command
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String ladel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wc")) {
			if(args.length == 0l) {
				Player p = (Player) sender;
				p.openInventory(worldconfig());
			}
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("wand")) {
					Player p = (Player) sender;
					ItemStack stick = new ItemStack(Material.STICK);
					ItemMeta stickmeta = stick.getItemMeta();
					stickmeta.setDisplayName(ChatColor.AQUA + "World Config Wand");
					
					List<String> lore = new ArrayList<>();
					lore.add(ChatColor.LIGHT_PURPLE + "Right Cick For Open World Config GUI");
					stickmeta.setLore(lore);
					stickmeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false);
			        stickmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			         
					stick.setItemMeta(stickmeta);
					
					p.getInventory().addItem(stick);
				}
			}
		}
		return true;
	}
	
	
}
