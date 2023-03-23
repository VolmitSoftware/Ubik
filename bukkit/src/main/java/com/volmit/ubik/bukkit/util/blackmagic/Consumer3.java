 

package com.volmit.ubik.bukkit.util.blackmagic;

@SuppressWarnings("hiding")
@FunctionalInterface
public interface Consumer3<A, B, C> {
    void accept(A a, B b, C c);
}
