package com.lern.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LowDurabilityCheck {
	public static void onCheckAxe(Player p) {
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_AXE){
			
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_AXE){
			
		}
		
	}
}
