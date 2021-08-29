package io.aptint.utils;

import io.aptint.handlers.VersionHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ServerUtil {

    public static void message(Player player, String message) {
        player.sendMessage(colorize(message));
    }

    public static void message(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public static String colorize(String toColorize) {
        return ChatColor.translateAlternateColorCodes('&', toColorize);
    }

    public static ItemStack getItemInHand(Player player) {
        if (VersionHandler.isNewerThan(VersionHandler.v1_8_R3)) {
            return player.getInventory().getItemInMainHand();
        }
        return player.getItemInHand(); // TODO: Add v1.8 - v1.16 support.
    }

}
