package com.contact.contact_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.contact_service.Dao.RoleDao;
import com.contact.contact_service.entity.Role;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public void initRole(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);
    }

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }

    public Role getUserRole(String userRole)
    {
        return roleDao.findById(userRole).get();
    }
}