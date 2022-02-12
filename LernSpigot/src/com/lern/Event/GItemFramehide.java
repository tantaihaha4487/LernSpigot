package com.lern.Event;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class GItemFramehide implements Listener{
	@EventHandler
	public void OnCick(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		if(e.getRightClicked().getType() == EntityType.GLOW_ITEM_FRAME) {
			GlowItemFrame item = (GlowItemFrame) e.getRightClicked();
			String msg = "" + ChatColor.GOLD + ChatColor.BOLD + "(" +
					ChatColor.YELLOW + ChatColor.BOLD + "i" +
					ChatColor.GOLD + ChatColor.BOLD + ") " +
					ChatColor.GREEN + ChatColor.BOLD + "Set Item Frame to ";
			if(!p.isSneaking()) return;
			if(e.getRightClicked().getType().equals(EntityType.GLOW_ITEM_FRAME)) {
				if(item.isVisible() == true) {
					item.setVisible(false);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg + "Hide"));
				}
				else if (item.isVisible() == false) {
					item.setVisible(true);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg + "Show"));
					
				}
				
			}
		}
	}
}
