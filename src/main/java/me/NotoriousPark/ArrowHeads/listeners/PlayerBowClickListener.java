package me.NotoriousPark.ArrowHeads.listeners;

import me.NotoriousPark.ArrowHeads.ArrowHeads;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class PlayerBowClickListener extends ArrowHeads implements Listener {
    private HashMap<Player, Integer> bowState = new HashMap<Player, Integer>();

    public PlayerBowClickListener(ArrowHeads plugin) {
    }

    @EventHandler
    public void onBowClick(PlayerInteractEvent event) {
        if (getStatus()) {
            if (event.getItem().getType() == Material.BOW) {
                if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    if (bowState.get(event.getPlayer()) == 3) {
                        bowState.put(event.getPlayer(), 0);
                        event.getPlayer().sendMessage(getPrefix() + getTextId() + "Bow now using " + getArrowType()[0]);
                    } else {
                        bowState.put(event.getPlayer(), bowState.get(event.getPlayer()) + 1);
                        event.getPlayer().sendMessage(getPrefix() + getTextId() + "Bow now using " + getArrowType()[bowState.get(event.getPlayer())]);
                    }
                }
            }
        }
    }

    public HashMap<Player, Integer> getBowState() {
        return bowState;
    }
}