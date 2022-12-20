package com.contact.contact_service.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.contact_service.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
