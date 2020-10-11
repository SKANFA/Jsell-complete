package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Route implements Serializable {

    public enum NodeType {
        HUB,
        DB,
        AUTHD,
        ORDERS,
        WEB,
        SSHD,
        CLIENT,

    }

    @Getter
    @Setter
    private NodeType from;
    @Getter
    @Setter
    private NodeType to;

}
