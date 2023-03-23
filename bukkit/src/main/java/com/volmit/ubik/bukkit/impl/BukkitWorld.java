package com.volmit.ubik.bukkit.impl;

import com.volmit.ubik.api.UbikWorld;
import lombok.Data;

@Data
public class BukkitWorld implements UbikWorld {
    private final org.bukkit.World world;

    public BukkitWorld(org.bukkit.World world) {
        this.world = world;
    }

    @Override
    public String getName() {
        return world.getName();
    }

    @Override
    public java.util.UUID getUUID() {
        return world.getUID();
    }

    @Override
    public java.io.File getFolder() {
        return world.getWorldFolder();
    }

    @Override
    public java.util.stream.Stream<com.volmit.ubik.api.UbikPlayer> streamPlayers() {
        return world.getPlayers().stream().map(BukkitPlayer::new);
    }
}
