package com.volmit.ubik.bukkit.commands;

import com.volmit.ubik.bukkit.util.FCommand;
import com.volmit.ubik.bukkit.util.FConst;
import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("uworld")
@Permission("ubik.world")
public class CommandTop implements FCommand {
    @Default
    @Permission("ubik.teleport.top")
    public static void top(CommandSender sender) {
        if (sender instanceof Player p) {
            World world = p.getWorld();
            Location currentLocation = p.getLocation();
            int x = currentLocation.getBlockX();
            int z = currentLocation.getBlockZ();
            int y = world.getHighestBlockYAt(x, z);
            Location highestPoint = new Location(world, x + 0.5, y + 1, z + 0.5);
            p.teleport(highestPoint);
            FConst.success("Teleported to the highest point!").send(sender);
        } else {
            sender.sendMessage("You must be a player to use this command.");
            FConst.error("You must be a player to use this command.").send(sender);
        }
    }
}
