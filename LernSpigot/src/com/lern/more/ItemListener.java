package com.lern.more;

import java.util.HashMap;
import java.util.UUID;
import com.lern.more.CustomItem;
import com.lern.Main;
import com.lern.more.BasicItem;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.Listener;

public class ItemListener extends BasicItem implements Listener{
	private Main core;
	   private final HashMap<UUID, Boolean> dropcancel = new HashMap();

	   public ItemListener(Main core) {
	      this.core = core;
	      core.getServer().getPluginManager().registerEvents(this, core);
	   }

	   @EventHandler
	   public void onDropInInventory(InventoryClickEvent e) {
	      final Player p = (Player)e.getWhoClicked();
	      if (e.getAction().equals(InventoryAction.DROP_ALL_CURSOR) || e.getAction().equals(InventoryAction.DROP_ALL_SLOT) || e.getAction().equals(InventoryAction.DROP_ONE_CURSOR) || e.getAction().equals(InventoryAction.DROP_ONE_SLOT) || e.getAction().equals(InventoryAction.PLACE_ALL)) {
	         this.dropcancel.put(p.getUniqueId(), true);
	         (new BukkitRunnable() {
	            public void run() {
	               ItemListener.this.dropcancel.put(p.getUniqueId(), false);
	            }
	         }).runTaskLater(this.core, 1L);
	      }

	   }

	   @EventHandler
	   public void onItemBreak(PlayerItemBreakEvent e) {
	      Player p = e.getPlayer();
	      ItemStack itembreak = e.getBrokenItem();
	      int itemslot = p.getInventory().getHeldItemSlot();
	      if (itembreak.equals(p.getInventory().getItemInMainHand())) {
	         this.setItem(p, itemslot, itembreak, true, true);
	      } else if (itembreak.equals(p.getInventory().getItemInOffHand()) && !itembreak.equals(p.getInventory().getItemInMainHand())) {
	         this.setItem(p, itemslot, itembreak, false, true);
	      }

	   }

	   @EventHandler(
	      ignoreCancelled = true
	   )
	   public void onPlaceBlock(BlockPlaceEvent e) {
	      if (!e.isCancelled()) {
	         Player p = e.getPlayer();
	         ItemStack inhand = e.getItemInHand();
	         int itemslot = p.getInventory().getHeldItemSlot();
	         if ((p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)) && inhand.getType().getMaxDurability() == 0) {
	            if (inhand.getType().equals(p.getInventory().getItemInMainHand().getType()) && p.getInventory().getItemInMainHand().getAmount() - 1 == 0) {
	               this.setItem(p, itemslot, inhand, true, false);
	            } else if (inhand.getType().equals(p.getInventory().getItemInOffHand().getType()) && p.getInventory().getItemInOffHand().getAmount() - 1 == 0) {
	               this.setItem(p, itemslot, inhand, false, false);
	            }
	         }
	      }

	   }

	   @EventHandler(
	      ignoreCancelled = true
	   )
	   public void onEat(PlayerItemConsumeEvent e) {
	      if (!e.isCancelled()) {
	         Player p = e.getPlayer();
	         ItemStack itembreak = e.getItem();
	         int itemslot = p.getInventory().getHeldItemSlot();
	         if ((p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)) && !itembreak.getType().equals(Material.POTION)) {
	            if (itembreak.equals(p.getInventory().getItemInMainHand()) && p.getInventory().getItemInMainHand().getAmount() - 1 == 0) {
	               this.setItem(p, itemslot, itembreak, true, false);
	            } else if (itembreak.equals(p.getInventory().getItemInOffHand()) && p.getInventory().getItemInOffHand().getAmount() - 1 == 0) {
	               this.setItem(p, itemslot, itembreak, false, false);
	            }
	         }
	      }

	   }

	   @EventHandler(
	      ignoreCancelled = true
	   )
	   public void onDropItem(PlayerDropItemEvent e) {
	      if (!e.isCancelled()) {
	         Player p = e.getPlayer();
	         this.dropcancel.putIfAbsent(p.getUniqueId(), false);
	         ItemStack inhand = p.getInventory().getItemInMainHand();
	         ItemStack dropitem = e.getItemDrop().getItemStack();
	         if (!(Boolean)this.dropcancel.get(p.getUniqueId()) && inhand.getType().equals(Material.AIR)) {
	            this.setItem(p, p.getInventory().getHeldItemSlot(), dropitem, true, false);
	         }

	         this.dropcancel.put(p.getUniqueId(), false);
	      }

	   }

	   @EventHandler
	   public void onCustomEvent(PlayerInteractEvent e) {
	      final Player p = e.getPlayer();
	      if (p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)) {
	         ItemStack inhand = e.getPlayer().getInventory().getItemInMainHand();
	         if (inhand.getType().getMaxDurability() == 0) {
	            final CustomItem custom = new CustomItem(this, p, inhand, p.getInventory().getHeldItemSlot());
	            (new BukkitRunnable() {
	               public void run() {
	                  custom.Check(p.getInventory().getItemInMainHand());
	               }
	            }).runTaskLater(this.core, 1L);
	         }
	      }

	   }

	   @EventHandler
	   public void onBucketFill(final PlayerBucketFillEvent e) {
	      if (!e.isCancelled()) {
	         final Player p = e.getPlayer();
	         final ItemStack itemuse = p.getInventory().getItemInMainHand().clone();
	         final int itemslot = p.getInventory().getHeldItemSlot();
	         (new BukkitRunnable() {
	            public void run() {
	               if (p.getInventory().getItemInMainHand().equals(e.getItemStack())) {
	                  ItemListener.this.setBucket(p, itemslot, itemuse, true, true);
	               } else if (p.getInventory().getItemInOffHand().equals(e.getItemStack())) {
	                  ItemListener.this.setBucket(p, itemslot, itemuse, true, false);
	               }

	            }
	         }).runTaskLater(this.core, 1L);
	      }

	   }

}
