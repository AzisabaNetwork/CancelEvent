package com.github.sirokuri_.cancelEvent.cancelEvent.listener;

import com.github.sirokuri_.cancelEvent.cancelEvent.CancelEvent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class CraftCancelItem implements Listener {

    private final CancelEvent plugin;

    public CraftCancelItem(CancelEvent cancelEvent) {
        this.plugin = cancelEvent;
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onCraftHideItem(PrepareItemCraftEvent event){
        event.getInventory().setResult(plugin.craftHideItem());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getView().getPlayer();
        ItemStack itemStack = event.getCurrentItem();
        Inventory inventory = event.getClickedInventory();
        if (inventory == null) return;
        int slot = event.getSlot();
        if (itemStack == null) return;
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return;
        if (itemStack.getType() == Material.BARRIER) {
            if(itemMeta.getDisplayName().equals(ChatColor.RED + "クラフトはできません")){
                event.setCancelled(true);
            }
        }
        if (inventory.getHolder() == player.getInventory().getHolder()){
            if (!(slot == 8)) return;
            if (!(player.getGameMode() == GameMode.CREATIVE)) event.setCancelled(true);
        }
    }
}
