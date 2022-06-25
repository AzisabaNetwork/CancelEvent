package com.github.sirokuri_.cancelEvent.cancelEvent.listener;

import com.github.sirokuri_.cancelEvent.cancelEvent.CancelEvent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ClickCancelBlock implements Listener {

    private final CancelEvent plugin;

    public ClickCancelBlock(CancelEvent cancelEvent) {
        this.plugin = cancelEvent;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(event.getHand() == EquipmentSlot.HAND)) return;
        if (block.getType() == Material.COMPOSTER || block.getType() == Material.GRINDSTONE){
            event.setCancelled(true);
        }
    }
}
