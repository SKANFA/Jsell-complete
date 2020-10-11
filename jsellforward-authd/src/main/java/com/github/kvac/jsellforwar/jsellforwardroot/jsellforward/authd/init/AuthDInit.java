package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.authd.init;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.authd.header.AuthdHeader;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthDInit {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        AuthDInit authDInit = new AuthDInit();
        authDInit.initConfig();
        authDInit.initNetWork();
    }

    private void initConfig() {
        //
    }

    private void initNetWork() {
        //
        initConnecionHub();
        connectToHub();
    }

    private void initConnecionHub() {
        ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();
        objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);
        objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);
        AuthdHeader.getNetWorkHeader().getConnector().getFilterChain().addLast("codec-Serializable", new ProtocolCodecFilter(objectSerializationCodecFactory));
        AuthdHeader.getNetWorkHeader().getConnector().setConnectTimeoutMillis(30000l);
        AuthdHeader.getNetWorkHeader().getConnector().setHandler(AuthdHeader.getNetWorkHeader().getMinaClientHandler());
    }

    private void connectToHub() {
        for (;;) {
            try {
                ConnectFuture future = AuthdHeader.getNetWorkHeader().getConnector().connect(
                        new InetSocketAddress(
                                AuthdHeader.getConfig().getHubConfig().getHubHost(),
                                AuthdHeader.getConfig().getHubConfig().getHubPort()
                        )
                );
                future.awaitUninterruptibly();
                future.getSession();
                break;
            } catch (RuntimeIoException e) {
                logger.warn("Failed to connect." + e.getMessage() + "[" + e.getCause().getMessage() + "]");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception ee) {
                    e.getClass();//IGNORE
                }
            }
        }
        logger.info("Connected to HUB");
    }
}
