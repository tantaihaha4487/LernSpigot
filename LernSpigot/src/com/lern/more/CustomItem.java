package com.lern.more;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.lern.utils.sendMessage;

public class CustomItem {
	private ItemListener itemclass;
	   private Player player;
	   private ItemStack data;
	   private int slot;

	   public CustomItem(ItemListener itemclass, Player player, ItemStack data, int slot) {
	      this.itemclass = itemclass;
	      this.player = player;
	      this.data = data.clone();
	      this.slot = slot;
	   }

	   public void Check(ItemStack newdata) {
	      if (this.slot == this.player.getInventory().getHeldItemSlot() && newdata.getType().equals(Material.AIR)) {
	         switch(this.data.getType()) {
	         case FIREWORK_ROCKET:
	         case EGG:
	         case ENDER_PEARL:
	         case ENDER_EYE:
	         case EXPERIENCE_BOTTLE:
	         case MINECART:
	         case TNT_MINECART:
	         case CHEST_MINECART:
	         case HOPPER_MINECART:
	         case FURNACE_MINECART:
	         case ITEM_FRAME:
	         case LILY_PAD:
	         case VINE:
	            this.itemclass.setItem(this.player, this.slot, this.data, true, false);
	            break;
	         default:
	            if (this.data.getType().toString().endsWith("_BOAT")) {
	               this.endWith(this.player, this.slot, "_BOAT", true);
	            }
	         }
	      }

	   }

	   private void endWith(Player p, int slot, String a, boolean inhand) {
	      boolean nu = false;

	      int i;
	      ItemStack slotitem;
	      for(i = 9; i < 36; ++i) {
	         if (i != slot) {
	            slotitem = p.getInventory().getItem(i);
	            if (slotitem != null) {
	               if ((new ItemStack(slotitem.getType(), slotitem.getAmount())).equals(slotitem) && slotitem.getType().toString().endsWith(a)) {
	                  if (inhand) {
	                     p.getInventory().setItemInMainHand(slotitem);
	                  } else {
	                     p.getInventory().setItemInOffHand(slotitem);
	                  }

	                  p.getInventory().setItem(i, new ItemStack(Material.AIR));
	                  sendMessage.sendActionBar(p, ChatColor.YELLOW + ChatColor.BOLD.toString() + "(i) " + ChatColor.GOLD + ChatColor.BOLD + "Auto item in action");
	                  p.playSound(p.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 100.0F, 1.0F);
	                  break;
	               }
	            } else if (i == 35) {
	               nu = true;
	            }
	         }
	      }

	      if (nu) {
	         for(i = 8; i > -1; --i) {
	            if (i != slot) {
	               slotitem = p.getInventory().getItem(i);
	               if (slotitem != null && (new ItemStack(slotitem.getType(), slotitem.getAmount())).equals(slotitem) && slotitem.getType().toString().endsWith(a)) {
	                  if (inhand) {
	                     p.getInventory().setItemInMainHand(slotitem);
	                  } else {
	                     p.getInventory().setItemInOffHand(slotitem);
	                  }

	                  p.getInventory().setItem(i, new ItemStack(Material.AIR));
	                  sendMessage.sendActionBar(p, ChatColor.YELLOW + ChatColor.BOLD.toString() + "(i) " + ChatColor.GOLD + ChatColor.BOLD + "Auto item in action");
	                  p.playSound(p.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 100.0F, 1.0F);
	                  break;
	               }
	            }
	         }
	      }

	   }

}
