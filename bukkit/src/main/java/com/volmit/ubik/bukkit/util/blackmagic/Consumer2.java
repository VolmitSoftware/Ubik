

package com.volmit.ubik.bukkit.util.blackmagic;

@SuppressWarnings("hiding")
@FunctionalInterface
public interface Consumer2<A, B> {
    void accept(A a, B b);
}
