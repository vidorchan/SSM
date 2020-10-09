package com.vidor.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPrivileges {
    private String grantee;

    private String tableCatalog;

    private String privilegeType;

    private String isGrantable;
}