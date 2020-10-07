package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.header.HubHeader;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HubServer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void init() {
        ObjectSerializationCodecFactory objectSerializationCodecFactory = new ObjectSerializationCodecFactory();
        objectSerializationCodecFactory.setDecoderMaxObjectSize(Integer.MAX_VALUE);
        objectSerializationCodecFactory.setEncoderMaxObjectSize(Integer.MAX_VALUE);
        HubHeader.acceptor.getFilterChain().addLast("codec-Serializable", new ProtocolCodecFilter(objectSerializationCodecFactory));
        HubHeader.acceptor.setHandler(HubHeader.minaClientHandler);
        HubHeader.acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);
    }

    public void start() throws IOException {
        String msg1 = "Server starting " + HubHeader.getConfig().getServerPort();
        String msg2 = "Server started on " + HubHeader.getConfig().getServerPort();

        logger.info(msg1);
        HubHeader.acceptor.bind(new InetSocketAddress(HubHeader.getConfig().getServerPort()));
        logger.info(msg2);
    }
}
