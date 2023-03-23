package com.volmit.ubik.api;


import java.util.stream.Stream;
import com.volmit.ubik.api.storage.CachedPlayerRepository;

public interface UbikServer {
    CachedPlayerRepository getRepository();

    Stream<UbikPlayer> streamPlayers();

    Stream<UbikWorld> streamWorlds();

    default void enabling() {
        Ubik.server = this;
    }

    default void disabling() {
        streamPlayers().forEach(UbikPlayer::onDisable);
        getRepository().saveAll();
    }

    default UbikWorld getWorld(String world) {
        return streamWorlds().filter(i -> i.getName().equals(world)).findFirst().orElse(null);
    }
}
