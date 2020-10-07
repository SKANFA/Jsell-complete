package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.network.distribution;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.SerializableArrayList;
import java.io.Serializable;
import lombok.Getter;

public class DistributionPacket implements Serializable {

    @Getter
    private final SerializableArrayList<Object> data = new SerializableArrayList<>();

}
