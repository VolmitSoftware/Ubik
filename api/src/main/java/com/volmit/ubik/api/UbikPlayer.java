package com.volmit.ubik.api;

import com.volmit.ubik.api.data.UbikPlayerData;

import java.util.UUID;

public interface UbikPlayer {
    default UbikPlayerData getData() {
        return getServer().getRepository().load(getUUID());
    }

    default void onTeleport(Pos pos) {
        if(!getData().isIgnoringNextBackTeleport()) {
            getData().addBack(pos);
        }

        getData().setIgnoringNextBackTeleport(false);
    }

    default boolean goBack() {
        if(!getData().hasBack()) {
            return false;
        }

        getData().setIgnoringNextBackTeleport(true);

        try {
            teleport(getData().popBack());
            return true;
        }

        catch(Throwable e) {
            getData().setIgnoringNextBackTeleport(false);
            return false;
        }
    }

    int getGameMode();

    void setGameMode(int mode);

    String getName();

    UUID getUUID();

    UbikServer getServer();

    UbikWorld getWorld();

    Pos getPosition();

    void teleport(Pos position);

    default void onDisable() {
        Ubik.server.getRepository().save(getUUID());
    }
}
