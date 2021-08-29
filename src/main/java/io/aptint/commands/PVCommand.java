package io.aptint.commands;

import io.aptint.ProVouchers;
import io.aptint.handlers.MessageHandler;
import io.aptint.handlers.PermissionHandler;
import io.aptint.handlers.TSAVHandler;
import io.aptint.utils.ServerUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PVCommand implements CommandExecutor {

    private final ProVouchers instance = ProVouchers.getBraveVouchers();
    private final TSAVHandler tsavHandler = instance.getTSAVHandler();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission(PermissionHandler.VOUCHER_USER.get())) {
            ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
            return false;
        }

        // Handle command and its arguments.

        // If user is not specifying an argument set, send help menu for a proper syntax.
        if (args.length == 0) {
            // Display help menu in this argument.
            commandSender.sendMessage("This works so far.");
            return true;
        } else if (args[0].equalsIgnoreCase("redeem")) {

            // Check if player has the redeem permission.
            if (!player.hasPermission(PermissionHandler.VOUCHER_USER_REDEEM.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_REDEEM.get());
                return false;
            }
            // TODO: Check if args[1] code exists in the voucher codes file.

            /*
               TODO:
                    - Check if TSA is enabled
                        - Add user to UUID,String hashmap to confirm user.
                        - If user opens new/different voucher, remove old UUID,String entry from TSA hashmap
                            - remove old UUID,String entry from timeout handler as well.
                    - Open voucher, register event.

             */

            return true;
        } else if (args[0].equalsIgnoreCase("confirm")) {

            /*
                TODO:
                    - Check if an entry exists for UUID,String.
                        - Open voucher, register event.
                        - Remove user from UUID,String timeout handler and TSA hashmap.
             */
            return true;
        } else if ((args[0].equalsIgnoreCase("gui") || args[0].equalsIgnoreCase("open"))) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_USER_GUI.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length > 1) {
                if (!player.hasPermission(PermissionHandler.VOUCHER_ADMIN_GUI.get())) {
                    ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_USER_GUI.get());
                }
                return false;
            }
            /*
                TODO:
                    -
             */
            return true;
        } else if (args[0].equalsIgnoreCase("help")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_USER.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 1) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_HELP.get());
                return false;
            }

            if (!player.hasPermission(PermissionHandler.VOUCHER_ADMIN_HELP.get())) {
                // TODO: Display full user help menu.
            } else {
                // TODO: Display full admin help menu.
            }

            return true;
        } else if (args[0].equalsIgnoreCase("preview")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_USER_PREVIEW.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_PREVIEW.get());
                return false;
            }


            return true;
        } else if (args[0].equalsIgnoreCase("info")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_USER_INFO.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            if (args.length != 2) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_INFO.get());
                return false;
            }

            /*
                TODO:
                    - Check to see if <name> voucher exists.
                    - Open GUI containing information on the voucher.
                        - Admin
                            - Status
                            - Expiry
                            - Limit
                            - Used
                            - Creation Date
                        -  Player
                            - Status
                            - Expiry
                            - Limit
                            - Used
             */

            return true;
        } else if (args[0].equalsIgnoreCase("setexpiry")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_ADMIN_SET_EXPIRY.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 3) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_SET_EXPIRY.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("setlimit")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_ADMIN_SET_LIMIT.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 4) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_SET_LIMIT.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("setstatus")) {
            if (player.hasPermission(PermissionHandler.VOUCHER_ADMIN_SET_STATUS.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 3) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_SET_STATUS.get());
                return false;
            }
            return true;
        } else if (args[0].equalsIgnoreCase("award")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_ADMIN_AWARD.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 4) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_AWARD.get());
                return false;
            }

            return true;
        } else if (args[0].equalsIgnoreCase("awardall")) {
            if (!player.hasPermission(PermissionHandler.VOUCHER_ADMIN_AWARD_ALL.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }

            // Check for syntax errors.
            if (args.length != 3) {
                ServerUtil.message(player, MessageHandler.RESOURCE_INVALID_SYNTAX.get() + " " + MessageHandler.VOUCHER_SYNTAX_AWARD_ALL.get());
                return false;
            }
            // TODO: Loop through all players online and give them specified voucher.
            return true;
        } else if (args[0].equalsIgnoreCase("remove")) {
            if (player.hasPermission(PermissionHandler.VOUCHER_ADMIN_REMOVE.get())) {
                ServerUtil.message(player, MessageHandler.COMMAND_ERROR_PERMISSION.get());
                return false;
            }
            return true;
        }

        return false;
    }
}