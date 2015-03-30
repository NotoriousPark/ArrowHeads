package me.NotoriousPark.ArrowHeads;

import me.NotoriousPark.ArrowHeads.command.ArrowHeadsCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;


public class ArrowHeads extends JavaPlugin {
    FileConfiguration config = this.getConfig();
    private ChatColor bracketId;
    private ChatColor serverId;
    private ChatColor textId;
    private ChatColor mainId;
    private String prefix;

    private boolean arrowheads = false;
    private String[] arrowTypes = {ChatColor.WHITE + "Normal Arrows", ChatColor.GREEN + "Poison Arrows", ChatColor.GRAY + "Weakness Arrows", ChatColor.BLACK + "Slowness Arrows"};
    private ItemStack[] arrowItems = {new ItemStack(Material.ARROW, 1), setItemName(new ItemStack(Material.ARROW, 1), "Poison Arrow"), setItemName(new ItemStack(Material.ARROW, 1), "Weakness Arrow"), setItemName(new ItemStack(Material.ARROW, 1), "Slowness Arrow")};

    private final ShapelessRecipe QUIVER;
    private final ShapedRecipe POISONARROW;
    private final ShapedRecipe WEAKNESSARROW;
    private final ShapedRecipe SLOWNESSARROW;

    public ArrowHeads() {
        QUIVER = new ShapelessRecipe(setItemName(new ItemStack(Material.LEVER), "Quiver")).addIngredient(4, Material.LEATHER);
        POISONARROW = new ShapedRecipe(setItemName(new ItemStack(Material.ARROW, 8), "Poison Arrow")).shape("AAA", "AEA", "AAA").setIngredient('A', Material.ARROW).setIngredient('E', Material.SPIDER_EYE);
        WEAKNESSARROW = new ShapedRecipe(setItemName(new ItemStack(Material.ARROW, 8), "Weakness Arrow")).shape("AAA", "AFA", "AAA").setIngredient('A', Material.ARROW).setIngredient('F', Material.FERMENTED_SPIDER_EYE);
        SLOWNESSARROW = new ShapedRecipe(setItemName(new ItemStack(Material.ARROW, 8), "Slowness Arrow")).shape("AAA", "ASA", "AAA").setIngredient('A', Material.ARROW).setIngredient('S', Material.SUGAR);
    }

    public ItemStack setItemName(ItemStack item, String name) {
        item.getItemMeta().setDisplayName(name);
        return item;
    }

    @Override
    public void onEnable() {
        config.options().copyDefaults();

        load();
        registerCommands();
        registerListeners();
    }

    public void load() {
        this.setBracketId(this.config.getString("Bracket ID"));
        this.setServerId(this.config.getString("Server ID"));
        this.setMainId(this.config.getString("Main ID"));
        this.setTextId(this.config.getString("Text ID"));
        this.setPrefix();
    }

    public void registerCommands() {
        getCommand("arrowheads").setExecutor(new ArrowHeadsCommand(this));
    }

    public void registerListeners() {

    }

    public void registerRecipes() {
        getServer().addRecipe(QUIVER);
        getServer().addRecipe(POISONARROW);
        getServer().addRecipe(WEAKNESSARROW);
        getServer().addRecipe(SLOWNESSARROW);
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

    public void broadcast(String msg) {
        Bukkit.broadcastMessage(getPrefix() + msg);
    }

    public void playsound(Sound sound) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), sound, 10, 1);
        }
    }

    public void setStatus(boolean arrowheads) {
        this.arrowheads = arrowheads;
    }

    public boolean getStatus() {
        return arrowheads;
    }

    public String[] getArrowType() {
        return arrowTypes;
    }

    public ItemStack[] getArrowItems() {
        return arrowItems;
    }
}