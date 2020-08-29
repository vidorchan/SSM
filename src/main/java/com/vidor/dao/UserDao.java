package com.vidor.dao;

import com.vidor.entity.User;
import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
}