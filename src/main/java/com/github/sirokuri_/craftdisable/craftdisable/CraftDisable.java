package com.github.sirokuri_.craftdisable.craftdisable;

import com.github.sirokuri_.craftdisable.craftdisable.listener.CraftDisableItem;
import com.github.sirokuri_.craftdisable.craftdisable.listener.EventOption;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftDisable extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(new CraftDisableItem(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new EventOption(this), this);
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
