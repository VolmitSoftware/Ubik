

package com.volmit.ubik.bukkit.util.blackmagic;

import lombok.Value;

@Value
public class CarveResult {
    private final int surface;
    private final int ceiling;

    public int getHeight() {
        return ceiling - surface;
    }
}
