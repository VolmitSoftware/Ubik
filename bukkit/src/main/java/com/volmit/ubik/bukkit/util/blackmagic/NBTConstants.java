

package com.volmit.ubik.bukkit.util.blackmagic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Changes : Neil Wightman - Support 19133 Tag_Int_Array tag
 */

/**
 * A class which holds constant values.
 *
 * @author Graham Edgecombe
 */
public final class NBTConstants {

    /**
     * The character set used by NBT (UTF-8).
     */
    public static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * Tag type constants.
     */
    public static final int TYPE_END = 0,
            TYPE_BYTE = 1,
            TYPE_SHORT = 2,
            TYPE_INT = 3,
            TYPE_LONG = 4,
            TYPE_FLOAT = 5,
            TYPE_DOUBLE = 6,
            TYPE_BYTE_ARRAY = 7,
            TYPE_STRING = 8,
            TYPE_LIST = 9,
            TYPE_COMPOUND = 10,
            TYPE_INT_ARRAY = 11;

    /**
     * Default private constructor.
     */
    private NBTConstants() {

    }

}
