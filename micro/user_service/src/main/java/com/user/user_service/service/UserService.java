package com.user.user_service.service;

import java.util.List;

import com.user.user_service.entity.AddResponse;
import com.user.user_service.entity.User;

public interface UserService {

    //public User getUser(Long id);
    public void initUser();
    public User getUser(String key);
    public List<User> getAllUsers();
    public User registerNewUser(User user);
    public AddResponse deleteUser(String userName);
    public User updateUser(User user);
}
