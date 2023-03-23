package com.volmit.ubik.api.storage;

import com.google.gson.Gson;
import com.volmit.ubik.api.data.UbikPlayerData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class FilePlayerRepository implements PlayerRepository {
    private final File folder;

    public FilePlayerRepository(File folder) {
        this.folder = folder;
        folder.mkdir();
    }

    private File fileFor(UUID id) {
        return new File(folder, id.toString() + ".json");
    }

    @Override
    public void delete(UUID id) {
        File f = fileFor(id);
        if(f.exists()) {
            f.delete();
        }
    }

    @Override
    public boolean exists(UUID id) {
        return fileFor(id).exists();
    }

    @Override
    public UbikPlayerData load(UUID id) throws IOException {
        File f = fileFor(id);
        if(f.exists()) {
            return new Gson().fromJson(Files.readString(f.toPath()), UbikPlayerData.class);
        }

        return new UbikPlayerData();
    }

    @Override
    public void save(UUID id, UbikPlayerData player) throws IOException {
        File f = fileFor(id);
        f.getParentFile().mkdirs();
        Files.writeString(f.toPath(), new Gson().toJson(player));
    }

    @Override
    public void save(UUID id) {

    }
}
