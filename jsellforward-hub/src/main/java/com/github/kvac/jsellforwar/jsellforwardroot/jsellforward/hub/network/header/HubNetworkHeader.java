/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network.HubServer;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network.handler.MinaClientHandler;
import lombok.Getter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author jdcs_dev
 */
public class HubNetworkHeader {

    @Getter
    public final HubServer hubServer = new HubServer();
    @Getter
    public final NioSocketAcceptor acceptor = new NioSocketAcceptor();
    @Getter
    public final MinaClientHandler minaClientHandler = new MinaClientHandler();

}
