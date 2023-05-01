package sh.solsk.provouchers.managers;

public enum PermissionManager {

    CODE_USER("provouchers.code.user"),
    CODE_USER_REDEEM("provouchers.code.redeem"),
    CODE_USER_CONFIRM("provouchers.code.redeem"),
    CODE_USER_GUI("provouchers.code.gui"),
    CODE_USER_HELP("provouchers.code.user"),
    CODE_USER_PREVIEW("provouchers.code.preview"),
    CODE_USER_INFO("provouchers.code.info"),

    CODE_ADMIN_SET_LIMIT("provouchers.code.admin.setlimit"),
    CODE_ADMIN_SET_EXPIRY("provouchers.code.admin.setexpiry"),
    CODE_ADMIN_SET_STATUS("provouchers.code.admin.setstatus"),
    CODE_ADMIN_REMOVE("provouchers.code.admin.remove"),
    CODE_ADMIN_AWARD("provouchers.code.admin.award"),
    CODE_ADMIN_AWARD_ALL("provouchers.code.admin.awardall"),
    CODE_ADMIN_GUI("provouchers.code.admin.gui"),
    CODE_ADMIN_HELP("provouchers.code.admin.help"),

    VOUCHER_USER("provouchers.voucher.user"),
    VOUCHER_USER_REDEEM("provouchers.voucher.redeem"),
    VOUCHER_USER_CONFIRM("provouchers.voucher.redeem"),
    VOUCHER_USER_GUI("provouchers.voucher.gui"),
    VOUCHER_USER_HELP("provouchers.voucher.user"),
    VOUCHER_USER_PREVIEW("provouchers.voucher.preview"),
    VOUCHER_USER_INFO("provouchers.voucher.info"),

    VOUCHER_ADMIN_SET_LIMIT("provouchers.voucher.admin.setlimit"),
    VOUCHER_ADMIN_SET_EXPIRY("provouchers.voucher.admin.setexpiry"),
    VOUCHER_ADMIN_SET_STATUS("provouchers.voucher.admin.setstatus"),
    VOUCHER_ADMIN_REMOVE("provouchers.voucher.admin.remove"),
    VOUCHER_ADMIN_AWARD("provouchers.voucher.admin.award"),
    VOUCHER_ADMIN_AWARD_ALL("provouchers.voucher.admin.awardall"),
    VOUCHER_ADMIN_GUI("provouchers.voucher.admin.gui"),
    VOUCHER_ADMIN_HELP("provouchers.voucher.admin.help");

    private final String permission;

    PermissionManager(String permission) {
        this.permission = permission;
    }

    public String get() {
        return this.permission;
    }
}
