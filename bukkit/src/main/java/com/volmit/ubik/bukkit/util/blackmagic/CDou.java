

package com.volmit.ubik.bukkit.util.blackmagic;

public class CDou {
    private final double max;
    private double number;

    public CDou(double max) {
        number = 0;
        this.max = max;
    }

    public CDou set(double n) {
        number = n;
        circ();
        return this;
    }

    public CDou add(double a) {
        number += a;
        circ();
        return this;
    }

    public CDou sub(double a) {
        number -= a;
        circ();
        return this;
    }

    public double get() {
        return number;
    }

    public void circ() {
        if (number < 0) {
            number = max - (Math.abs(number) > max ? max : Math.abs(number));
        }

        number = number % (max);
    }
}
