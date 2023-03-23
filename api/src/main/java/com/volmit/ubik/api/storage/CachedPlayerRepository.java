package com.volmit.ubik.api.storage;


import com.volmit.ubik.api.data.UbikPlayerData;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;
import java.util.UUID;

public class CachedPlayerRepository implements PlayerRepository {
    private final PlayerRepository delegate;
    private final Map<UUID, UbikPlayerData> cache;

    public CachedPlayerRepository(PlayerRepository delegate) {
        this.delegate = delegate;
        this.cache = new HashMap<>();
    }

    public void saveAll() {
        for(UUID i : cache.keySet()) {
            try {
                delegate.save(i, cache.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        cache.clear();
    }

    @Override
    public void delete(UUID id) {
        cache.remove(id);
        delegate.delete(id);
    }

    @Override
    public boolean exists(UUID id) {
        return cache.containsKey(id) || delegate.exists(id);
    }

    @Override
    public UbikPlayerData load(UUID id) {
        return cache.computeIfAbsent(id, (i) -> {
            try {
                return delegate.load(id);
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void save(UUID id, UbikPlayerData player) throws IOException {
        delegate.save(id, player);
    }

    @Override
    public void save(UUID id) {
        if(cache.containsKey(id)) {
            try {
                delegate.save(id, cache.get(id));
            } catch (IOException e) {
                e.printStackTrace();
            }

            cache.remove(id);
        }
    }
}
