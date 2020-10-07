package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@DatabaseTable(tableName = "profiles")
public class Profile implements Serializable {

    @Getter
    @Setter
    @DatabaseField(id = true, unique = true, columnName = "login")
    private String login;
    @Getter
    @Setter
    @DatabaseField
    private String secret;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Profile{login=").append(login);
        if (secret != null) {
            sb.append(", secretSize=").append(secret.length());
        }
        sb.append('}');
        return sb.toString();
    }

}
