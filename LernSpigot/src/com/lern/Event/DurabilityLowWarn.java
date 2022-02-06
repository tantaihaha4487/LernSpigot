package com.lern.Event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import com.lern.utils.LowDurabilityCheck;

public class DurabilityLowWarn implements Listener{
	@EventHandler
	public void onItemDmg(PlayerItemDamageEvent e) {
		Player p = e.getPlayer();
		//main hand
		Material slot = e.getItem().getType();
		if(e.getDamage() > 0) {
			if(p.getInventory().getItemInMainHand().getType() == slot) {
				LowDurabilityCheck.onCheckAxe(p);
				LowDurabilityCheck.onCheckHoe(p);
				LowDurabilityCheck.onCheckPickAxe(p);
				LowDurabilityCheck.onCheckShovel(p);
				LowDurabilityCheck.onCheckSword(p);
				
			}
			if(p.getInventory().getHelmet().getType() == slot) {
				LowDurabilityCheck.onCheckHead(p);
				
			}
				else {}
			if(p.getInventory().getChestplate().getType() == slot) {
				LowDurabilityCheck.onCheckBody(p);
				
			}
				else {}
			if(p.getInventory().getLeggings().getType() == slot) {
				LowDurabilityCheck.onChecLeg(p);
				
			}
			else {}
			if(p.getInventory().getBoots().getType() == slot) {
				LowDurabilityCheck.onCheckFoot(p);
				
				}
			else{}
		}
		
		/*
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability - 1;
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		sendMessage.sendActionBar(p, message);	
		*/
			
	}
}
