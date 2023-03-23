package com.volmit.ubik.api;

import java.io.File;
import java.util.UUID;
import java.util.stream.Stream;

public interface UbikWorld {
    String getName();

    UUID getUUID();

    File getFolder();

    Stream<UbikPlayer> streamPlayers();
}
