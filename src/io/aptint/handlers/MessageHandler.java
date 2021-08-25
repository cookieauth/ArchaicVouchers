package io.aptint.handlers;

public enum MessageHandler {

    // Default Messages

    // User doesn't have permission to perform specified command
    COMMAND_ERROR_PERMISSION("command.permission-error", "&cYou do not have permission to perform this command!"),
    COMMAND_ERROR_UNKNOWN("", "&cSorry that command couldn't be found."),

    // Code limit reached locally
    CODE_LIMIT_PLAYER_USED("codes.player-limit-reached", "&cYou have reached the usage limit for this code!"),
    // Code limit reached globally
    CODE_LIMIT_GLOBAL_USED("codes.server-limit-reached", "&cThis code has reached it's limit across the server"),
    // Code successfully used
    CODE_USED("codes.redeem-success", "&aThis code was successfully redeemed!"),
    // An error occurred with code- typo, invalid, non-existent
    CODE_ERROR("codes.invalid-code", "&cThere was an error with this code! Please check if it exists or if there was a typo."),
    // Code TSA - Confirmation
    CODE_TSA_CONFIRMATION("codes.two-step.confirmation", "&cAre you sure you would like to redeem this code? &eIf so, please type /vcode confirm"),
    // Code TSA - Confirmed
    CODE_TSA_CONFIRMED("codes.two-step.confirmed", "&aThanks for confirming you would like to use this code!"),
    // Code TSA - Timeout Reached
    CODE_TSA_TIMEOUT("codes.two-step.timeout", "&cSorry, but the timeout was reached for the code entered. Please try redeeming the code again."),
    // Coda TSA - Not Enabled
    CODE_TSA_DISABLED("codes.two-step.disabled", "&cOops! Two-step confirmation is not enabled for voucher codes!"),
    // Code TSA - Nothing to confirm
    CODE_TSA_EMPTY("codes.two-step.no-code", "&cOops! There is nothing for you to confirm at this time!"),
    // Code TSA - Already redeeming a code.
    CODE_TSA_REDEEMING("codes.two-step.already-redeeming", "&cOops! You are already redeeming a code! If you would like to cancel the current redeeming process, please enter /vcodes redeem cancel"),
    CODE_SYNTAX_REDEEM("/vcodes redeem <code>"),
    CODE_SYNTAX_CONFIRM("/vcodes confirm <code>"),
    CODE_SYNTAX_PREVIEW("/vcodes preview <code>"),
    CODE_SYNTAX_INFO("/vcodes info <code>"),
    CODE_SYNTAX_SET_EXPIRY("/vcodes setexpiry <code> <date/time>"),
    CODE_SYNTAX_SET_LIMIT("/vcodes setlimit <code> <server/player> <limit_amount>"),
    CODE_SYNTAX_SET_STATUS("/vcodes setstatus <code/all> <enable/disable>"),
    CODE_SYNTAX_REMOVE("/vcodes remove <code/all>"),
    CODE_SYNTAX_AWARD("/vcodes award <code> <player>"),
    CODE_SYNTAX_AWARD_ALL("/vcodes awardall <code>"),
    CODE_SYNTAX_HELP("/vcodes help"),
    CODE_SYNTAX_USER_GUI("/vcodes gui"),
    CODE_SYNTAX_ADMIN_GUI("vcodes gui admin"),



