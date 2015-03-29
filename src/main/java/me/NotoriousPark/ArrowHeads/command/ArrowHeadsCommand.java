package me.NotoriousPark.ArrowHeads.command;

import me.NotoriousPark.ArrowHeads.ArrowHeads;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ArrowHeadsCommand extends ArrowHeads implements CommandExecutor {

    public ArrowHeadsCommand(ArrowHeads plugin) {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args == null || args.length == 0) {
            sender.sendMessage(getPrefix() + getTextId() + "Invalid Syntax.");
            return false;
        }

        if (args[0].equalsIgnoreCase("enable")) {
            if (getStatus()) {
                sender.sendMessage(getPrefix() + getTextId() + "Arrow Heads is already enabled.");
                return false;
            } else {
                setStatus(true);
                broadcast(getTextId() + "Arrow Heads " + ChatColor.DARK_GREEN + "ENABLED" + getTextId()" !");
                playsound(Sound.NOTE_PIANO);
                return true;
            }
        } else if (args[0].equalsIgnoreCase("disable")) {
            if (!getStatus()) {
                sender.sendMessage(getPrefix() + getTextId() + "Arrow Heads is already disabled.");
                return false;
            } else {
                setStatus(false);
                broadcast(getTextId() + "Arrow Heads" + ChatColor.DARK_RED + "DISABLED" + getTextId() + " !");
                playsound(Sound.GLASS);
                return true;
            }
        }
        return false;
    }
}