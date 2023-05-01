package sh.solsk.provouchers.managers;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import sh.solsk.provouchers.ProVouchers;
import sh.solsk.provouchers.managers.files.FileManager.Files;
import sh.solsk.provouchers.managers.files.MessageManager;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilManager {

    public final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F\\d]{6}");
    private final ProVouchers instance = ProVouchers.getInstance();

    public void message(Player player, String message) {
        player.sendMessage(colorize(message));
    }

    public void message(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public void removeItem(ItemStack item, Player player) {
        if (item.getAmount() <= 1) {
            player.getInventory().removeItem(item);
        } else if (item.getAmount() > 1) {
            item.setAmount(item.getAmount() - 1);
        }
    }

    public String getPrefix(String message) {
        return colorize(Files.CONFIG.getFile().getString("Settings.Prefix") + message);
    }

    public String colorize(String message) {
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuilder buffer = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.valueOf(matcher.group()).toString());
        }

        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
    }

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public boolean isInt(CommandSender sender, String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            HashMap<String, String> placeholders = new HashMap<>();
            placeholders.put("%Arg%", s);
            placeholders.put("%arg%", s);
            sender.sendMessage(MessageManager.NAN.getMessage(placeholders));
            return false;
        }

        return true;
    }

    public boolean isOnline(CommandSender sender, String name) {
        for (Player player : instance.getServer().getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) return true;
        }

        sender.sendMessage(MessageManager.NOT_ONLINE.getMessage());
        return false;
    }

    public boolean hasPermission(Player player, String perm) {
        if (!player.hasPermission("provouchers." + perm)) {
            player.sendMessage(MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
            return false;
        }

        return true;
    }

    public boolean hasPermission(CommandSender sender, String perm) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("provouchers." + perm)) {
                player.sendMessage(MessageManager.COMMAND_ERROR_PERMISSION.getMessage());
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean isInventoryFull(Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

    public Color getColor(String color) {
        if (color != null) {
            switch (color.toUpperCase()) {
                case "AQUA" -> {
                    return Color.AQUA;
                }
                case "BLACK" -> {
                    return Color.BLACK;
                }
                case "BLUE" -> {
                    return Color.BLUE;
                }
                case "FUCHSIA" -> {
                    return Color.FUCHSIA;
                }
                case "GRAY" -> {
                    return Color.GRAY;
                }
                case "GREEN" -> {
                    return Color.GREEN;
                }
                case "LIME" -> {
                    return Color.LIME;
                }
                case "MAROON" -> {
                    return Color.MAROON;
                }
                case "NAVY" -> {
                    return Color.NAVY;
                }
                case "OLIVE" -> {
                    return Color.OLIVE;
                }
                case "ORANGE" -> {
                    return Color.ORANGE;
                }
                case "PURPLE" -> {
                    return Color.PURPLE;
                }
                case "RED" -> {
                    return Color.RED;
                }
                case "SILVER" -> {
                    return Color.SILVER;
                }
                case "TEAL" -> {
                    return Color.TEAL;
                }
                case "WHITE" -> {
                    return Color.WHITE;
                }
                case "YELLOW" -> {
                    return Color.YELLOW;
                }
            }

            try {
                String[] rgb = color.split(",");
                return Color.fromRGB(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
            } catch (Exception ignore) {
            }
        }

        return Color.WHITE;
    }

    public boolean isSimilar(ItemStack one, ItemStack two) {
        if (one.getType() == two.getType()) {
            if (one.hasItemMeta()) {
                if (one.getItemMeta().hasDisplayName()) {
                    if (one.getItemMeta().getDisplayName().equalsIgnoreCase(two.getItemMeta().getDisplayName())) {
                        if (one.getItemMeta().hasLore()) {
                            if (one.getItemMeta().getLore().size() == two.getItemMeta().getLore().size()) {
                                int i = 0;

                                for (String lore : one.getItemMeta().getLore()) {
                                    if (!lore.equals(two.getItemMeta().getLore().get(i))) {
                                        return false;
                                    }

                                    i++;
                                }

                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

}
