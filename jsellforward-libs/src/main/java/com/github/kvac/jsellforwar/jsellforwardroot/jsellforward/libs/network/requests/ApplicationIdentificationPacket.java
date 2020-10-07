package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.requests;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Client;
import lombok.Getter;

public class ApplicationIdentificationPacket extends Request {

    @Getter
    private Client answered = new Client();
}
