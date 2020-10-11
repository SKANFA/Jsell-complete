package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header;

import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header.windows.WindowsHeader;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header.network.NetWorkHeader;
import com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.client.header.files.ClientFilesHeader;
import lombok.Getter;

public class ClientHeader {

    private ClientHeader() {
    }
    @Getter
    static final ClientFilesHeader CLIENT_FILES_HEADER = new ClientFilesHeader();
    @Getter
    static final WindowsHeader CLIENT_WINDOWS_HEADER = new WindowsHeader();
    @Getter
    static final NetWorkHeader CLIENT_NETWORK_HEADER = new NetWorkHeader();
}
