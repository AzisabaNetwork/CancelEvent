package com.github.sirokuri_.craftdisable.craftdisable.listener;

import com.github.sirokuri_.craftdisable.craftdisable.CraftDisable;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class EventOption implements Listener {

    private final CraftDisable plugin;

    public EventOption(CraftDisable craftDisable) {
        this.plugin = craftDisable;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(event.getHand() == EquipmentSlot.HAND)) return;
        if(block.getType() == Material.COMPOSTER){
            event.setCancelled(true);
        }
    }
}
