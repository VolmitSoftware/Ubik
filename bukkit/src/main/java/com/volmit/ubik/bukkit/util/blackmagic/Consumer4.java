

package com.volmit.ubik.bukkit.util.blackmagic;

@SuppressWarnings("hiding")
@FunctionalInterface
public interface Consumer4<A, B, C, D> {
    void accept(A a, B b, C c, D d);
}
