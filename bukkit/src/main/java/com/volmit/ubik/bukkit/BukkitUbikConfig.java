import art.arcane.amulet.io.IO;
import com.google.gson.Gson;
import com.volmit.ubik.bukkit.BukkitUbik;
import com.volmit.ubik.bukkit.util.blackmagic.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
@Getter
public class BukkitUbikConfig {
    private static BukkitUbikConfig config = null;
    public boolean debug = false;
    public boolean splashScreen = true;
    private boolean metrics = true;
    private boolean useSql = false;


    @Setter
    private boolean verbose = false;

    public static BukkitUbikConfig get() {
        if (config == null) {
            BukkitUbikConfig dummy = new BukkitUbikConfig();
            File l = BukkitUbik.instance.getDataFile("Ubik", "Ubuik.json");


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


    @Getter
    public static class SqlSettings {
        private String host = "localhost";
        private int port = 1337;
        private String database = "adapt";
        private String username = "user";
        private String password = "password";
    }

}
