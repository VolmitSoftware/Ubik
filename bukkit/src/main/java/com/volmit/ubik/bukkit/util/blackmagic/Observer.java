 

package com.volmit.ubik.bukkit.util.blackmagic;

@FunctionalInterface
public interface Observer<T> {
    void onChanged(T from, T to);
}
