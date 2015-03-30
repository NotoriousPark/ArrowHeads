package me.NotoriousPark.ArrowHeads.listeners;

import me.NotoriousPark.ArrowHeads.ArrowHeads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class PlayerQuiverClickListener extends ArrowHeads implements Listener {
    PlayerCloseInventoryListener closeInv;
    private HashMap<Player, Inventory> playerQuiver = new HashMap<Player, Inventory>();

    public PlayerQuiverClickListener(ArrowHeads plugin) {
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if (getStatus()) {
            if (event.getItem().getItemMeta().getDisplayName() == "Quiver") {
                openGUI(event.getPlayer());
            }
        }
    }

    private void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 3, ChatColor.WHITE + "Quiver");
        playerQuiver.put(player, inv);

        inv.setItem(0, closeInv.getSlot0().get(player));
        inv.setItem(1, closeInv.getSlot1().get(player));
        inv.setItem(2, closeInv.getSlot2().get(player));

        player.openInventory(inv);
    }

    public HashMap<Player, Inventory> getPlayerQuiver() {
        return playerQuiver;
    }
}