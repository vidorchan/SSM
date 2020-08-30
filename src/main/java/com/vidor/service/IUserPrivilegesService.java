package com.vidor.service;

import com.vidor.entity.UserPrivileges;

import java.util.List;

public interface IUserPrivilegesService {
    public List<UserPrivileges> getAllUserUserPrivileges();
    public List<UserPrivileges> getUserPrivilegesByPage(int pageNum, int pageSize);
}
