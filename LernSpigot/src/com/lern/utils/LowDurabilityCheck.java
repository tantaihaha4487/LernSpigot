package com.lern.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LowDurabilityCheck {
	private static void onNearBreak(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		String breakMsg = ChatColor.YELLOW .toString() + ChatColor.BOLD +  "[" + "WARN" + "] " + 
				 ChatColor.RED + ChatColor.BOLD +"Your Item Near Break";
		p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		sendMessage.sendActionBar(p, breakMsg);
	}
	
	public static void onCheckAxe(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_AXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_AXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//GOLDEN
		if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//IRON
		if(p.getInventory().getItemInMainHand().getType() == Material.IRON_AXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2) {
				onNearBreak(p);
			}
		}
		//DIAMOND
		if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//NETHERRITE
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_AXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
	}
	public static void onCheckHoe(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_HOE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_HOE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//GOLDEN
		if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//IRON
		if(p.getInventory().getItemInMainHand().getType() == Material.IRON_HOE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//DIAMOND
		if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HOE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//NETHERRITE
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_HOE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
	}
}
