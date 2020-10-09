package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Init {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        Init init = new Init();
        try {
            init.initConfig();
            for (String branch : HEADER.getConfig().getBranch()) {
                init.createConfigs(branch);
            }
        } catch (ConfigException | IOException e) {
            init.logger.error("init", e);
        }
    }

    private void initConfig() throws IOException, ConfigException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        if (!HEADER.getCONFIG_FILE().exists()) {
            HEADER.getCONFIG_FILE().getParentFile().mkdirs();
            mapper.writeValue(HEADER.getCONFIG_FILE(), HEADER.getConfig());
            throw new ConfigException("Edit config" + HEADER.getCONFIG_FILE());
        }
        HEADER.setConfig(mapper.readValue(HEADER.getCONFIG_FILE(), Config.class));
    }

    private void createConfigs(String branch) throws IOException {
        createBashs(branch);
    }

    private void createBashs(String branch) throws IOException {
        logger.info(branch);

        File repoPath = HEADER.getConfig().getRepoPath();
        File savePath = HEADER.getConfig().getSavePath();

        File bashDir = new File(savePath, "bash");
        File bashBranchDir = new File(bashDir, branch);

        bashBranchDir.mkdirs();

        //./jsellforward-db/target/jsellforward-db-1.0-SNAPSHOT-*-jar-with-dependencies.jar
        for (String module : HEADER.getConfig().getModules()) {
            File jarFile = findFile(repoPath, module);
            createInitForModule(bashBranchDir, module, jarFile);
        }

    }

    private File findFile(File repoPath, String module) throws FileNotFoundException {
        File[] listModules = repoPath.listFiles((File dir, String name) -> {
            dir.getClass();//IGNORE
            return name.toLowerCase().contains(module.toLowerCase());
        });

        //  ROOT/jsellforward-$module/
        for (File listModule : listModules) {
            File targetDir = new File(listModule, "target");
            //  ROOT/jsellforward-$module/target/jsellforward-$module*jar-with-dependencie*
            File[] targetListWithDep = targetDir.listFiles((File dir, String name) -> {
                dir.getClass();
                String ntLC = name.toLowerCase();
                String testName1 = ("jsellforward-" + module).toLowerCase();
                String testName2 = "jar-with-dependencie".toLowerCase();
                return ntLC.contains(testName1) && ntLC.contains(testName2);
            });

            if (targetListWithDep.length == 1) {
                return targetListWithDep[0];
            } else {
                throw new FileNotFoundException("repo:" + repoPath + " module:" + module);
            }
        }
        return null;
    }

    private void createInitForModule(File bashBranchDir, String module, File jarFile) throws IOException {
        File moduleInitDir = new File(bashBranchDir, module);
        moduleInitDir.mkdirs();
        File moduleInitFile = new File(moduleInitDir, "start-" + module + ".sh");

        try {
            Files.createFile(moduleInitFile.toPath());
        } catch (java.nio.file.FileAlreadyExistsException e) {
            e.getClass();
        } catch (IOException e) {
            logger.error(module + ":" + moduleInitFile, e);
        }

        StringBuilder initContent = new StringBuilder();
        initContent.append(HEADER.getConfig().getJavaCMD());
        initContent.append(HEADER.getConfig().getJavaARGS());
        initContent.append(" -jar ");
        initContent.append(jarFile);

        Files.writeString(
                moduleInitFile.toPath(),
                initContent.toString(),
                StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING
        );

        Set<PosixFilePermission> pfpSet = new HashSet<>();
        pfpSet.add(PosixFilePermission.OWNER_READ);
        pfpSet.add(PosixFilePermission.OWNER_WRITE);
        pfpSet.add(PosixFilePermission.OWNER_EXECUTE);
        pfpSet.add(PosixFilePermission.GROUP_READ);
        Files.setPosixFilePermissions(moduleInitFile.toPath(), pfpSet);

    }
}
