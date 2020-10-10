package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.authd.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Client;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Profile;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Getter;

public class AuthdHeader {

    private AuthdHeader() {
    }
    @Getter
    static final CopyOnWriteArrayList<Profile> profiles = new CopyOnWriteArrayList<>();
    @Getter
    static final CopyOnWriteArrayList<Client> clients = new CopyOnWriteArrayList<>();
}
