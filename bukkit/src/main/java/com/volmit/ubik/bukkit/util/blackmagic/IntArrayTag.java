 

package com.volmit.ubik.bukkit.util.blackmagic;

import java.util.Arrays;

/**
 * The <code>TAG_Int_Array</code> tag.
 *
 * @author Neil Wightman
 */
public final class IntArrayTag extends Tag {

    /**
     * The value.
     */
    private final int[] value;

    /**
     * Creates the tag.
     *
     * @param name  The name.
     * @param value The value.
     */
    public IntArrayTag(String name, int[] value) {
        super(name);
        this.value = value;
    }

    @Override
    public int[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        String name = getName();
        String append = "";
        if (name != null && !name.equals("")) {
            append = "(\"" + this.getName() + "\")";
        }
        return "TAG_Int_Array" + append + ": " + Arrays.toString(value);
    }

}
