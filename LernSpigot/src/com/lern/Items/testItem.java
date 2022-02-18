package com.lern.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class testItem {

	public static ItemStack test() {
		
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner("TantaiHaha");
		
		item.setItemMeta(meta);
		
		return item;
		
	} 
	
}
