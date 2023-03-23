package com.volmit.ubik.api.storage;

import com.volmit.ubik.api.data.UbikPlayerData;

import java.io.IOException;
import java.util.UUID;

public interface PlayerRepository {
    void delete(UUID id);

    boolean exists(UUID id);

    UbikPlayerData load(UUID id) throws IOException;

    void save(UUID id, UbikPlayerData player) throws IOException;

    void save(UUID id);
}
