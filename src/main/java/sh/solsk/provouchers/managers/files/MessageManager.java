package sh.solsk.provouchers.managers.files;

import org.bukkit.configuration.file.FileConfiguration;
import sh.solsk.provouchers.ProVouchers;
import sh.solsk.provouchers.managers.files.FileManager.Files;
import sh.solsk.provouchers.managers.UtilManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum MessageManager {

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

    // An error occurred with the code - A typo, invalid, or non-existent
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


    VOUCHER_SYNTAX_REDEEM("/provouchers redeem <name>"),
    VOUCHER_SYNTAX_CONFIRM("/provouchers confirm <name>"),
    VOUCHER_SYNTAX_PREVIEW("/provouchers preview <name>"),
    VOUCHER_SYNTAX_INFO("/provouchers info <name>"),
    VOUCHER_SYNTAX_SET_EXPIRY("/provouchers setexpiry <name> <date/time>"),
    VOUCHER_SYNTAX_SET_LIMIT("/provouchers setlimit <name> <server/player> <limit_amount>"),
    VOUCHER_SYNTAX_SET_STATUS("/provouchers setstatus <name> <enable/disable>"),
    VOUCHER_SYNTAX_REMOVE("/provouchers remove <name>"),
    VOUCHER_SYNTAX_AWARD("/provouchers award <name> <player> <amount>"),
    VOUCHER_SYNTAX_AWARD_ALL("/provouchers awardall <name> <amount>"),
    VOUCHER_SYNTAX_HELP("/provouchers help"),
    VOUCHER_SYNTAX_USER_GUI("/provouchers gui"),
    VOUCHER_SYNTAX_ADMIN_GUI("provouchers gui admin"),

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
    RESOURCE_RELOAD(""),


    NAN(""),


    NOT_ONLINE("");


    private static final ProVouchers instance = ProVouchers.getInstance();
    private static final UtilManager utilManager = instance.getUtilManager();

    private String path;
    private String defaultMessage;
    private List<String> defaultListMessage;

    MessageManager(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    MessageManager(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    MessageManager(String path, List<String> defaultListMessage) {
        this.path = path;
        this.defaultListMessage = defaultListMessage;
    }

    public static String convertList(List<String> list) {
        StringBuilder message = new StringBuilder();

        for (String line : list) {
            message.append(utilManager.colorize(line)).append("\n");
        }

        return message.toString();
    }

    public static void addMissingMessages() {
        FileConfiguration messages = Files.MESSAGES.getFile();
        boolean saveFile = false;

        for (MessageManager message : values()) {
            if (!messages.contains("Messages." + message.getPath())) {
                saveFile = true;

                if (message.getDefaultMessage() != null) {
                    messages.set("Messages." + message.getPath(), message.getDefaultMessage());
                } else {
                    messages.set("Messages." + message.getPath(), message.getDefaultListMessage());
                }
            }
        }

        if (saveFile) {
            Files.MESSAGES.saveFile();
        }
    }

    public static String replacePlaceholders(HashMap<String, String> placeholders, String message) {
        for (String placeholder : placeholders.keySet()) {
            message = message.replaceAll(placeholder, placeholders.get(placeholder))
                    .replaceAll(placeholder.toLowerCase(), placeholders.get(placeholder));
        }

        return message;
    }

    public static List<String> replacePlaceholders(HashMap<String, String> placeholders, List<String> messageList) {
        List<String> newMessageList = new ArrayList<>();

        for (String message : messageList) {
            for (String placeholder : placeholders.keySet()) {
                newMessageList.add(message.replaceAll(placeholder, placeholders.get(placeholder))
                        .replaceAll(placeholder.toLowerCase(), placeholders.get(placeholder)));
            }
        }

        return newMessageList;
    }

    public String getMessage() {
        return getMessage(true);
    }

    public String getMessage(String placeholder, String replacement) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholder, replacement);
        return getMessage(placeholders, true);
    }

    public String getMessage(HashMap<String, String> placeholders) {
        return getMessage(placeholders, true);
    }

    public String getMessageNoPrefix() {
        return getMessage(false);
    }

    public String getMessageNoPrefix(String placeholder, String replacement) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholder, replacement);
        return getMessage(placeholders, false);
    }

    public String getMessageNoPrefix(HashMap<String, String> placeholders) {
        return getMessage(placeholders, false);
    }

    // check if message is blank
    // if message is blank return true
    // if message is not blank return false
    public boolean isBlank() {
        return getMessage(false).equals("");
    }

    private String getMessage(boolean prefix) {
        return getMessage(new HashMap<>(), prefix);
    }

    private String getMessage(HashMap<String, String> placeholders, boolean prefix) {
        String message;
        boolean isList = isList();
        boolean exists = exists();

        if (isList) {
            if (exists) {
                message = utilManager.colorize(convertList(Files.MESSAGES.getFile().getStringList("Messages." + path)));
            } else {
                message = utilManager.colorize(convertList(getDefaultListMessage()));
            }
        } else {
            if (exists) {
                message = utilManager.colorize(Files.MESSAGES.getFile().getString("Messages." + path));
            } else {
                message = utilManager.colorize(getDefaultMessage());
            }
        }

        for (String placeholder : placeholders.keySet()) {
            message = message.replaceAll(placeholder, placeholders.get(placeholder))
                    .replaceAll(placeholder.toLowerCase(), placeholders.get(placeholder));
        }

        if (isList) { // Don't want to add a prefix to a list of messages.
            return utilManager.colorize(message);
        } else { // If the message isn't a list.
            if (prefix) { // If the message needs a prefix.
                return utilManager.getPrefix(message);
            } else { // If the message doesn't need a prefix.
                return utilManager.colorize(message);
            }
        }
    }

    private boolean exists() {
        return Files.MESSAGES.getFile().contains("Messages." + path);
    }

    private boolean isList() {
        if (Files.MESSAGES.getFile().contains("Messages." + path)) {
            return !Files.MESSAGES.getFile().getStringList("Messages." + path).isEmpty();
        } else {
            return defaultMessage == null;
        }
    }

    private String getPath() {
        return path;
    }

    private String getDefaultMessage() {
        return defaultMessage;
    }

    private List<String> getDefaultListMessage() {
        return defaultListMessage;
    }
}