package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header.windows.WindowsHeader;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header.network.NetWorkHeader;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header.files.ClientFilesHeader;
import java.lang.invoke.MethodHandles;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHeaderTest {

    static Logger testLogger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ClientHeaderTest() {
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
    public void testGetCLIENT_FILES_HEADER() {

        testLogger.info("getCLIENT_FILES_HEADER");
        ClientFilesHeader expResult = ClientHeader.getCLIENT_FILES_HEADER();
        ClientFilesHeader result = ClientHeader.getCLIENT_FILES_HEADER();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetCLIENT_WINDOWS_HEADER() {
        testLogger.info("getCLIENT_WINDOWS_HEADER");
        WindowsHeader expResult = ClientHeader.getCLIENT_WINDOWS_HEADER();
        WindowsHeader result = ClientHeader.getCLIENT_WINDOWS_HEADER();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCLIENT_NETWORK_HEADER() {
        testLogger.info("getCLIENT_NETWORK_HEADER");
        NetWorkHeader expResult = ClientHeader.getCLIENT_NETWORK_HEADER();
        NetWorkHeader result = ClientHeader.getCLIENT_NETWORK_HEADER();
        assertEquals(expResult, result);
    }

}
