package sh.solsk.provouchers.commands;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sh.solsk.provouchers.ProVouchers;
import sh.solsk.provouchers.managers.PermissionManager;
import sh.solsk.provouchers.managers.UtilManager;
import sh.solsk.provouchers.managers.builtin.CodeManager;
import sh.solsk.provouchers.managers.files.MessageManager;

@Command(value = "provouchers", alias = {"pvouchers", "vouchers"})
public class PVCCommand extends BaseCommand {

    /* TODO:
        PLAYER:
        redeem
        confirm
        gui/open
        help
        preview
        info

       TODO:
        ADMIN:
        setexpire
        setlimit
        setstatus
        remove
        award
        awardall
     */

    private final ProVouchers instance = ProVouchers.getInstance();
    private final UtilManager utilManager = instance.getUtilManager();
    private final CodeManager codeManager = instance.getCodeManager();

    @Default
    @Permission(value = "provouchers.code.user")
    public void onDefault(Player player) {

    }

    @SubCommand("help")
    public void onHelp(Player player) {

    }

    @SubCommand("redeem")
    public void onRedeem(Player player) {

    }

    @SubCommand("gui")
    public void onGui(Player player) {

    }

    @SubCommand("preview")
    public void onPreview(Player player) {

    }

    @SubCommand("info")
    public void onInfo(Player player) {

    }


    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission(PermissionManager.CODE_USER.get())) {
            utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
            return false;
        }

        // Handle command and its arguments.

        // If user is not specifying an argument set, send help menu for proper syntax.
        if (args.length == 0) {
            // TODO: Display help menu in this argument.
            commandSender.sendMessage("This works so far.");
            return true;
        } else if (args[0].equalsIgnoreCase("redeem")) {

            // Check if player has the redeem permission.
            if (!player.hasPermission(PermissionManager.CODE_USER_REDEEM.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 2) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }
            // TODO: Check if args[1] code exists in the voucher codes file.

            // TODO: Two Step Authentication (TSA)

            if (codeManager.isTwoStepEnabled()) {

                // TODO: Check if TSA timeout is enabled, put in timeout map.
                // Check if the user is already redeeming a key.
                if (codeManager.getTwoStepMap().containsKey(player.getUniqueId())) {
                    // Tell user they're in the process of redeeming a key.
                    utilManager.message(player, MessageManager.CODE_TSA_REDEEMING.getMessage());
                    return false;
                }

                // Put user in TSA map - Prevent code redeeming with more than two codes at once.
                codeManager.getTwoStepMap().put(player.getUniqueId(), args[1]);
            } else {
                // TSA is disabled so redeem code - End of Service (EOS).
                // TODO: Use voucher and fully redeem code.
                return true;
            }


            return true;
        } else if (args[0].equalsIgnoreCase("confirm")) {
            if (!player.hasPermission(PermissionManager.CODE_USER_REDEEM.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 2) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            // TODO: Validate code exists.

            // Check if Two Step Authentication - Code (TSA-C) is enabled.
            if (codeManager.isTwoStepEnabled()) {

                // Check if user wants to cancel their code redeem
                if (args[1].equalsIgnoreCase("cancel")) {
                    if (codeManager.getTwoStepMap().containsKey(player.getUniqueId())) {
                        // Tell user there is no code able to be cancelled.
                        utilManager.message(player, MessageManager.CODE_TSA_EMPTY.getMessage());
                        return false;
                    }

                    // Remove user from TSA-C map due to TSA cancel.
                    codeManager.getTwoStepMap().remove(player.getUniqueId());
                    return true;
                }

                if (!args[1].equalsIgnoreCase(codeManager.getTwoStepMap().get(player.getUniqueId()))) {
                    /* TODO: Tell user code is not the same as the one they are required to confirm. If they'd like
                        they can cancel the code confirmation with /procodes confirm cancel
                     */
                    return false;
                }

                // Verify user has a code to confirm.
                if (!codeManager.getTwoStepMap().containsKey(player.getUniqueId())) {
                    // Tell user there is no code to confirm, please use /procodes redeem <code>
                    utilManager.message(player, MessageManager.CODE_TSA_EMPTY.getMessage());
                    return false;
                }

                // TODO: Confirm voucher usage and redeem to user.
                // Code is redeemed, remove user from TSA-C map so they can redeem a new code.
                codeManager.getTwoStepMap().remove(player.getUniqueId());
            } else {
                // Tell user TSA-C is disabled, do nothing else. /vcodes redeem <code>
                utilManager.message(player, MessageManager.CODE_TSA_DISABLED.getMessage());
                return false;
            }

            return true;
        } else if ((args[0].equalsIgnoreCase("gui") || args[0].equalsIgnoreCase("open"))) {
            if (!player.hasPermission(PermissionManager.CODE_USER_GUI.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length > 1) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("help")) {
            if (!player.hasPermission(PermissionManager.CODE_USER.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            //Validate arguments for syntax errors.
            if (args.length != 1) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("preview")) {
            if (!player.hasPermission(PermissionManager.CODE_USER_PREVIEW.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 2) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("info")) {
            if (!player.hasPermission(PermissionManager.CODE_USER_INFO.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            if (args.length != 2) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }
            return true;
        } else if (args[0].equalsIgnoreCase("setexpiry")) {
            if (!player.hasPermission(PermissionManager.CODE_ADMIN_SET_EXPIRY.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 3) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("setlimit")) {
            if (!player.hasPermission(PermissionManager.CODE_ADMIN_SET_LIMIT.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 4) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("setstatus")) {
            if (player.hasPermission(PermissionManager.CODE_ADMIN_SET_STATUS.get())) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 3) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }
            return true;
        } else if (args[0].equalsIgnoreCase("award")) {
            if (!player.hasPermission(PermissionManager.CODE_ADMIN_AWARD.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 4) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("awardall")) {
            if (!player.hasPermission(PermissionManager.CODE_ADMIN_AWARD_ALL.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 3) {
                utilManager.message(player, MessageManager.RESOURCE_INVALID_SYNTAX.getMessage() + " " + MessageManager.CODE_SYNTAX_INFO.getMessage());
                return false;
            }
            // TODO: Loop through all players online and give them specified voucher.
            return true;
        } else if (args[0].equalsIgnoreCase("remove")) {
            if (player.hasPermission(PermissionManager.CODE_ADMIN_REMOVE.get())) {
                utilManager.message(player, MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            }
            return true;
        }

        return false;
    }
}