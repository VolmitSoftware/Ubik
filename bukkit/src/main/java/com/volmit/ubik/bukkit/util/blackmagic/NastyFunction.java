

package com.volmit.ubik.bukkit.util.blackmagic;

public interface NastyFunction<T, R> {
    R run(T t) throws Throwable;
}
