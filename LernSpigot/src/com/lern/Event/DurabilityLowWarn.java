package com.lern.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

import com.lern.utils.LowDurabilityCheck;

public class DurabilityLowWarn implements Listener{
	@EventHandler
	public void onItemDmg(PlayerItemDamageEvent e) {
		Player p = e.getPlayer();
		//main hand
		LowDurabilityCheck.onCheckAxe(p);
		LowDurabilityCheck.onCheckHoe(p);
		LowDurabilityCheck.onCheckPickAxe(p);
		LowDurabilityCheck.onCheckSword(p);
		LowDurabilityCheck.onCheckShovel(p);
		//body
		LowDurabilityCheck.onCheckHead(p);
		LowDurabilityCheck.onCheckBody(p);
		
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
