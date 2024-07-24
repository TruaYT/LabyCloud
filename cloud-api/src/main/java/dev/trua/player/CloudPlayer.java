package dev.trua.player;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public final class CloudPlayer {

    private String uniqueId;
    private String playerName;
    private String proxyServer;
    private String server;
}
