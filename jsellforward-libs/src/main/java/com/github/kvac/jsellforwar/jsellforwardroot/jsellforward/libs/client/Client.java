package com.github.kvac.jsellforwar.jsellforwardroot.jsellforward.libs.client;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;

@DatabaseTable(tableName = "profiles")
public class Client {

    @Getter
    @Setter
    @DatabaseField(id = true, unique = true, columnName = "id")
    private String id;

    @Getter
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private final Profile profile = new Profile();

}
