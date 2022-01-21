package com.lern.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.lern.Main;

public class ModeChange implements CommandExecutor{

	private void ModeChange(Main plugin) {
		plugin.getCommand("wand").setExecutor(plugin);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED  + "You aren't Player");
		}
		if(cmd.getName().equalsIgnoreCase("wand")) {
			Player p = (Player) sender;
			ItemStack item = new ItemStack(Material.STICK);
			ItemMeta meta = item.getItemMeta();
			
			meta.setDisplayName("§5§lChage Mode Stick");
			List<String> lore = new ArrayList<>();
			lore.add("§b§lRight Cick For Change Game Mode");
			lore.add("§b§lCreative => Survival");
			lore.add("§b§l Or");
			lore.add("§b§lSurvival => Creative");
			
			meta.setLore(lore);
			meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			
			item.setItemMeta(meta);
			
			ItemMeta modewand = (ItemMeta) item;
			p.getInventory().addItem(item);
			
		}
		return false;
	}
	

}
