package com.github.sirokuri_.craftdisable.craftdisable.listener;

import com.github.sirokuri_.craftdisable.craftdisable.CraftDisable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;


public class CraftDisableItem implements Listener {

    private final CraftDisable plugin;

    public CraftDisableItem(CraftDisable craftDisable) {
        this.plugin = craftDisable;
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onCraftHideItem(PrepareItemCraftEvent event){
        event.getInventory().setResult(plugin.craftHideItem());
    }
}
