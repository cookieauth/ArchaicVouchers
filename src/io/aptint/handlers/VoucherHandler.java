package io.aptint.handlers;

import io.aptint.api.Voucher;

import java.util.List;

public class VoucherHandler {

    /*
    Load vouchers from each of their files into a voucher map so that
    they can be checked from memory vs. disk. If configuration changes are
    made or the reload command is used, must overwrite this VoucherHandler
    with the new configuration of each affected voucher file.
     */

    private List<Voucher> voucherList;

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

}
