package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.network;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.header.DbHeader;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.Route;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.requests.ApplicationIdentificationPacket;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinaClientHandler extends IoHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        //IDENT
        if (message instanceof ApplicationIdentificationPacket) {
            ApplicationIdentificationPacket identificationPacket = (ApplicationIdentificationPacket) message;
            Route.NodeType from = identificationPacket.getRoute().getFrom();
            Route.NodeType to = identificationPacket.getRoute().getTo();
            logger.info(from + "->" + to);

            identificationPacket.getAnswered().setId(DbHeader.getConfig().getId());
            identificationPacket.setNodeType(Route.NodeType.DB); //
            identificationPacket.setAnswer(true);
            session.write(identificationPacket);
        }
        //IDENT

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

}
