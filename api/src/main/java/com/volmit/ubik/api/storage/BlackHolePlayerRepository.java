package com.volmit.ubik.api.storage;

import com.volmit.ubik.api.data.UbikPlayerData;

import java.io.IOException;
import java.util.UUID;

public class BlackHolePlayerRepository implements PlayerRepository {
    @Override
    public void delete(UUID id) {

    }

    @Override
    public boolean exists(UUID id) {
        return false;
    }

    @Override
    public UbikPlayerData load(UUID id) throws IOException {
        return new UbikPlayerData();
    }

    @Override
    public void save(UUID id, UbikPlayerData player) throws IOException {

    }

    @Override
    public void save(UUID id) {

    }
}
