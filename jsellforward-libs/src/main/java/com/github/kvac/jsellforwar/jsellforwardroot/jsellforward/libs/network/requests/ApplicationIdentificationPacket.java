package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.requests;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Client;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.Route;
import lombok.Getter;
import lombok.Setter;

public class ApplicationIdentificationPacket extends Request {

    @Getter
    @Setter
    private boolean answer;
    @Getter
    private Client answered = new Client();

    @Getter
    @Setter
    Route.NodeType nodeType;

}
