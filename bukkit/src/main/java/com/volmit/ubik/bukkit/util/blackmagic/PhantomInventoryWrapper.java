 

package com.volmit.ubik.bukkit.util.blackmagic;

import org.bukkit.inventory.Inventory;

/**
 * Wrapper on top of the bukkit inventory api
 *
 * @author cyberpwn
 */
public interface PhantomInventoryWrapper extends Inventory {
    /**
     * Does the given inventory have any space?
     *
     * @return true if it has space for at least one more slot.
     */
    boolean hasSpace();

    /**
     * Get how many air slots exist (empty slots)
     *
     * @return the number of slots empty (0 if full)
     */
    int getSlotsLeft();
}