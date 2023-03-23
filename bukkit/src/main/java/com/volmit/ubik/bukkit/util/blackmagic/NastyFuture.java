 

package com.volmit.ubik.bukkit.util.blackmagic;

public interface NastyFuture<R> {
    R run() throws Throwable;
}
