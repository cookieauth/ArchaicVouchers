package io.aptint;

import io.aptint.commands.PVCCommand;
import io.aptint.commands.PVCommand;
import io.aptint.events.VoucherInteractEvent;
import io.aptint.handlers.PermissionHandler;
import io.aptint.handlers.TSACHandler;
import io.aptint.handlers.TSAVHandler;
import io.aptint.handlers.VoucherHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ProVouchers extends JavaPlugin {

    // TODO: Add v1.8.3 through v1.17.1 support.
    // TODO: Add MySQL and SQLite Support for keys.
    // TODO: Add expiration times for codes.
    // TODO: Add quantity limits for codes.
    // TODO: Add the ability to enable/disable vouchers/codes.


    private static ProVouchers proVouchers;
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
        proVouchers = this;

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
        Objects.requireNonNull(Bukkit.getPluginCommand("bravevoucher")).setExecutor(new PVCommand());

        Objects.requireNonNull(Bukkit.getPluginCommand("bravecodes")).setExecutor(new PVCCommand());
    }

    private void registerHandlers() {
        voucherHandler = new VoucherHandler();
        TSAVHandler = new TSAVHandler();
        TSACHandler = new TSACHandler();
    }

    public static ProVouchers getBraveVouchers() {
        return proVouchers;
    }

    public static VoucherHandler getVoucherHandler() {
        return voucherHandler;
    }

    public TSACHandler getTSACHandler() {
        return TSACHandler;
    }

    public TSAVHandler getTSAVHandler() {
        return TSAVHandler;
    }

    public FileConfiguration getVoucherConfig() {
        return voucherConfig;
    }
}
