package com.lern.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import com.lern.Main;

import com.lern.Main;

public class WorldConfig implements CommandExecutor, Listener{
	public HashMap<String, Integer> CustomTimeTask = new HashMap<>();
	public HashMap<String, Integer> addTask = new HashMap<>();
	private Main Plugin;
	/*===============================================[Custom Time Options]===============================================*/
	//cussom time options
	@EventHandler
	public void onChatCustomTime(PlayerChatEvent e) {
		Player p = e.getPlayer();
		String Chat = e.getMessage();
		String msg =  ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] " + ChatColor.GREEN;
		if(!(addTask.get("run") == 1)) return;
		if(addTask.get("run") == 1) {
			try {
				int time = Integer.parseInt(Chat);
				CustomTimeTask.put("Task", time);
				p.getLocation().getWorld().setTime(time);
				p.sendMessage(msg + ChatColor.GREEN + "time set to " + ChatColor.LIGHT_PURPLE + "(" + time + ")");
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				addTask.replace("run", 0);
			} catch (Exception e2) {
				p.sendMessage(Chat + ChatColor.RED + ChatColor.BOLD.toString() + " aren't Integer!, Try again..");
				e.setCancelled(true);
				p.sendMessage(msg + ">>>Enter custom");
			}
		}
	}
	/*===============================================[Stick Cick Event]===============================================*/
	//Event
	@EventHandler
	public void OnRightCick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
        if(e.getItem() == null) return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            }
        if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "World Config Wand")) {
        	p.openInventory(worldconfig());
        	}
	}
	/*===============================================[Inventory Event]===============================================*/
	@EventHandler
	public void OncickInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Location loc = p.getLocation();
		String msg =  ChatColor.YELLOW + "[" + ChatColor.RED + "!" + ChatColor.YELLOW + "] " + ChatColor.GREEN;
		/*===============================================[Main Inventory Options]===============================================*/
		if(e.getView().getTitle().equals("World Config")) {
			e.setCancelled(true);
			switch(e.getCurrentItem().getType()) {
			case CLOCK:
				p.openInventory(timeinv());
				p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
				break;
			case LIGHTNING_ROD:
				p.openInventory(weatherinv());
				p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
				break;
			case BARRIER:
				p.closeInventory();
				p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
				break;
			}
		}
		/*===============================================[Weather Inventory Options]===============================================*/
		if(e.getView().getTitle().equals(ChatColor.BLUE + "Weather")) {
			e.setCancelled(true);
			switch (e.getCurrentItem().getType()) {
			case BARRIER:
				p.openInventory(worldconfig());
				p.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
				break;
			case WHITE_STAINED_GLASS_PANE:
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "weather clear");
				p.sendMessage(msg + "Set weather to Clear");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				p.closeInventory();
				break;
			case BLUE_STAINED_GLASS_PANE:
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "weather rain");
				p.sendMessage(msg + "Set weather to Rain");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				p.closeInventory();
				break;
			case BROWN_STAINED_GLASS_PANE:
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "weather thunder");
				p.sendMessage(msg + "Set weather to Thunder");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				p.closeInventory();
				break;
				}
			}
		/*===============================================[Time Inventory Options]===============================================*/
		if(e.getView().getTitle().equals(ChatColor.YELLOW + "Time")) {
			e.setCancelled(true);
			switch(e.getCurrentItem().getType()) {
			case ORANGE_STAINED_GLASS_PANE:
				p.getLocation().getWorld().setTime(24000);
				p.closeInventory();
				p.sendMessage(msg + ChatColor.GREEN + "time set sunrise");
				p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				break;
			case YELLOW_STAINED_GLASS_PANE:
				p.getLocation().getWorld().setTime(1000);
				p.closeInventory();
				p.sendMessage(msg + ChatColor.GREEN + "time set day");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				break;
			case BLUE_STAINED_GLASS_PANE:
				p.getLocation().getWorld().setTime(6000);
				p.closeInventory();
				p.sendMessage(msg + ChatColor.GREEN + "time set noon");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				break;
			case BROWN_STAINED_GLASS_PANE:
				p.getLocation().getWorld().setTime(12500);
				p.closeInventory();
				p.sendMessage(msg + ChatColor.GREEN + "time set twilight");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				break;
			case BLACK_STAINED_GLASS_PANE:
				p.getLocation().getWorld().setTime(18000);
				p.closeInventory();
				p.sendMessage(msg + ChatColor.GREEN + "time set midnight");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
				break;
			case LIME_CONCRETE:
				p.closeInventory();
				p.sendMessage(msg + ">>>Enter custom");
				addTask.put("run", 1);
				break;
			case BARRIER:
				p.openInventory(worldconfig());
				p.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
				break;
			}
		}
	}
	
	/*===============================================[Main Inventory]===============================================*/
	private static Inventory worldconfig() {
		Inventory inv = Bukkit.createInventory(null, 9, "World Config");
		//clock  time inv
		ItemStack clock = new ItemStack(Material.CLOCK);
		ItemMeta clocksmeta = clock.getItemMeta();
		clocksmeta.setDisplayName(ChatColor.GREEN + "Time");
		List<String> loreclock = new ArrayList<>();
		loreclock.add(ChatColor.LIGHT_PURPLE + "Set time in your world");
		clocksmeta.setLore(loreclock);
		clock.setItemMeta(clocksmeta);
		//weather weatherinv
		ItemStack light = new ItemStack(Material.LIGHTNING_ROD);
		ItemMeta lightmeta = light.getItemMeta();
		lightmeta.setDisplayName(ChatColor.BLUE + "WeaTher");
		List<String> loreweather = new ArrayList<>();
		loreweather.add(ChatColor.LIGHT_PURPLE + "Set Weather in your world");
		lightmeta.setLore(loreweather);
		light.setItemMeta(lightmeta);
		//back
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("" +ChatColor.RED + ChatColor.BOLD + "X Exit");
		List<String> loreback = new ArrayList<>();
		loreback.add(ChatColor.LIGHT_PURPLE + "Back to Game");
		backmeta.setLore(loreback);
		backmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		backmeta.addEnchant(Enchantment.LUCK, 1, false);
		backmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		back.setItemMeta(backmeta);
		
		inv.setItem(2, light);
		inv.setItem(4, clock);
		inv.setItem(8, back);
		return inv;
	}
	/*===============================================[Time Inventory]===============================================*/
	private static Inventory timeinv() {
		Inventory time = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Time");
		//sunrise
		ItemStack sun = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
		ItemMeta sunmeta = sun.getItemMeta();
		sunmeta.setDisplayName(ChatColor.GOLD + "Sunrise");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.LIGHT_PURPLE + "Set time to Sunrise (0)");
		sunmeta.setLore(lore);
		sunmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		sun.setItemMeta(sunmeta);
		//day
		ItemStack dayitem = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
		ItemMeta daymeata = dayitem.getItemMeta();
		daymeata.setDisplayName(ChatColor.YELLOW + "Day");
		List<String> lored = new ArrayList<>();
		lored.add(ChatColor.LIGHT_PURPLE + "Set time to Day (1000)");
		daymeata.setLore(lored);
		daymeata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		dayitem.setItemMeta(daymeata);
		//noon
		ItemStack noon = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
		ItemMeta noonmeta = noon.getItemMeta();
		noonmeta.setDisplayName(ChatColor.AQUA + "Noon");
		List<String> loren = new ArrayList<>();
		loren.add(ChatColor.LIGHT_PURPLE + "Set time to Noon (6000)");
		noonmeta.setLore(loren);
		noonmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		noon.setItemMeta(noonmeta);
		//twilight
		ItemStack twilight = new ItemStack(Material.BROWN_STAINED_GLASS_PANE);
		ItemMeta twilightmeta = twilight.getItemMeta();
		twilightmeta.setDisplayName(ChatColor.DARK_GRAY + "Twilight");
		List<String> loretwi = new ArrayList<>();
		loretwi.add(ChatColor.LIGHT_PURPLE + "Set time to twilight (12500)");
		twilightmeta.setLore(loretwi);
		twilight.setItemMeta(twilightmeta);
		//midNight
		ItemStack midnight = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta midnightmeta = midnight.getItemMeta();
		midnightmeta.setDisplayName("MidNight");
		List<String> loreni = new ArrayList<>();
		loreni.add(ChatColor.LIGHT_PURPLE + "Set time to midnight (18000)");
		midnightmeta.setLore(loreni);
		midnightmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		midnight.setItemMeta(midnightmeta);
		//custom
		ItemStack custom = new ItemStack(Material.LIME_CONCRETE);
		ItemMeta custommeta = custom.getItemMeta();
		custommeta.setDisplayName(ChatColor.GREEN + "Custom");
		List<String> lorecustom= new ArrayList<>();
		lorecustom.add(ChatColor.LIGHT_PURPLE + "Set time to (?)");
		custommeta.setLore(lorecustom);
		custommeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		custom.setItemMeta(custommeta);
		//back
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("" +ChatColor.RED + ChatColor.BOLD + "< Back");
		List<String> loreback = new ArrayList<>();
		loreback.add(ChatColor.LIGHT_PURPLE + "Back to World Config");
		backmeta.setLore(loreback);
		backmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		backmeta.addEnchant(Enchantment.LUCK, 1, false);
		backmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		back.setItemMeta(backmeta);
		
		time.setItem(1, sun);
		time.setItem(2, dayitem);
		time.setItem(3, noon);
		time.setItem(4, twilight);
		time.setItem(5, midnight);
		time.setItem(6, custom);
		time.setItem(8, back);
		
		return time;
	}
	/*===============================================[Weather Inventory]===============================================*/
	private static Inventory weatherinv() {
		Inventory weather = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Weather");
		//back
		ItemStack back = new ItemStack(Material.BARRIER);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("" +ChatColor.RED + ChatColor.BOLD + "< Back");
		List<String> loreback = new ArrayList<>();
		loreback.add(ChatColor.LIGHT_PURPLE + "Back to World Config");
		backmeta.setLore(loreback);
		backmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		backmeta.addEnchant(Enchantment.LUCK, 1, false);
		backmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		back.setItemMeta(backmeta);
		//Clear
		ItemStack clear = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
		ItemMeta clearMeta = clear.getItemMeta();
		clearMeta.setDisplayName(ChatColor.WHITE + "Clear");
		List<String> loreclear = new ArrayList<>();
		loreclear.add(ChatColor.LIGHT_PURPLE + "Set weather to Clear");
		clearMeta.setLore(loreclear);
		clear.setItemMeta(clearMeta);
		//rain
		ItemStack rain = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
		ItemMeta rainMeta = rain.getItemMeta();
		rainMeta.setDisplayName(ChatColor.DARK_AQUA + "Rain");
		List<String> lorerain = new ArrayList<>();
		lorerain.add(ChatColor.LIGHT_PURPLE + "Set weather to Rain");
		rainMeta.setLore(lorerain);
		rain.setItemMeta(rainMeta);
		//storm
		ItemStack storm = new ItemStack(Material.BROWN_STAINED_GLASS_PANE);
		ItemMeta stromMeta = storm.getItemMeta();
		stromMeta.setDisplayName(ChatColor.BLUE + "Thunder");
		List<String> lorestrom = new ArrayList<>();
		lorestrom.add(ChatColor.LIGHT_PURPLE + "Set weather to Thunder");
		stromMeta.setLore(lorestrom);
		storm.setItemMeta(stromMeta);
 		
		weather.setItem(1, clear);
		weather.setItem(3, rain);
		weather.setItem(5, storm);
		weather.setItem(8, back);
		return weather;
	}
	
	/*===============================================[Give Wand Commands]===============================================*/
	//command
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String ladel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("wc")) {
			if(args.length == 0) {
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
