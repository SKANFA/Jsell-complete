package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.config.HubConfig;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.hub.header.HubHeader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HubInit {

    @Getter
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        HubInit hi = new HubInit();
        try {
            hi.initConfigs();
            hi.initNetWork();
        } catch (Exception e) {
            hi.logger.error("ERROR", e);
        }
    }

    private void initConfigs() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        if (!HubHeader.getConfigFile().exists()) {
            //DIR
            HubHeader.getConfigFile().getParentFile().mkdirs();

            //CONFIG
            Files.createFile(HubHeader.getConfigFile().toPath());
            mapper.writeValue(HubHeader.getConfigFile(), HubHeader.getConfig());

            Set<PosixFilePermission> pfpSet = new HashSet<>();
            pfpSet.add(PosixFilePermission.OWNER_READ);
            pfpSet.add(PosixFilePermission.OWNER_WRITE);
            pfpSet.add(PosixFilePermission.OWNER_EXECUTE);
            Files.setPosixFilePermissions(HubHeader.getConfigFile().toPath(), pfpSet);

            throw new ExceptionInInitializerError("Edit config: " + HubHeader.getConfigFile());
        }
        HubHeader.setConfig(mapper.readValue(HubHeader.getConfigFile(), HubConfig.class));
    }

    private void initNetWork() throws IOException {
        HubHeader.getHubNetworkHeader().getHubServer().init();
        HubHeader.getHubNetworkHeader().getHubServer().start();

    }
}
