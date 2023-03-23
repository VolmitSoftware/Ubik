

package com.volmit.ubik.bukkit.util.blackmagic;

@FunctionalInterface
public interface NoiseInjector {
    double[] combine(double src, double value);
}
