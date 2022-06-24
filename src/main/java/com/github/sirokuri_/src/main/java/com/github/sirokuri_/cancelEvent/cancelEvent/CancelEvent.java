package com.github.sirokuri_.cancelEvent.cancelEvent;

import com.github.sirokuri_.cancelEvent.cancelEvent.listener.ClickCancelBlock;
import com.github.sirokuri_.cancelEvent.cancelEvent.listener.CraftCancelItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class CancelEvent extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(new CraftCancelItem(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ClickCancelBlock(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ItemStack craftHideItem(){
        ItemStack itemStack = new ItemStack(Material.BARRIER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "クラフトはできません");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