    // Voucher was successfully used
    VOUCHER_USED("vouchers.redeem-success", "&aSuccessfully redeemed your voucher!"),
    // Voucher limit reached locally
    VOUCHER_LIMIT_PLAYER_USED("vouchers.player-limit-reached", "&cYou have reached the usage limit for this voucher!"),
    // Voucher limits reached globally
    VOUCHER_LIMIT_GLOBAL_USED("vouchers.server-limit-reached", "&cThis voucher has reached it's limit across the server!"),
    // Voucher TSA - Confirmation
    VOUCHER_TSA_CONFIRMATION("vouchers.two-step-confirmation", "&cAre you sure you would like to redeem this voucher? &eIf so, please type /voucher confirm"),
    // Voucher TSA - Confirmed
    VOUCHER_TSA_CONFIRMED("vouchers.two-step.confirmed", "&aSuccessfully confirmed you would like to redeem your voucher!"),
    // Voucher TSA - Timeout Reached
    VOUCHER_TSA_TIMEOUT("vouchers.two-step.timeout", "&cSorry, but the timeout limit was reached for your voucher. Please try redeeming your voucher again."),
    // Voucher awarded to individual user
    VOUCHER_AWARDED_PLAYER("vouchers.awarded-player", "&a%player% gave you a %voucher_name%! Check your inventory to redeem your voucher!"),
    // Voucher awarded to all online globally
    VOUCHER_AWARDED_GLOBAL("vouchers.awarded-global", "&a%player% gave everyone a %voucher_name%! Check your inventory to redeem your voucher!"),
    // World isn't whitelisted for voucher use
    VOUCHER_ERROR_NOT_WHITELIST_WORLD("vouchers.whitelisted-world-error", "&cThe world you are in doesn't permit redeeming vouchers. Please try a different world!"),
    // Voucher the user is opening isn't a valid voucher
    VOUCHER_ERROR_NOT_VOUCHER("vouchers.invalid-voucher", "&cSorry, the voucher you're trying to use is not a voucher, invalid or expired."),
    // Entity opening voucher isn't a user
    VOUCHER_ERROR_NOT_PLAYER("vouchers.invalid-user", "&cSorry, you must be a player to redeem a voucher."),
    // User doesn't have permission for voucher usage
    VOUCHER_ERROR_PERMISSION("vouchers.permission.redeem-error", "&cYou do not have permission to redeem this voucher."),
    // User has blacklist permission, cannot use more than once
    VOUCHER_ERROR_BLACKLIST("vouchers.permission.blacklist-error", "&cYou can only redeem this voucher once! Please try a different voucher."),
    VOUCHER_SYNTAX_REDEEM("/vouchers redeem <name>"),
    VOUCHER_SYNTAX_CONFIRM("/vouchers confirm <name>"),
    VOUCHER_SYNTAX_PREVIEW("/vouchers preview <name>"),
    VOUCHER_SYNTAX_INFO("/vouchers info <name>"),
    VOUCHER_SYNTAX_SET_EXPIRY("/vouchers setexpiry <name> <date/time>"),
    VOUCHER_SYNTAX_SET_LIMIT("/vouchers setlimit <name> <server/player> <limit_amount>"),
    VOUCHER_SYNTAX_SET_STATUS("/vouchers setstatus <name> <enable/disable>"),
    VOUCHER_SYNTAX_REMOVE("/vouchers remove <name>"),
    VOUCHER_SYNTAX_AWARD("/vouchers award <name> <player> <amount>"),
    VOUCHER_SYNTAX_AWARD_ALL("/vouchers awardall <name> <amount>"),
    VOUCHER_SYNTAX_HELP("/vouchers help"),
    VOUCHER_SYNTAX_USER_GUI("/vouchers gui"),
    VOUCHER_SYNTAX_ADMIN_GUI("vouchers gui admin"),

    // Users inventory is full, physical items could not be awarded
    PLAYER_INVENTORY_FULL("player.inventory-full", "&cOops! Your inventory is full! Please clear some items and try again."),
    // User specified is not online
    PLAYER_NOT_ONLINE("player.offline", "&cOops! That player is not online!"),

    // Specified parameter is not a number
    RESOURCE_ERROR_NAN(""),
    // An error occurred while reload the resource
    RESOURCE_ERROR_RELOAD(""),
    // An error occurred while reloading the configuration
    RESOURCE_ERROR_CONF_RELOAD(""),
    // Configuration was successfully reloaded
    RESOURCE_RELOAD_CONFIGURATION(""),
    RESOURCE_INVALID_SYNTAX("&cInvalid Usage!"),
    // The resource was successfully reloaded.
    RESOURCE_RELOAD("");


    private final String messagePath, message;

    MessageHandler(String messagePath, String message) {
        this.messagePath = messagePath;
        this.message = message;
    }

    MessageHandler(String message) {
        this.messagePath = "";
        this.message = message;
    }

    public String getMessagePath() {
        return this.messagePath;
    }

    public String get() {
        return this.message;
    }
}
