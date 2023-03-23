 

package com.volmit.ubik.bukkit.util.blackmagic;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({PARAMETER, TYPE, FIELD})
public @interface Desc {
    String value();
}
