package com.lern.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LowDurabilityCheck {
	/*===============================================[Variable]===============================================*/
	private static void onNearBreak(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		String breakMsg = ChatColor.YELLOW .toString() + ChatColor.BOLD +  "[" + "WARN" + "] " + 
				 ChatColor.RED + ChatColor.BOLD +"Your Item Near Break";
		p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		sendMessage.sendActionBar(p, breakMsg);
	}
	private static void onNearBreakHead(Player p) {
		int max = p.getInventory().getHelmet().getType().getMaxDurability();
		int durability = p.getInventory().getHelmet().getDurability();
		int now = max - durability- 1;
		String breakMsg = ChatColor.YELLOW .toString() + ChatColor.BOLD +  "[" + "WARN" + "] " + 
				 ChatColor.RED + ChatColor.BOLD +"Your Item Near Break";
		p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		sendMessage.sendActionBar(p, breakMsg);
	}
	private static void onNearBreakBody(Player p) {
		int max = p.getInventory().getChestplate().getType().getMaxDurability();
		int durability = p.getInventory().getChestplate().getDurability();
		int now = max - durability- 1;
		String breakMsg = ChatColor.YELLOW .toString() + ChatColor.BOLD +  "[" + "WARN" + "] " + 
				 ChatColor.RED + ChatColor.BOLD +"Your Item Near Break";
		p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		sendMessage.sendActionBar(p, breakMsg);
	}
	private static void onNearBreakLeg(Player p) {
		int max = p.getInventory().getLeggings().getType().getMaxDurability();
		int durability = p.getInventory().getLeggings().getDurability();
		int now = max - durability- 1;
		String breakMsg = ChatColor.YELLOW .toString() + ChatColor.BOLD +  "[" + "WARN" + "] " + 
				 ChatColor.RED + ChatColor.BOLD +"Your Item Near Break";
		p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		sendMessage.sendActionBar(p, breakMsg);
	}
	private static void onNearBreakFoot(Player p) {
		int max = p.getInventory().getBoots().getType().getMaxDurability();
		int durability = p.getInventory().getBoots().getDurability();
		int now = max - durability- 1;
		String breakMsg = ChatColor.YELLOW .toString() + ChatColor.BOLD +  "[" + "WARN" + "] " + 
				 ChatColor.RED + ChatColor.BOLD +"Your Item Near Break";
		p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
		sendMessage.sendActionBar(p, breakMsg);
	}
	/*===============================================[Axe Check]===============================================*/
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
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Hoe Check]===============================================*/
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
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[PickAxe Check]===============================================*/
	public static void onCheckPickAxe(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_PICKAXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_PICKAXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//GOLDEN
		if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_PICKAXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//IRON
		if(p.getInventory().getItemInMainHand().getType() == Material.IRON_PICKAXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//DIAMOND
		if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//NETHERRITE
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_PICKAXE){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Shovel Check]===============================================*/
	public static void onCheckShovel(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_SHOVEL){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_SHOVEL){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//GOLDEN
		if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SHOVEL){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//IRON
		if(p.getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//DIAMOND
		if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//NETHERRITE
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SHOVEL){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Hoe Check]===============================================*/
	public static void onCheckSword(Player p) {
		int max = p.getInventory().getItemInHand().getType().getMaxDurability();
		int durability = p.getItemInHand().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//WOODEN
		if(p.getInventory().getItemInMainHand().getType() == Material.WOODEN_SWORD){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//STONE
		if(p.getInventory().getItemInMainHand().getType() == Material.STONE_SWORD){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//GOLDEN
		if(p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//IRON
		if(p.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//DIAMOND
		if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		//NETHERRITE
		if(p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_SWORD){
			if(now < 10 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreak(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Head Check]===============================================*/
	public static void onCheckHead(Player p) {
		int max = p.getInventory().getHelmet().getType().getMaxDurability();
		int durability = p.getInventory().getHelmet().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//Turrle
		if(p.getInventory().getHelmet().getType() == Material.TURTLE_HELMET){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreakHead(p);
			}
		}
		//Chain
		if(p.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakHead(p);
			}
		}
		//Itron
		if(p.getInventory().getHelmet().getType() == Material.IRON_HELMET){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakHead(p);
			}
		}
		//Diamond
		if(p.getInventory().getHelmet().getType() == Material.DIAMOND_HELMET){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakHead(p);
			}
		}
		//Netherite
		if(p.getInventory().getHelmet().getType() == Material.NETHERITE_HELMET){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakHead(p);
			}
		}
		//Golden
		if(p.getInventory().getHelmet().getType() == Material.GOLDEN_HELMET){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakHead(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Head Check]===============================================*/
	public static void onCheckBody(Player p) {
		int max = p.getInventory().getChestplate().getType().getMaxDurability();
		int durability = p.getInventory().getChestplate().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//Elytra
		if(p.getInventory().getChestplate().getType() == Material.ELYTRA){
			if(now < 20 && now != 0) {
				sendMessage.sendActionBar(p, message);	
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Chain
		if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Iron
		if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Diamond
		if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Netherite
		if(p.getInventory().getChestplate().getType() == Material.NETHERITE_CHESTPLATE){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Golden
		if(p.getInventory().getChestplate().getType() == Material.GOLDEN_CHESTPLATE){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Leg Check]===============================================*/
	public static void onChecLeg(Player p) {
		int max = p.getInventory().getLeggings().getType().getMaxDurability();
		int durability = p.getInventory().getLeggings().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//Chain
		if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_LEGGINGS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakLeg(p);
			}
		}
		//Iron
		if(p.getInventory().getChestplate().getType() == Material.IRON_LEGGINGS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakLeg(p);
			}
		}
		//Diamond
		if(p.getInventory().getChestplate().getType() == Material.DIAMOND_LEGGINGS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakLeg(p);
			}
		}
		//Netherite
		if(p.getInventory().getChestplate().getType() == Material.NETHERITE_LEGGINGS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakLeg(p);
			}
		}
		//Golden
		if(p.getInventory().getChestplate().getType() == Material.GOLDEN_LEGGINGS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakLeg(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
	/*===============================================[Head Check]===============================================*/
	public static void onCheckFoot(Player p) {
		int max = p.getInventory().getBoots().getType().getMaxDurability();
		int durability = p.getInventory().getBoots().getDurability();
		int now = max - durability- 1;
		
		String message = ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] "
				+ ChatColor.AQUA + "Your Durability is Low " +
				ChatColor.LIGHT_PURPLE + "(" + now +")" ;
		
		//Chain
		if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_BOOTS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Iron
		if(p.getInventory().getChestplate().getType() == Material.IRON_BOOTS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Diamond
		if(p.getInventory().getChestplate().getType() == Material.DIAMOND_BOOTS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Netherite
		if(p.getInventory().getChestplate().getType() == Material.NETHERITE_BOOTS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		//Golden
		if(p.getInventory().getChestplate().getType() == Material.GOLDEN_BOOTS){
			if(now < 15 && now != 0) {
				sendMessage.sendActionBar(p, message);
			}
			if(now < 2 && now != 0) {
				onNearBreakBody(p);
			}
		}
		if(now == 0) {
			sendMessage.sendActionBar(p, ChatColor.RED.toString() + ChatColor.BOLD +"Item Break!");
		}
	}
}
