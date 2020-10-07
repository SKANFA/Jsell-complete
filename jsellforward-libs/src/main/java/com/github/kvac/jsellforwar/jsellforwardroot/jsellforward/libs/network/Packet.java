package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Client;
import java.io.Serializable;
import lombok.Getter;

public class Packet implements Serializable {

    @Getter
    private final Client client = new Client();

    @Getter
    private final Route route = new Route();
}
