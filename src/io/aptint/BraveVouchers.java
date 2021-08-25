package io.aptint;

import io.aptint.commands.BCCommand;
import io.aptint.commands.BVCommand;
import io.aptint.events.VoucherInteractEvent;
import io.aptint.handlers.TSACHandler;
import io.aptint.handlers.PermissionHandler;
import io.aptint.handlers.TSAVHandler;
import io.aptint.handlers.VoucherHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class BraveVouchers extends JavaPlugin {

    // TODO: Add v1.8.3 through v1.16.5 support.
    // TODO: Add MySQL and SQLite Support for keys.
    // TODO: Add expiration times for codes.
    // TODO: Add amount limits for codes.
    // TODO: Add the ability to enable/disable vouchers/codes.


    private static BraveVouchers braveVouchers;
    private static VoucherHandler voucherHandler;
    private static PermissionHandler permissionHandler;
    private static TSAVHandler TSAVHandler;
    private static TSACHandler TSACHandler;

    private FileConfiguration voucherConfig;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        braveVouchers = this;

        registerEvents();
        registerCommands();
        registerHandlers();

        voucherHandler.loadVouchers();
        voucherConfig = this.getConfig();
        super.onEnable();
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new VoucherInteractEvent(), this);
    }

    private void registerCommands() {
        Objects.requireNonNull(Bukkit.getPluginCommand("bravevoucher")).setExecutor(new BVCommand());

        Objects.requireNonNull(Bukkit.getPluginCommand("bravecodes")).setExecutor(new BCCommand());
    }

    private void registerHandlers() {
        voucherHandler = new VoucherHandler();
        TSAVHandler = new TSAVHandler();
        TSACHandler = new TSACHandler();
    }

    public static BraveVouchers getBraveVouchers() {
        return braveVouchers;
    }

    public static VoucherHandler getVoucherHandler() {
        return voucherHandler;
    }
    public TSACHandler getTSACHandler() { return TSACHandler; }
    public TSAVHandler getTSAVHandler() { return TSAVHandler; }

    public FileConfiguration getVoucherConfig() {
        return voucherConfig;
    }
}
