package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network.handler;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Client;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.Route;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.requests.ApplicationIdentificationPacket;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.sessions.SessionsVar;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaClientHandler extends IoHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        if (message instanceof ApplicationIdentificationPacket) {
            ApplicationIdentificationPacket aip = (ApplicationIdentificationPacket) message;
            if (aip.isAnswer()) {
                Client answered = aip.getAnswered();
                Route.NodeType nodeType = aip.getNodeType();
                session.setAttribute(SessionsVar.CLIENT, answered);
                session.setAttribute(SessionsVar.NODETPE, nodeType);
                logger.info("ident complete");
            } else {
                logger.info("ASKED WHO HUB");
            }
        } else {
            logger.info("messageReceived");
        }
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.warn("exceptionCaught", cause);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("sessionIdle");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("sessionClosed");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("sessionOpened");
        //IDENT
        ApplicationIdentificationPacket identificationPacket = new ApplicationIdentificationPacket();
        identificationPacket.getRoute().setFrom(Route.NodeType.HUB);
        identificationPacket.setAnswer(false);
        session.write(identificationPacket);
        //IDENT
    }

}
