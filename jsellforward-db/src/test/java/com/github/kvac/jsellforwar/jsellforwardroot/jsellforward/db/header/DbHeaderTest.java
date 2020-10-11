/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.db.network.MinaClientHandler;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.configs.DbConfig;
import java.io.File;
import java.lang.invoke.MethodHandles;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jdcs_dev
 */
public class DbHeaderTest {

    static Logger testLogger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public DbHeaderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetROOT_DIR() {
        testLogger.info("getROOT_DIR");
        File expResult = new File("DbFiles");
        File result = DbHeader.getROOT_DIR();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetConfigFile() {
        testLogger.info("getConfigFile");
        File expResult = new File("DbFiles", "config.yml");
        File result = DbHeader.getConfigFile();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetConfig() {
        testLogger.info("getConfig");
        DbConfig expResult = null;
        DbConfig result = DbHeader.getConfig();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetConfig() {
        testLogger.info("setConfig");
        DbConfig config = null;
        DbHeader.setConfig(config);
    }

    @Test
    public void testGetConnector() {
        testLogger.info("getConnector");
        NioSocketConnector expResult = DbHeader.getConnector();

        NioSocketConnector result = DbHeader.getConnector();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetConnector() {
        testLogger.info("setConnector");
        NioSocketConnector connector = null;
        DbHeader.setConnector(connector);
    }

    @Test
    public void testGetMinaClientHandler() {
        testLogger.info("getMinaClientHandler");
        MinaClientHandler expResult = new MinaClientHandler();
        MinaClientHandler result = DbHeader.getMinaClientHandler();
        assertEquals(expResult.getClass(), result.getClass());
    }

}
