package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.authd.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.authd.network.MinaClientHandler;
import lombok.Getter;
import lombok.Setter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class NetWorkHeader {

    @Getter
    @Setter
    private final NioSocketConnector connector = new NioSocketConnector();
    @Getter
    private final MinaClientHandler minaClientHandler = new MinaClientHandler();

}
