package com.vidor.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vidor.dao.UserDao;
import com.vidor.dao.UserPrivilegesDao;
import com.vidor.entity.User;
import com.vidor.entity.UserPrivileges;
import com.vidor.service.IUserPrivilegesService;
import com.vidor.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService, IUserPrivilegesService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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

    public List<UserPrivileges> getUserPrivilegesByPage(int pageNum, int pageSize) {
//        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<UserPrivileges> list = userPrivilegesDao.selectByLimit(pageNum, pageSize);
        // 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
//        long total = page.getTotal();
//        logger.debug("总共条数: " + total);
//        System.out.println("总共条数: " + total);
        return list;
    }
}
