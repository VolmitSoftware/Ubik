package com.volmit.ubik.bukkit.service;


import com.volmit.ubik.bukkit.BukkitUbik;
import com.volmit.ubik.api.Ubik;
import com.volmit.ubik.bukkit.util.FService;
import com.volmit.ubik.bukkit.impl.BukkitPlayer;
import com.volmit.ubik.bukkit.impl.BukkitPos;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerService implements Listener, FService {
    @Override
    public void start() {
        Bukkit.getPluginManager().registerEvents(this, BukkitUbik.instance);
    }

    @Override
    public void stop() {
        HandlerList.unregisterAll(this);
    }

    @EventHandler
    public void on(PlayerTeleportEvent e) {
        new BukkitPlayer(e.getPlayer()).onTeleport(BukkitPos.toPos(e.getFrom()));
    }

    @EventHandler
    public void on(PlayerQuitEvent e) {
        Ubik.server.getRepository().save(e.getPlayer().getUniqueId());
    }
}
