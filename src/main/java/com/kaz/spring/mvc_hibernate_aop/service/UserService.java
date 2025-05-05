package com.kaz.spring.mvc_hibernate_aop.service;

import com.kaz.spring.mvc_hibernate_aop.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveNewUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);


}
