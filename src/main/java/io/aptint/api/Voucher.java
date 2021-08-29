package io.aptint.api;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Voucher {

    private String name, displayName;
    private ItemStack itemStack;
    private List<String> loreList, commandList, messageList, argList;
    private Boolean useGlowing, usePermissionWhitelist, usePermissionBlacklist, useWorldWhitelist, useWorldBlacklist;
    private List<String> worldWhitelist, worldBlacklist;

    private YamlConfiguration voucherConfig;

    public void buildVoucher() {
        name = voucherConfig.getString("voucher.name");
        displayName = voucherConfig.getString("voucher.item.displayname");
        itemStack = new ItemStack(Material.valueOf(voucherConfig.getString("voucher.item.item_type")), 1);
        loreList = voucherConfig.getStringList("voucher.item.lore");
        useGlowing = voucherConfig.getBoolean("voucher.item.glowing");
        commandList = voucherConfig.getStringList("voucher.options.commands");
        // Replace slashes with blanks so you can run commands as console.
        // commandList.forEach(n -> n.startsWith("/") ? n.replaceFirst("/", "") : n.replace("", ""));

        // Load Blacklist Database
        // Load Whitelist Database
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public List<String> getLoreList() {
        return loreList;
    }

    public void setLoreList(List<String> loreList) {
        this.loreList = loreList;
    }

    public List<String> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<String> commandList) {
        this.commandList = commandList;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public List<String> getArgList() {
        return argList;
    }

    public void setArgList(List<String> argList) {
        this.argList = argList;
    }

    public Boolean getUseGlowing() {
        return useGlowing;
    }

    public void setUseGlowing(Boolean useGlowing) {
        this.useGlowing = useGlowing;
    }

    public Boolean getUsePermissionWhitelist() {
        return usePermissionWhitelist;
    }

    public void setUsePermissionWhitelist(Boolean usePermissionWhitelist) {
        this.usePermissionWhitelist = usePermissionWhitelist;
    }

    public Boolean getUseWorldWhitelist() {
        return useWorldWhitelist;
    }

    public void setUseWorldWhitelist(Boolean useWorldWhitelist) {
        this.useWorldWhitelist = useWorldWhitelist;
    }

    public List<String> getWorldWhitelist() {
        return worldWhitelist;
    }

    public void setWorldWhitelist(List<String> worldWhitelist) {
        this.worldWhitelist = worldWhitelist;
    }

    public Boolean getUsePermissionBlacklist() {
        return usePermissionBlacklist;
    }

    public void setUsePermissionBlacklist(Boolean usePermissionBlacklist) {
        this.usePermissionBlacklist = usePermissionBlacklist;
    }

    public List<String> getWorldBlacklist() {
        return worldBlacklist;
    }

    public void setWorldBlacklist(List<String> worldBlacklist) {
        this.worldBlacklist = worldBlacklist;
    }

    public Boolean getUseWorldBlacklist() {
        return useWorldBlacklist;
    }

    public void setUseWorldBlacklist(Boolean useWorldBlacklist) {
        this.useWorldBlacklist = useWorldBlacklist;
    }

    public Boolean isWorldBlacklist(String worldName) {
        return getWorldBlacklist().contains(worldName);
    }

    public Boolean isWorldWhitelist(String worldName) {
        return getWorldWhitelist().contains(worldName);
    }

    public Boolean isEdible() {
        return getItemStack().getType().isEdible();
    }
}

