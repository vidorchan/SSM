package com.vidor.service.impl;

import com.vidor.dao.UserDao;
import com.vidor.dao.UserPrivilegesDao;
import com.vidor.entity.User;
import com.vidor.entity.UserPrivileges;
import com.vidor.service.IUserPrivilegesService;
import com.vidor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService, IUserPrivilegesService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPrivilegesDao userPrivilegesDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<UserPrivileges> getAllUserUserPrivileges() {
        return userPrivilegesDao.selectAll();
    }
}
