package com.volmit.ubik.bukkit;

import com.volmit.ubik.api.UbikPlayer;
import com.volmit.ubik.api.UbikServer;
import com.volmit.ubik.api.UbikWorld;
import com.volmit.ubik.api.storage.CachedPlayerRepository;
import com.volmit.ubik.api.storage.FilePlayerRepository;
import com.volmit.ubik.bukkit.commands.CommandTop;
import com.volmit.ubik.bukkit.impl.BukkitPlayer;
import com.volmit.ubik.bukkit.impl.BukkitWorld;
import com.volmit.ubik.bukkit.service.PlayerService;
import com.volmit.ubik.bukkit.util.C;
import com.volmit.ubik.bukkit.util.FCommand;
import com.volmit.ubik.bukkit.util.FService;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIConfig;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BukkitUbik extends JavaPlugin implements UbikServer {
    public static BukkitUbik instance;
    public static BukkitAudiences audiences;
    private final List<FService> services = new ArrayList<>();
    private final List<FCommand> commands = new ArrayList<>();
    private CachedPlayerRepository repository;


    @Override
    public void onLoad() {
        // https://commandapi.jorel.dev/8.7.0/shading.html#loading
        CommandAPI.onLoad(new CommandAPIConfig().verboseOutput(false));
    }

    @Override
    public void onEnable() {
        enabling();
        instance = this;
        CommandAPI.onEnable(this);
        repository = new CachedPlayerRepository(new FilePlayerRepository(new File(getDataFolder(), "playerdata")));
        audiences = BukkitAudiences.create(this);
        registerService(new PlayerService());
        //Gamemode

        //Items

        //Positions
        registerCommand(new CommandTop());

        //Time & Weather

        //Utility


        info("All Ubik Commands Registered!");
        splashscreen();
    }

    @Override
    public void onDisable() {
        disabling();
        CommandAPI.onDisable();
        services.forEach(FService::stop);
    }


    private void registerCommand(FCommand command) {
        commands.add(command);
        CommandAPI.registerCommand(command.getClass());
    }

    private void registerService(FService service) {
        services.add(service);
        service.start();
    }

    @Override
    public CachedPlayerRepository getRepository() {
        return repository;
    }

    @Override
    public Stream<UbikPlayer> streamPlayers() {
        return getServer().getOnlinePlayers().stream().map(BukkitPlayer::new);
    }

    @Override
    public Stream<UbikWorld> streamWorlds() {
        return getServer().getWorlds().stream().map(BukkitWorld::new);
    }

    public static void actionbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
    }

    public static void warn(String string) {
        msg(C.YELLOW + string);
    }

    public static void error(String string) {
        msg(C.RED + string);
    }

    public static void info(String string) {
        msg(C.WHITE + string);
    }

    public static void msg(String string) {
        try {
            if (instance == null) {
                System.out.println("[Ubik]: " + string);
                return;
            }

            String msg = C.GRAY + "[" + C.GOLD + "Ubik" + C.GRAY + "]: " + string;
            Bukkit.getConsoleSender().sendMessage(msg);
        } catch (Throwable e) {
            System.out.println("[Ubik]: " + string);
        }
    }

    public File getDataFile(String... strings) {
        List<String> s = new ArrayList<>();
        s.add(strings);
        File f = new File(getDataFolder(), s.toString(File.separator));
        f.getParentFile().mkdirs();
        return f;
    }

    public File getDataFolder(String... strings) {
        if (strings.length == 0) {
            return super.getDataFolder();
        }

        List<String> s = new ArrayList<>();
        s.add(strings);
        File f = new File(getDataFolder(), s.toString(File.separator));
        f.mkdirs();

        return f;
    }

    public File getDataFolderList(String pre, String[] strings) {
        List<String> v = new ArrayList<>();
        v.add(strings);
        v.add(0, pre);
        File f = new File(getDataFolder(), v.toString(File.separator));
        f.mkdirs();

        return f;
    }

    private static void splashscreen() {
        info("\n" +
                "██╗   ██╗██████╗ ██╗██╗  ██╗\n" +
                "██║   ██║██╔══██╗██║██║ ██╔╝\n" +
                "██║   ██║██████╔╝██║█████╔╝ \n" +
                "██║   ██║██╔══██╗██║██╔═██╗ \n" +
                "╚██████╔╝██████╔╝██║██║  ██╗\n" +
                " ╚═════╝ ╚═════╝ ╚═╝╚═╝  ╚═╝\n");
    }

}
