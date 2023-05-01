package sh.solsk.provouchers.events;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import sh.solsk.provouchers.ProVouchers;
import sh.solsk.provouchers.api.Voucher;

public class VoucherInteractEvent implements Listener {

    // Check to see if user has more than one of a voucher. Run them separately, or all together if using shift + right click
    // if ((event.getItem() != null) && event.getItem().getAmount() > 1) return;

    private final ProVouchers instance = ProVouchers.getInstance();
    private final TSAVHandler tsavHandler = instance.getTSAVHandler();

    @EventHandler
    public void onVoucherInteractEvent(PlayerInteractEvent event) {

        // Get the item in the users hand.
        ItemStack itemStack = event.getItem();

        Player player = event.getPlayer();
        Action action = event.getAction();

        // Ensure item isn't null or air.
        if (itemStack != null && itemStack.getType() != Material.AIR) {
            // If version is newer than 1.8.3, ensure the item isn't in the off-hand.
            if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
                //if (voucher != null && !voucher.isEdible()) {}
                // All conditions have been met, get the voucher from the item in hand..
                Voucher voucher = null; // = Voucher.getVoucherFromItem(itemStack);

                // TODO: TSAV

                // Check if TSAV is enabled.
                if (tsavHandler.getTSAEnabled()) {
                    // Check if the user is already opening a voucher.
                    if (tsavHandler.getTSAMap().containsKey(player.getUniqueId())) {
                        /* TODO: Check if new voucher is same as TSAV voucher.
                            Use NBT data to compare the two.
                         */
                        // if(tsavHandler.getTSAMap().get(player.getUniqueId()).)
                        // TODO: Tell user they're already opening a voucher that needs to be confirmed.
                        return;
                    } else {
                        // TODO: Open voucher and add to TSAV.
                        tsavHandler.getTSAMap().put(player.getUniqueId(), voucher);
                    }

                }
            }
        }
    }
}