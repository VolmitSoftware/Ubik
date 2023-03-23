

package com.volmit.ubik.bukkit.util.blackmagic;

public interface IRare {
    static int get(Object v) {
        return v instanceof IRare ? ((IRare) v).getRarity() : 1;
    }

    int getRarity();
}
