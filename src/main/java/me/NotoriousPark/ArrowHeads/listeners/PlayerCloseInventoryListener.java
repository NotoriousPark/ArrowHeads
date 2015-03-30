package me.NotoriousPark.ArrowHeads.listeners;

import me.NotoriousPark.ArrowHeads.ArrowHeads;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class PlayerCloseInventoryListener extends ArrowHeads implements Listener {
    private HashMap<Player, ItemStack> slot0 = new HashMap<Player, ItemStack>();
    private HashMap<Player, ItemStack> slot1 = new HashMap<Player, ItemStack>();
    private HashMap<Player, ItemStack> slot2 = new HashMap<Player, ItemStack>();

    public PlayerCloseInventoryListener(ArrowHeads plugin) {
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (getStatus()) {
            if (event.getInventory().getTitle() == "Quiver") {
                ItemStack[] items = event.getInventory().getContents();
                Player player = (Player) event.getPlayer();

                slot0.put(player, items[0]);
                slot1.put(player, items[1]);
                slot2.put(player, items[2]);
            }
        }
    }

    public HashMap<Player, ItemStack> getSlot0() {
        return slot0;
    }

    public HashMap<Player, ItemStack> getSlot1() {
        return slot1;
    }

    public HashMap<Player, ItemStack> getSlot2() {
        return slot2;
    }
}