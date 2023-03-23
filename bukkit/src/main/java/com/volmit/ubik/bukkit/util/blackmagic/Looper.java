 

package com.volmit.ubik.bukkit.util.blackmagic;

import  com.volmit.ubik.bukkit.BukkitUbik;

public abstract class Looper extends Thread {
    public void run() {
        while (!interrupted()) {
            try {
                long m = loop();

                if (m < 0) {
                    break;
                }

                Thread.sleep(m);
            } catch (InterruptedException e) {
                break;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        BukkitUbik.info("Thread " + getName() + " Shutdown.");
    }

    protected abstract long loop();
}
