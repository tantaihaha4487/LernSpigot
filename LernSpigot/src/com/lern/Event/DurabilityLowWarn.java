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
		LowDurabilityCheck.onCheckAxe(p);
		LowDurabilityCheck.onCheckHoe(p);
			
	}
}
