package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.utils;

import java.io.File;
import lombok.Getter;

public class Config {

    @Getter
    private File repoPath = new File("path/to/repo/");
    @Getter
    private File savePath = new File("path/to/COMPLETE");

    @Getter
    private String[] branch = new String[]{"main", "dev"};
    @Getter
    private String[] modules = new String[]{"authd", "client", "db", "hub", "sshd"};
    @Getter
    private String javaCMD = "java ";
    @Getter
    private String javaARGS = " -Xms256m -Xmx2048m ";

}
