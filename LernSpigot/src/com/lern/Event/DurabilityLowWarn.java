package com.lern.Event;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

import com.lern.utils.LowDurabilityCheck;
import com.lern.utils.sendMessage;

public class DurabilityLowWarn implements Listener{
	@EventHandler
	public void onBreak(PlayerItemDamageEvent e) {
		Player p = e.getPlayer();
		LowDurabilityCheck.onCheckAxe(p);
			
	} 

}
