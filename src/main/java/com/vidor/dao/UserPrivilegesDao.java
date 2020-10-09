package com.vidor.dao;

import com.vidor.entity.UserPrivileges;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPrivilegesDao {
    int insert(UserPrivileges record);

    List<UserPrivileges> selectAll();

    List<UserPrivileges> selectByLimit(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    int selectByLimitCount();
}