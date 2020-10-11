package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.configs;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.Route;
import java.util.UUID;
import lombok.Getter;

public class AuthDConfig {

    @Getter
    private final String id = UUID.randomUUID().toString();
    @Getter
    private static final Route.NodeType NODE_TYPE = Route.NodeType.AUTHD;
    @Getter
    HubConfig hubConfig = new HubConfig();
}
