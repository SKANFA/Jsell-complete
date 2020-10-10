package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.network.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jdcs_dev
 */
public class MinaClientHandler extends IoHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("messageReceived");
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
    }

}
