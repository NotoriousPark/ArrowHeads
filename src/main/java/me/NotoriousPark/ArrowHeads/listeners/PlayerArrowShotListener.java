package me.NotoriousPark.ArrowHeads.listeners;

import me.NotoriousPark.ArrowHeads.ArrowHeads;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerArrowShotListener extends ArrowHeads implements Listener {
    PlayerBowClickListener bowClick;
    PlayerQuiverClickListener quiver;

    public PlayerArrowShotListener(ArrowHeads plugin) {}

    @EventHandler
    public void onArrowShot(PlayerInteractEvent event) {
        if (getStatus()) {
            if (event.getItem().getType() == Material.BOW) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Player player = event.getPlayer();
                    if (!player.getInventory().contains(getArrowItems()[bowClick.getBowState().get(player)])) {
                        if (quiver.getPlayerQuiver().get(player).contains(getArrowItems()[bowClick.getBowState().get(player)])) {
                            quiver.getPlayerQuiver().get(player).remove(getArrowItems()[bowClick.getBowState().get(player)]);
                            player.getInventory().addItem(getArrowItems()[bowClick.getBowState().get(player)]);
                        }
                    }
                }
            }
        }
    }
}