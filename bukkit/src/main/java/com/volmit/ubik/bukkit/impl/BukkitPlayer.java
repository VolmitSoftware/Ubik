package com.volmit.ubik.bukkit.impl;


import com.volmit.ubik.bukkit.BukkitUbik;
import com.volmit.ubik.api.Pos;
import com.volmit.ubik.api.UbikPlayer;
import com.volmit.ubik.api.UbikServer;
import com.volmit.ubik.api.UbikWorld;
import com.volmit.ubik.bukkit.util.FConst;
import lombok.Data;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@Data
public class BukkitPlayer implements UbikPlayer {
    private final Player player;
    private boolean ignoringNextBack;

    public BukkitPlayer(Player player) {
        this.player = player;
        this.ignoringNextBack = false;
    }

    @Override
    public int getGameMode() {
        return player.getGameMode().getValue();
    }

    @Override
    public void setGameMode(int mode) {
        player.setGameMode(GameMode.getByValue(mode));
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public java.util.UUID getUUID() {
        return player.getUniqueId();
    }

    @Override
    public UbikServer getServer() {
        return BukkitUbik.instance;
    }

    @Override
    public UbikWorld getWorld() {
        return new BukkitWorld(player.getWorld());
    }

    @Override
    public Pos getPosition() {
        return BukkitPos.toPos(player.getLocation());
    }

    @Override
    public void teleport(Pos position) {
        player.teleport(BukkitPos.toLocation(position));
        FConst.TELEPORT.send(player);
    }

    @Override
    public void onDisable() {
        UbikPlayer.super.onDisable();
    }
}
