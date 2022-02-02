package com.lern.utils;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LowDurabilityCheck {
	public static void onCheckAxe(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_AXE){
			if(now < 10 ) {
				sendMessage.sendActionBar(p, "Now Durability is " + now);	
			}
			if(now == 1) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0, 0);
				
			}
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_AXE){
			if(now < 10) {
				sendMessage.sendActionBar(p, "Now Durability is " + now);
			}
			if(now == 1) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0, 0);
				
			}
		}
		//GOLDEN
		if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE){
			if(now < 10) {
				sendMessage.sendActionBar(p, "Now Durability is " + now);
			}
			if(now == 1) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0, 0);
				
			}
		}
		//IRON
		if(p.getInventory().getItemInMainHand().getType() == Material.IRON_AXE){
			if(now < 10) {
				sendMessage.sendActionBar(p, "Now Durability is " + now);
			}
			if(now == 1) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0, 0);
				
			}
		}
		//DIAMOND
		if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE){
			if(now < 10) {
				sendMessage.sendActionBar(p, "Now Durability is " + now);
			}
			if(now == 1) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0, 0);
				
			}
		}
		//NETHERRITE
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_AXE){
			if(now < 10) {
				sendMessage.sendActionBar(p, "Now Durability is " + now);
			}
			if(now == 1) {
				p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
				
			}
		}
	}
}
