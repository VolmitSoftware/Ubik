 

package com.volmit.ubik.bukkit.util.blackmagic;

import lombok.Builder;
import lombok.Getter;

@DontObfuscate
@Getter
@Builder
public class BoardSettings {
    @DontObfuscate
    private BoardProvider boardProvider;

    @DontObfuscate
    private ScoreDirection scoreDirection;
}
