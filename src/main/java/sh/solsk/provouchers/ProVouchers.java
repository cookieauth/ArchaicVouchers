package sh.solsk.provouchers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import sh.solsk.provouchers.events.VoucherInteractEvent;
import sh.solsk.provouchers.managers.UtilManager;
import sh.solsk.provouchers.managers.builtin.CodeManager;
import sh.solsk.provouchers.managers.builtin.VoucherManager;
import sh.solsk.provouchers.managers.files.FileManager;
import sh.solsk.provouchers.managers.files.FileManager.Files;

public class ProVouchers extends JavaPlugin {

    // TODO: Add MySQL and SQLite Support for keys.
    // TODO: Add expiration times for codes.
    // TODO: Add quantity limits for codes.
    // TODO: Add the ability to enable/disable vouchers/codes.

    private static ProVouchers proVouchers;

    private FileManager fileManager;
    private UtilManager utilManager;

    private CodeManager codeManager;
    private VoucherManager voucherManager;

    public static ProVouchers getInstance() {
        return proVouchers;
    }

    @Override
    public void onEnable() {
        proVouchers = this;

        registerEvents();
        registerCommands();
        registerManagers();

        voucherManager.loadVouchers();

        fileManager.logInfo(true).setup();

        if (!Files.DATA.getFile().contains("players")) {
            Files.DATA.getFile().set("players.clear", null);
            Files.DATA.saveFile();
        }
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new VoucherInteractEvent(), this);
    }

    private void registerCommands() {

    }

    private void registerManagers() {

        fileManager = new FileManager();
        utilManager = new UtilManager();

        voucherManager = new VoucherManager();
        codeManager = new CodeManager();
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public UtilManager getUtilManager() {
        return utilManager;
    }

    public CodeManager getCodeManager() {
        return codeManager;
    }

    public VoucherManager getVoucherManager() {
        return voucherManager;
    }
}
