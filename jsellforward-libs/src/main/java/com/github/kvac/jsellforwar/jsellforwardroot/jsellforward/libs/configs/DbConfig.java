package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.configs;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.Route.NodeType;
import java.util.UUID;
import lombok.Getter;

public class DbConfig {

    @Getter
    private final String id = UUID.randomUUID().toString();
    @Getter
    private static final NodeType NODE_TYPE = NodeType.DB;
    @Getter
    HubConfig hubConfig = new HubConfig();
}
