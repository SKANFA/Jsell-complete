package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.authd.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Client;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client.Profile;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.configs.AuthDConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Getter;
import lombok.Setter;

public class AuthdHeader {

    private AuthdHeader() {
    }
    @Getter
    static final CopyOnWriteArrayList<Profile> profiles = new CopyOnWriteArrayList<>();
    @Getter
    static final CopyOnWriteArrayList<Client> clients = new CopyOnWriteArrayList<>();

    @Getter
    @Setter
    static NetWorkHeader netWorkHeader = new NetWorkHeader();

    @Getter
    @Setter
    private static AuthDConfig config = new AuthDConfig();
}
