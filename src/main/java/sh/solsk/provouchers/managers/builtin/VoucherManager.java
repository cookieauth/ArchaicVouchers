package sh.solsk.provouchers.managers.builtin;

import sh.solsk.provouchers.api.Voucher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class VoucherManager {

    /*
    Load vouchers from each of their files into a voucher map so that
    they can be checked from memory vs. disk. If configuration changes are
    made or the reload command is used, must overwrite this VoucherHandler
    with the new configuration of each affected voucher file.
     */

    private List<Voucher> voucherList;
    private Map<UUID, Voucher> twoStepMap;

    private boolean tsaEnabled;

    public void loadVouchers() {
        // TODO: Load vouchers from /vouchers/voucher_example.yml
        // TODO: Verify voucher configuration files are valid with validateVoucher()
            // Verify if essential configuration settings are present, ignore optionals.
            // If one or more essential settings are not present, do not load the voucher file.

        // Load Vouchers from each of their own files here and load them into the voucher map. Accessible from the other main classes.


        // Use the Voucher object to create the vouchers from configuration to load into memory as ItemStacks.
    }

    public List<Voucher> getVoucherList() {
        return this.voucherList;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }

    public Map<UUID, Voucher> getTwoStepMap() {
        return twoStepMap;
    }

    public void setTwoStepMap(Map<UUID, Voucher> twoStepMap) {
        this.twoStepMap = twoStepMap;
    }

    public boolean isTsaEnabled() {
        return tsaEnabled;
    }

    public void setTsaEnabled(boolean tsaEnabled) {
        this.tsaEnabled = tsaEnabled;
    }
}
