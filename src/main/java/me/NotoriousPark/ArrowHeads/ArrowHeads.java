package me.NotoriousPark.ArrowHeads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ArrowHeads extends JavaPlugin {
    FileConfiguration config = this.getConfig();
    private ChatColor bracketId;
    private ChatColor serverId;
    private ChatColor textId;
    private ChatColor mainId;
    private String prefix;

    @Override
    public void onEnable() {
        config.options().copyDefaults();

        load();
        register();
    }

    public void load() {
        this.setBracketId(this.config.getString("Bracket ID"));
        this.setServerId(this.config.getString("Server ID"));
        this.setMainId(this.config.getString("Main ID"));
        this.setTextId(this.config.getString("Text ID"));
        this.setPrefix();
    }

    public void register() {

    }

    public ChatColor getBracketId() {
        return this.bracketId;
    }

    public void setBracketId(String id) {
        this.bracketId = ChatColor.getByChar(id);
    }

    public ChatColor getServerId() {
        return this.serverId;
    }

    public void setServerId(String id) {
        this.serverId = ChatColor.getByChar(id);
    }

    public ChatColor getMainId() {
        return this.mainId;
    }

    public void setMainId(String id) {
        this.mainId = ChatColor.getByChar(id);
    }

    public ChatColor getTextId() {
        return this.textId;
    }

    public void setTextId(String id) {
        this.textId = ChatColor.getByChar(id);
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix() {
        this.prefix = getBracketId() + "[" + getServerId() + "Arrow Heads" + getBracketId() + "] ";
    }

    public void broadcsat(String msg) {
        Bukkit.broadcastMessage(getPrefix() + msg);
    }

    public void playsound(Sound sound) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), sound, 10, 1);
        }
    }
}