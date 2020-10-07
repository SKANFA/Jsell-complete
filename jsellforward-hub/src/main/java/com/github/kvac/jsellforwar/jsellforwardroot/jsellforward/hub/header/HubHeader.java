/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.config.HubConfig;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network.handler.MinaClientHandler;
import java.io.File;
import lombok.Getter;
import lombok.Setter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author jdcs_dev
 */
public class HubHeader {

    private HubHeader() {
    }
    @Getter
    public static final File ROOT_DIR = new File("");

    @Getter
    public static final File configFile = new File(ROOT_DIR, "config.yml");

    @Getter
    @Setter
    private static HubConfig config = new HubConfig();

    public static final NioSocketAcceptor acceptor = new NioSocketAcceptor();
    public static final MinaClientHandler minaClientHandler = new MinaClientHandler();

}
