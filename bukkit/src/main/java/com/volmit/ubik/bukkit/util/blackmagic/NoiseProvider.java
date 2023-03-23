

package com.volmit.ubik.bukkit.util.blackmagic;

@FunctionalInterface
public interface NoiseProvider {
    double noise(double x, double z);
}