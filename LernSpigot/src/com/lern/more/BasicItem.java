package com.lern.more;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.lern.utils.sendMessage;

public class BasicItem {
	public void setItem(Player p, int slot, ItemStack a, boolean inhand, boolean ignorenbt) {
	      boolean nu;
	      int i;
	      ItemStack slotitem;
	      if (!ignorenbt) {
	         if ((new ItemStack(a.getType(), a.getAmount())).equals(a)) {
	            nu = false;

	            for(i = 9; i < 36; ++i) {
	               if (i != slot) {
	                  slotitem = p.getInventory().getItem(i);
	                  if (slotitem != null) {
	                     if ((new ItemStack(slotitem.getType(), slotitem.getAmount())).equals(slotitem) && slotitem.getType().equals(a.getType())) {
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
	                     if (slotitem != null && (new ItemStack(slotitem.getType(), slotitem.getAmount())).equals(slotitem) && slotitem.getType().equals(a.getType())) {
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
	      } else {
	         nu = false;

	         for(i = 9; i < 36; ++i) {
	            if (i != slot) {
	               slotitem = p.getInventory().getItem(i);
	               if (slotitem != null) {
	                  if (slotitem.getType().equals(a.getType())) {
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
	                  if (slotitem != null && slotitem.getType().equals(a.getType())) {
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

	   public void setBucket(Player p, int slot, ItemStack a, boolean inhand, boolean ignorenbt) {
	      boolean nu;
	      int i;
	      ItemStack slotitem;
	      if (!ignorenbt) {
	         if ((new ItemStack(a.getType(), a.getAmount())).equals(a)) {
	            nu = false;

	            for(i = 9; i < 36; ++i) {
	               if (i != slot) {
	                  slotitem = p.getInventory().getItem(i);
	                  if (slotitem != null) {
	                     if ((new ItemStack(slotitem.getType(), slotitem.getAmount())).equals(slotitem) && slotitem.getType().equals(a.getType())) {
	                        if (inhand) {
	                           p.getInventory().setItem(i, p.getInventory().getItemInMainHand());
	                           p.getInventory().setItemInMainHand(slotitem);
	                        } else {
	                           p.getInventory().setItem(i, p.getInventory().getItemInOffHand());
	                           p.getInventory().setItemInOffHand(slotitem);
	                        }

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
	                     if (slotitem != null && (new ItemStack(slotitem.getType(), slotitem.getAmount())).equals(slotitem) && slotitem.getType().equals(a.getType())) {
	                        if (inhand) {
	                           p.getInventory().setItem(i, p.getInventory().getItemInMainHand());
	                           p.getInventory().setItemInMainHand(slotitem);
	                        } else {
	                           p.getInventory().setItem(i, p.getInventory().getItemInOffHand());
	                           p.getInventory().setItemInOffHand(slotitem);
	                        }

	                        sendMessage.sendActionBar(p, ChatColor.YELLOW + ChatColor.BOLD.toString() + "(i) " + ChatColor.GOLD + ChatColor.BOLD + "Auto item in action");
	                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 100.0F, 1.0F);
	                        break;
	                     }
	                  }
	               }
	            }
	         }
	      } else {
	         nu = false;

	         for(i = 9; i < 36; ++i) {
	            if (i != slot) {
	               slotitem = p.getInventory().getItem(i);
	               if (slotitem != null) {
	                  if (slotitem.getType().equals(a.getType())) {
	                     if (inhand) {
	                        p.getInventory().setItem(i, p.getInventory().getItemInMainHand());
	                        p.getInventory().setItemInMainHand(slotitem);
	                     } else {
	                        p.getInventory().setItem(i, p.getInventory().getItemInOffHand());
	                        p.getInventory().setItemInOffHand(slotitem);
	                     }

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
	                  if (slotitem != null && slotitem.getType().equals(a.getType())) {
	                     if (inhand) {
	                        p.getInventory().setItem(i, p.getInventory().getItemInMainHand());
	                        p.getInventory().setItemInMainHand(slotitem);
	                     } else {
	                        p.getInventory().setItem(i, p.getInventory().getItemInOffHand());
	                        p.getInventory().setItemInOffHand(slotitem);
	                     }

	                     sendMessage.sendActionBar(p, ChatColor.YELLOW + ChatColor.BOLD.toString() + "(i) " + ChatColor.GOLD + ChatColor.BOLD + "Auto item in action");
	                     p.playSound(p.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 100.0F, 1.0F);
	                     break;
	                  }
	               }
	            }
	         }
	      }

	   }

}
