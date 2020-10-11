package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.configs;

import lombok.Getter;
import lombok.Setter;

public class HubConfig {

    @Getter
    @Setter
    private String hubHost = "127.0.0.1";
    @Getter
    @Setter
    private int hubPort = 40000;

}
