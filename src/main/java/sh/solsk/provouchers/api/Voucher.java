package sh.solsk.provouchers.api;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import sh.solsk.provouchers.ProVouchers;

import java.util.List;

public class Voucher {

    // Objects
    private final ProVouchers proVouchers = ProVouchers.getInstance();

    // Internal Settings
    private final String voucherName;
    private String path;
    private boolean isEnabled;

    // Display Item
    private Material displayMaterial;
    private String displayName;
    private List<String> displayLore;
    private boolean glowingEnabled, enchantedEnabled;

    // Reward
    private String message;
    private List<String> commandList;

    // Options
    private boolean soundEnabled, particleEnabled, limitEnabled;
    private String soundType, particleType;
    private int limit;

    // Blacklist
    private List<String> worldBlacklist, permissionBlacklist;
    private boolean worldBlacklistEnabled, permissionBlacklistEnabled;
    private String worldBlacklistMessage, permissionBlacklistMEssage;

    // Whitelist
    private List<String> worldWhitelist, permissionWhitelist;
    private boolean worldWhitelistEnabled, permissionWhitelistEnabled;
    private String worldWhitelistMessage, permissionWhitelistMessage;


    private YamlConfiguration voucherConfig;

    public Voucher(String voucherName) {

        // Internal Settings
        this.voucherName = voucherName;
        this.path = "vouchers." + voucherName + ".";

        // Display Item

    }

    public void buildVoucher() {
        commandList = voucherConfig.getStringList("voucher.options.commands");
        // Replace slashes with blanks so you can run commands as console.
        // commandList.forEach(n -> n.startsWith("/") ? n.replaceFirst("/", "") : n.replace("", ""));

    }

    public Material getDisplayMaterial() {
        return displayMaterial;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getDisplayLore() {
        return displayLore;
    }

    public boolean isGlowingEnabled() {
        return glowingEnabled;
    }

    public boolean isEnchantedEnabled() {
        return enchantedEnabled;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getCommandList() {
        return commandList;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public boolean isParticleEnabled() {
        return particleEnabled;
    }

    public boolean isLimitEnabled() {
        return limitEnabled;
    }

    public String getSoundType() {
        return soundType;
    }

    public String getParticleType() {
        return particleType;
    }

    public int getLimit() {
        return limit;
    }

    public List<String> getWorldBlacklist() {
        return worldBlacklist;
    }

    public List<String> getPermissionBlacklist() {
        return permissionBlacklist;
    }

    public boolean isWorldBlacklistEnabled() {
        return worldBlacklistEnabled;
    }

    public boolean isPermissionBlacklistEnabled() {
        return permissionBlacklistEnabled;
    }

    public String getWorldBlacklistMessage() {
        return worldBlacklistMessage;
    }

    public String getPermissionBlacklistMEssage() {
        return permissionBlacklistMEssage;
    }

    public List<String> getWorldWhitelist() {
        return worldWhitelist;
    }

    public List<String> getPermissionWhitelist() {
        return permissionWhitelist;
    }

    public boolean isWorldWhitelistEnabled() {
        return worldWhitelistEnabled;
    }

    public boolean isPermissionWhitelistEnabled() {
        return permissionWhitelistEnabled;
    }

    public String getWorldWhitelistMessage() {
        return worldWhitelistMessage;
    }

    public String getPermissionWhitelistMessage() {
        return permissionWhitelistMessage;
    }

    public YamlConfiguration getVoucherConfig() {
        return voucherConfig;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public String getPath() {
        return path;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}

