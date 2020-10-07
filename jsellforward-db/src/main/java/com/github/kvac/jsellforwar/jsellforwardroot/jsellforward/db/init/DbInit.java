package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.config.DbConfig;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.header.DbHeader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.Security;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbInit {

    @Getter
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        DbInit di = new DbInit();
        try {
            di.initConfig();
            di.initNetwork();
            di.init();
        } catch (Exception e) {
            di.logger.error("INIT", e);
        }
    }

    private void initConfig() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        if (!DbHeader.getConfigFile().exists()) {
            DbHeader.getConfigFile().getParentFile().mkdirs();
            mapper.writeValue(DbHeader.getConfigFile(), DbHeader.getConfig());
        }
        DbHeader.setConfig(mapper.readValue(DbHeader.getConfigFile(), DbConfig.class));
    }

    private void init() {
        logger.info("Security Provider init");
        EdDSASecurityProvider edsasp = new EdDSASecurityProvider();
        BouncyCastleProvider bcp = new BouncyCastleProvider();
        Security.addProvider(edsasp);
        Security.addProvider(bcp);
        logger.info("Security Provider inited");
    }

    private void initNetwork() {
        initConnecionHub();
        connectToHub();
    }

    private void initConnecionHub() {
        ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();
        objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);
        objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);
        DbHeader.getConnector().getFilterChain().addLast("codec-Serializable", new ProtocolCodecFilter(objectSerializationCodecFactory));
        DbHeader.getConnector().setConnectTimeoutMillis(30000l);
        DbHeader.getConnector().setHandler(DbHeader.getMinaClientHandler());
    }

    private void connectToHub() {
        for (;;) {
            try {
                ConnectFuture future = DbHeader.getConnector().connect(
                        new InetSocketAddress(
                                DbHeader.getConfig().getHubHost(),
                                DbHeader.getConfig().getHubPort()
                        )
                );
                future.awaitUninterruptibly();
                future.getSession();
                break;
            } catch (RuntimeIoException e) {
                //AppControl.setConnected(false);
                logger.warn("Failed to connect." + e.getMessage() + "[" + e.getCause().getMessage() + "]");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception ee) {
                    e.getClass();//IGNORE
                }
            }
        }
        //AppControl.setConnected(true);
        logger.info("Connect to HUB");
    }

}
