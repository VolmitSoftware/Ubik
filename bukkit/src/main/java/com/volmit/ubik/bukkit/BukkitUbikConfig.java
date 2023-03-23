package com.volmit.ubik.bukkit;

import art.arcane.amulet.io.IO;
import com.google.gson.Gson;
import com.volmit.ubik.bukkit.util.blackmagic.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

@Getter
public class BukkitUbikConfig {
    private static BukkitUbikConfig config = null;
    private boolean debug = false;
    private boolean splashScreen = true;
    private boolean metrics = true;
    private boolean useGitSync = false;
    private String RepositoryName = "RepositoryName";
    private String RepositoryURL = "RepositoryURL";
    private String clientID = "clientID";

    @Setter
    private boolean verbose = false;

    public static BukkitUbikConfig get() {
        if (config == null) {
            BukkitUbikConfig dummy = new BukkitUbikConfig();
            File l = BukkitUbik.instance.getDataFile("ubik.json");

            if (!l.exists()) {
                try {
                    IO.writeAll(l, new JSONObject(new Gson().toJson(dummy)).toString(4));
                } catch (IOException e) {
                    e.printStackTrace();
                    config = dummy;
                    return dummy;
                }
            }

            try {
                config = new Gson().fromJson(IO.readAll(l), BukkitUbikConfig.class);
                IO.writeAll(l, new JSONObject(new Gson().toJson(config)).toString(4));
            } catch (IOException e) {
                e.printStackTrace();
                config = new BukkitUbikConfig();
            }
        }
        return config;
    }

}
