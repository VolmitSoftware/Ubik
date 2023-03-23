

package com.volmit.ubik.bukkit.util.blackmagic;

import org.bukkit.block.data.BlockData;
import org.bukkit.generator.ChunkGenerator.ChunkData;

import java.util.List;

public interface IPostBlockAccess {
    BlockData getPostBlock(int x, int y, int z, int currentPostX, int currentPostZ, ChunkData currentData);

    void setPostBlock(int x, int y, int z, BlockData d, int currentPostX, int currentPostZ, ChunkData currentData);

    int highestTerrainOrFluidBlock(int x, int z);

    int highestTerrainBlock(int x, int z);

    void updateHeight(int x, int z, int h);

    List<CaveResult> caveFloors(int x, int z);
}
