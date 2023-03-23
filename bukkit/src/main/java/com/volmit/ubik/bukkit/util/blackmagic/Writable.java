

package com.volmit.ubik.bukkit.util.blackmagic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Writable {
    void write(DataOutputStream o) throws IOException;

    void read(DataInputStream i) throws IOException;
}
