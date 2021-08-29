package io.aptint.handlers;

public enum PermissionHandler {

    CODE_USER("vouchercodes.user"),
    CODE_USER_REDEEM("vouchercodes.redeem"),
    CODE_USER_CONFIRM("vouchercodes.redeem"),
    CODE_USER_GUI("vouchercodes.gui"),
    CODE_USER_HELP("vouchercodes.user"),
    CODE_USER_PREVIEW("vouchercodes.preview"),
    CODE_USER_INFO("vouchercodes.info"),

    CODE_ADMIN_SET_LIMIT("vouchercodes.admin.setlimit"),
    CODE_ADMIN_SET_EXPIRY("vouchercodes.admin.setexpiry"),
    CODE_ADMIN_SET_STATUS("vouchercodes.admin.setstatus"),
    CODE_ADMIN_REMOVE("vouchercodes.admin.remove"),
    CODE_ADMIN_AWARD("vouchercodes.admin.award"),
    CODE_ADMIN_AWARD_ALL("vouchercodes.admin.awardall"),
    CODE_ADMIN_GUI("vouchercodes.admin.gui"),
    CODE_ADMIN_HELP("vouchercodes.admin.help"),

    VOUCHER_USER("vouchersx.user"),
    VOUCHER_USER_REDEEM("vouchersx.redeem"),
    VOUCHER_USER_CONFIRM("vouchersx.redeem"),
    VOUCHER_USER_GUI("vouchersx.gui"),
    VOUCHER_USER_HELP("vouchersx.user"),
    VOUCHER_USER_PREVIEW("vouchersx.preview"),
    VOUCHER_USER_INFO("vouchersx.info"),

    VOUCHER_ADMIN_SET_LIMIT("vouchersx.admin.setlimit"),
    VOUCHER_ADMIN_SET_EXPIRY("vouchersx.admin.setexpiry"),
    VOUCHER_ADMIN_SET_STATUS("vouchersx.admin.setstatus"),
    VOUCHER_ADMIN_REMOVE("vouchersx.admin.remove"),
    VOUCHER_ADMIN_AWARD("vouchersx.admin.award"),
    VOUCHER_ADMIN_AWARD_ALL("vouchersx.admin.awardall"),
    VOUCHER_ADMIN_GUI("vouchersx.admin.gui"),
    VOUCHER_ADMIN_HELP("vouchersx.admin.help");

    private final String permission;

    PermissionHandler(String permission) {
        this.permission = permission;
    }

    public String get() {
        return this.permission;
    }
}
