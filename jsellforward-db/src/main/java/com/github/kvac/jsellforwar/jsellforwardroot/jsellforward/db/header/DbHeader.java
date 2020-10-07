/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.config.DbConfig;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.network.MinaClientHandler;
import java.io.File;
import lombok.Getter;
import lombok.Setter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 *
 * @author jdcs_dev
 */
public class DbHeader {

    private DbHeader() {
    }

    @Getter
    public static final File ROOT_DIR = new File("");

    @Getter
    public static final File configFile = new File(ROOT_DIR, "config.yml");
    @Getter
    @Setter
    private static DbConfig config = new DbConfig();

    @Getter
    @Setter
    private static NioSocketConnector connector = new NioSocketConnector();

    @Getter

    private static final MinaClientHandler minaClientHandler = new MinaClientHandler();
}
