package com.kaz.spring.mvc_hibernate_aop.dao;

import com.kaz.spring.mvc_hibernate_aop.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveNewUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);

}
