 

package com.volmit.ubik.bukkit.util.blackmagic;

import org.bukkit.Bukkit;

public class Info {
    public static String getPortIP() {
        return Bukkit.getPort() + Bukkit.getIp();
    }
}
