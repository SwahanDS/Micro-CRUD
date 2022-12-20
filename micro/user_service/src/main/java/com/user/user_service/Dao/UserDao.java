package com.user.user_service.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.user_service.entity.User;

public interface UserDao extends JpaRepository<User, String>{
    
}
