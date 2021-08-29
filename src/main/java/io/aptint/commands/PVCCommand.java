package io.aptint.commands;

import io.aptint.ProVouchers;
import io.aptint.handlers.MessageHandler;
import io.aptint.handlers.PermissionHandler;
import io.aptint.utils.ServerUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PVCCommand implements CommandExecutor {

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

    private static final ProVouchers instance = ProVouchers.getBraveVouchers();
    private final io.aptint.handlers.TSACHandler TSACHandler = instance.getTSACHandler();

    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission(PermissionHandler.CODE_USER.get())) {
            ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
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
            if (!player.hasPermission(PermissionHandler.CODE_USER_REDEEM.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }
            // TODO: Check if args[1] code exists in the voucher codes file.

            // TODO: Two Step Authentication (TSA)

            if (TSACHandler.getTSAEnabled()) {

                // TODO: Check if TSA timeout is enabled, put in timeout map.
                // Check if the user is already redeeming a key.
                if (TSACHandler.getTSAMap().containsKey(player.getUniqueId())) {
                    // Tell user they're in the process of redeeming a key.
                    ServerUtil.message(player, MessageHandler.CODE_TSA_REDEEMING.get());
                    return false;
                }

                // Put user in TSA map - Prevent code redeeming with more than two codes at once.
                TSACHandler.getTSAMap().put(player.getUniqueId(), args[1]);
            } else {
                // TSA is disabled so redeem code - End of Service (EOS).
                // TODO: Use voucher and fully redeem code.
                return true;
            }


            return true;
        } else if (args[0].equalsIgnoreCase("confirm")) {
            if (!player.hasPermission(PermissionHandler.CODE_USER_REDEEM.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            // TODO: Validate code exists.

            // Check if Two Step Authentication - Code (TSA-C) is enabled.
            if (TSACHandler.getTSAEnabled()) {

                // Check if user wants to cancel their code redeem
                if (args[1].equalsIgnoreCase("cancel")) {
                    if (TSACHandler.getTSAMap().containsKey(player.getUniqueId())) {
                        // Tell user there is no code able to be cancelled.
                        ServerUtil.message(player, MessageHandler.CODE_TSA_EMPTY.get());
                        return false;
                    }

                    // Remove user from TSA-C map due to TSA cancel.
                    TSACHandler.getTSAMap().remove(player.getUniqueId());
                    return true;
                }

                if (!args[1].equalsIgnoreCase(TSACHandler.getTSAMap().get(player.getUniqueId()))) {
                    /* TODO: Tell user code is not the same as the one they are required to confirm. If they'd like
                        they can cancel the code confirmation with /bravecodes confirm cancel
                     */
                    return false;
                }

                // Verify user has a code to confirm.
                if (!TSACHandler.getTSAMap().containsKey(player.getUniqueId())) {
                    // Tell user there is no code to confirm, please use /bravecodes redeem <code>
                    ServerUtil.message(player, MessageHandler.CODE_TSA_EMPTY.get());
                    return false;
                }

                // TODO: Confirm voucher usage and redeem to user.
                // Code is redeemed, remove user from TSA-C map so they can redeem a new code.
                TSACHandler.getTSAMap().remove(player.getUniqueId());
            } else {
                // Tell user TSA-C is disabled, do nothing else. /vcodes redeem <code>
                ServerUtil.message(player, MessageHandler.CODE_TSA_DISABLED.get());
                return false;
            }

            return true;
        } else if ((args[0].equalsIgnoreCase("gui") || args[0].equalsIgnoreCase("open"))) {
            if (!player.hasPermission(PermissionHandler.CODE_USER_GUI.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length > 1) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("help")) {
            if (!player.hasPermission(PermissionHandler.CODE_USER.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            //Validate arguments for syntax errors.
            if (args.length != 1) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("preview")) {
            if (!player.hasPermission(PermissionHandler.CODE_USER_PREVIEW.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("info")) {
            if (!player.hasPermission(PermissionHandler.CODE_USER_INFO.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }
            return true;
        } else if (args[0].equalsIgnoreCase("setexpiry")) {
            if (!player.hasPermission(PermissionHandler.CODE_ADMIN_SET_EXPIRY.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 3) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("setlimit")) {
            if (!player.hasPermission(PermissionHandler.CODE_ADMIN_SET_LIMIT.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 4) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("setstatus")) {
            if (player.hasPermission(PermissionHandler.CODE_ADMIN_SET_STATUS.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Validate arguments for syntax errors.
            if (args.length != 3) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }
            return true;
        } else if (args[0].equalsIgnoreCase("award")) {
            if (!player.hasPermission(PermissionHandler.CODE_ADMIN_AWARD.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 4) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("awardall")) {
            if (!player.hasPermission(PermissionHandler.CODE_ADMIN_AWARD_ALL.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 3) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.CODE_SYNTAX_INFO.get());
                return false;
            }
            // TODO: Loop through all players online and give them specified voucher.
            return true;
        } else if (args[0].equalsIgnoreCase("remove")) {
            if (player.hasPermission(PermissionHandler.CODE_ADMIN_REMOVE.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }
            return true;
        }

        return false;
    }
}