package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.utils;

import java.io.File;
import lombok.Getter;
import lombok.Setter;

public class HEADER {

    private HEADER() {
    }

    @Getter
    static final File ROOT_DIR = new File("createrinitscripts");

    @Getter
    static final File CONFIG_FILE = new File(ROOT_DIR, "config.yml");

    @Getter
    @Setter
    static Config config = new Config();

}
