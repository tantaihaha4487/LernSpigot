package com.lern.utils;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class sendMessage{
	
	public static void sendActionBar(Player player, String text) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
		
	}

}
